// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Servlet implementation class CreateCommentServlet
 */
@WebServlet("/createServlet")
public class CreateCommentServlet extends HttpServlet {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost()");

		// Get comment data from the request
		String post = request.getParameter("comment");
		System.out.println(post);

		try {
			// Create a JDBC statement
			Statement statement = connection.createStatement();

			// Execute SQL INSERT statement to insert the comment into the database
			int result = statement.executeUpdate("insert into post(comment) values('" + post + "')");
			System.out.println(post);

			// Get PrintWriter object to send response
			PrintWriter out = response.getWriter();

			// Check if comment creation was successful
			if (result > 0) {
				out.print("<h1>Comment Created..</h1>");
				// out.print("<script>window.location = \"searchServlet\"</script>");
			} else {
				out.print("<h1>Error Creating the Comment..</h1>");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Destruction method called by the servlet container
	public void destroy() {
		try {
			// Close the database connection
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
