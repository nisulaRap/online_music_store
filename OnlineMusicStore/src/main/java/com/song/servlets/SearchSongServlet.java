// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.song.model.SearchPagePost;
//import com.song.model.ShowImage;
//import com.song.model.ShowImageWithUrl;
import com.song.model.SongDetail;
import com.song.model.SongDetailUrl;

@WebServlet("/searchServlet")
public class SearchSongServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    //Declare a private Connection variable named 'connection'
    private Connection connection;

    //Define a method named 'init', which doesn't return anything (void)
    public void init() {
        try {
        	
        	// Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish a connection to the MySQL database
            connection = DriverManager.getConnection("jdbc:mysql://localhost/musicdb", "root", "root123");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// Initialize lists to hold search results and post details
        List<SearchPagePost> searchpage = new ArrayList<>();
        List<SongDetail> songdetail = new ArrayList<>();
        
        // Get search parameter from request
        String search = request.getParameter("find");
        
        try {        	
        	// Prepare SQL statement to search for songs by title
        	PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM song WHERE title = ?");
        	
        	// Set the search parameter
		    preparedStatement.setString(1, search); 
		    ResultSet resultSet2 = preparedStatement.executeQuery();
		    
		    while (resultSet2.next()) {				
		        String title = resultSet2.getString("title");
		        String image = resultSet2.getString("image");
		        String artistName = resultSet2.getString("artist");
		        String audio = resultSet2.getString("audio_url");
		        
		        // Create a MusicDetails object to hold data
		        SongDetail musicDetail = new SongDetail(title, image, artistName, audio);
		        // Add the MusicDetails to the list
		        songdetail.add(musicDetail); 
		    }
        }catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().println("Error retrieving files from the database.");
			return;
		}
        
        // Generate full URLs for audio files
        List<String> audioUrls = new ArrayList<>();
		for (SongDetail musicDetail : songdetail) {
			// Construct the full URL for each audio
			String audioUrl = request.getContextPath() + "/audio/" + musicDetail.getAudio();
			
			// Add the audio URL to the list
			audioUrls.add(audioUrl); 
		}
		
		// Generate full URLs for image files
		List<String> imageUrls = new ArrayList<>();
		for (SongDetail musicDetail : songdetail) {
			// Construct the full URL for each image
			String imageUrl = request.getContextPath() + "/images/" + musicDetail.getImage();
			
			// Add the image URL to the list
			imageUrls.add(imageUrl); 
		}
		
		// Combine song details with image and audio URLs
		List<SongDetailUrl> combinedList = new ArrayList<>();
		for (int i = 0; i < songdetail.size(); i++) {
			combinedList.add(new SongDetailUrl(songdetail.get(i), imageUrls.get(i), audioUrls.get(i)));
			
		}

        try {
        	// Get all posts from the database
            PreparedStatement statement = connection.prepareStatement("select * from post");
            ResultSet resultSet = statement.executeQuery();

            // Iterate through posts and create SearchPagePost objects
            while (resultSet.next()) {
            	int postID = resultSet.getInt("postID");
                String comment = resultSet.getString("comment");
                String date = resultSet.getString("date");

                // Create a SearchPagePost object to hold post details
                SearchPagePost searchPagePost = new SearchPagePost(comment, date, postID);
                // Add the SearchPagePost to the list
                searchpage.add(searchPagePost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        // Set attributes for JSP rendering
        request.setAttribute("showAllDetails", combinedList);        
        request.setAttribute("searchpage", searchpage);
        request.getRequestDispatcher("/search.jsp").forward(request, response);
    }

	// Destruction method called by the servlet container
    public void destroy() {
        try {
        	// Close the database connection
        	connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}