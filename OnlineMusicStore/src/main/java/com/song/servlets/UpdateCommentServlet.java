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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Servlet implementation class UpdateCommentServlet
 */
@WebServlet("/updateServlet")
public class UpdateCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
    
    public void init() {
    	try {
    		System.out.println("init()");
    		Class.forName("com.mysql.jdbc.Driver");
    		connection = DriverManager.getConnection("jdbc:mysql://localhost/musicdb","root","root123");
    		
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		
		// Get parameters from the request
		String postIdToEdit = request.getParameter("postID");
		String edit = request.getParameter("editcomment");
		System.out.println(postIdToEdit);
		
		try {
			// Create a prepared statement to update the post comment in the database
			PreparedStatement preparedStatement = connection.prepareStatement("UPDATE post SET comment = ? WHERE postID = ?");
	        preparedStatement.setString(1, edit); // Set the new comment value
	        preparedStatement.setString(2, postIdToEdit); //Set the postID to identify the post to update
	        
	        int result = preparedStatement.executeUpdate();
			
			PrintWriter out = response.getWriter();
			
			// Check if the update was successful or not
			if(result > 0) {
				out.print("<h1>Comment Updated..</h1>");
				//out.print("<script>window.location = \"searchServlet\";</script>");
			}else {
				out.print("<h1>Error Creating the Comment..</h1>");
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

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
