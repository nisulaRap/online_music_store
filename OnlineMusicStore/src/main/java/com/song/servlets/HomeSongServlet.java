// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.servlets;

import com.song.model.ShowImage;
import com.song.model.ShowImageWithUrl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.mysql.cj.conf.ConnectionUrlParser.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeSongServlet
 */
@WebServlet("/home")
public class HomeSongServlet extends HttpServlet {
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
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create a list to store songs
		List<ShowImage> showImages = new ArrayList<>(); 

		try {
			// Prepare a SQL statement to select all data from the "song" table
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM song");
			
			// Execute the SQL query and retrieve the result set
			ResultSet resultSet = preparedStatement.executeQuery();

			// Iterate through the result set
			while (resultSet.next()) {
				
				// Get image, title, and artist name from each row
				String image = resultSet.getString("image");
				String title = resultSet.getString("title");
				String artistName = resultSet.getString("artist");
				System.out.println("Get data");

				// Create a Song object or Map to hold data
				ShowImage showImage = new ShowImage(image, title, artistName);
				showImages.add(showImage);
			}
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("Error retrieving files from the database.");
			return;
		}

		List<String> imageUrls = new ArrayList<>();
		for (ShowImage showimage : showImages) {
			// Construct the full URL for each image
			String imageUrl = request.getContextPath() + "/images/" + showimage.getImage();
			
			// Add the image URL to the list
			imageUrls.add(imageUrl); 
		}

		// Create a combined list to hold ShowImage objects with their corresponding image URLs
		List<ShowImageWithUrl> combinedList = new ArrayList<>();
		for (int i = 0; i < showImages.size(); i++) {
			
			// Create a ShowImageWithUrl object by pairing each ShowImage with its corresponding URL
			combinedList.add(new ShowImageWithUrl(showImages.get(i), imageUrls.get(i)));
		}

		// Set the combined list as an attribute in the request
		request.setAttribute("combinedList", combinedList);

		System.out.println("done");
		request.getRequestDispatcher("/index.jsp").forward(request, response);
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