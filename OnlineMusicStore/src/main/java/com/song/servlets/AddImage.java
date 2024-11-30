// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddImage
 */

//Annotation to indicate that this servlet handles multipart/form-data requests
@MultipartConfig

//Annotation to specify the servlet mapping URL
@WebServlet("/AddImage")
public class AddImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Connection connection;

	public void init() {
		try {
			System.out.println("init()");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/musicdb", "root", "root123");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		System.out.println("Add image servlet");

		// Get the image and audio files from the request
		Part file = request.getPart("image");
		String title1 = request.getParameter("title");
		String artist1 = request.getParameter("artist");
		Part file2 = request.getPart("audio");

		// get selected image file name
		String imageFileName = file.getSubmittedFileName();
		System.out.println("Selected Image File Name : " + imageFileName);

		// get selected audio file name
		String audioFileName = file2.getSubmittedFileName();
		System.out.println("Selected Audio File Name : " + audioFileName);

		// Define the upload paths for the image and audio files
		String uploadPath = "D:/Nisula/SLIIT/Year 2/Semester 1/Projects/OOP/Online Music Store/src/main/webapp/images/"
				+ imageFileName; // upload path where we have to upload our actual image
		System.out.println("Upload Path : " + uploadPath);

		String audioPath = "D:/Nisula/SLIIT/Year 2/Semester 1/Projects/OOP/Online Music Store/src/main/webapp/audio/"
				+ audioFileName; // upload path where we have to upload our actual audio
		System.out.println("Audio Path : " + audioPath);

		try {
			// Upload the selected image into images folder
			FileOutputStream fos = new FileOutputStream(uploadPath);
			InputStream is = file.getInputStream();

			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();

			// Upload the selected audio into audio folder
			FileOutputStream fos2 = new FileOutputStream(audioPath);
			InputStream is2 = file2.getInputStream();

			byte[] data2 = new byte[is2.available()];
			is2.read(data2);
			fos2.write(data2);
			fos2.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// Prepare a SQL statement for inserting data into the database
			PreparedStatement stmt;
			String query = "insert into song(image, title, artist, audio_url) values(?, ?, ?, ?)";
			stmt = connection.prepareStatement(query);
			stmt.setString(1, imageFileName);
			stmt.setString(2, title1);
			stmt.setString(3, artist1);
			stmt.setString(4, audioFileName);

			// it returns no of rows affected.
			int rows = stmt.executeUpdate();

			// Check if the data was successfully added to the database
			if (rows > 0) {
				System.out.println("Data added into database successfully.");
			} else {
				System.out.println("Failed to upload data.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
