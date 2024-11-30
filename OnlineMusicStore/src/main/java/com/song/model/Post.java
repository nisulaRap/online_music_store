// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.model;

// Post interface
// It defines methods for retrieving and setting properties of a post.
public interface Post {
	int getPostID();

	String getComment();

	String getDate();

	void setComment(String comment);

	void setDate(String date);

}
