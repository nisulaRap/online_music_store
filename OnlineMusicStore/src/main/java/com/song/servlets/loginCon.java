// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class loginCon
 */
@WebServlet("/loginConServlet")
public class loginCon extends HttpServlet {
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
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username=request.getParameter("uname");
		String password=request.getParameter("pword");
		String message = ""; // Variable to hold the message to be displayed
		
		
		 try{
			// Create a prepared statement to prevent SQL injection
		        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM user WHERE name=? AND password=?");
		        preparedStatement.setString(1, username);
		        preparedStatement.setString(2, password);

		        // Execute the query
		        ResultSet resultSet = preparedStatement.executeQuery();

		        if (resultSet.next()) {
		            // If the user exists in the database, set a success message
		            message = "Login successful";
		            // Redirect the user next to the home page
				    //request.getRequestDispatcher("/indexUpdate.jsp").forward(request, response);
		            
		          //redirect to home servlet
		            request.getRequestDispatcher("/home").forward(request, response);
		        } else {
		            // If the user does not exist or credentials are incorrect, set an error message
		            message = "Invalid username or password";
		            // Redirect the user back to the login page
				    request.getRequestDispatcher("/login.jsp").forward(request, response);
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        // Handle database connection or query errors
		        // Set an error message
		        message = "An error occurred. Please try again.";
		    }

		    // Set the message attribute
		    request.setAttribute("message", message);
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
