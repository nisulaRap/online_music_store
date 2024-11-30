// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.model;

//Define a class named SearchPagePost which implements the Post interface
public class SearchPagePost implements Post {
	private int postID;
	private String comment;
	private String date;

	// Constructor with comment and date parameters
	public SearchPagePost(String comment, String date) {
		this.comment = comment;
		this.date = date;
	}

	// Constructor with comment, date, and postID parameters
	public SearchPagePost(String comment, String date, int postID) {
		this.comment = comment;
		this.date = date;
		this.postID = postID;
	}

	// Getter and Setter method
	public int getpostID() {
		return postID;
	}

	public void setpostID(int postID) {
		this.postID = postID;
	}

	public String getComment() {
		return comment;
	}

	public String getDate() {
		return date;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setDate(String date) {
		this.date = date;
	}

	// Overridden method from the Post interface to get the post ID
	@Override
	public int getPostID() {
		// TODO Auto-generated method stub
		return 0;
	}
}