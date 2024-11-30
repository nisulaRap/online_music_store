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
 * Servlet implementation class DeleteCommentServlet
 */
@WebServlet("/deleteServlet")
public class DeleteCommentServlet extends HttpServlet {
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
		
		// Extract postID data from the request
		String postIdToDelete = request.getParameter("postID");
		System.out.println(postIdToDelete);
		
		try {
			
			// Create a JDBC statement
			Statement statement = connection.createStatement();
			
			// Execute the SQL delete query to delete the post with the given postID.
			int result = statement.executeUpdate("delete from post where postID='" + postIdToDelete + "'");
			System.out.println(postIdToDelete);
			
			// Get PrintWriter object to send response
			PrintWriter out = response.getWriter();
			
			// Check if deletion result was successful or not
			if(result > 0) {
				out.print("<h1>Comment deleted..</h1>");
				//out.print("<script>window.location = \"searchServlet\";</script>");
			}else {
				out.print("<h1>Comment not found in the database..</h1>");
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
    // Destruction method called by the servlet container
	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
