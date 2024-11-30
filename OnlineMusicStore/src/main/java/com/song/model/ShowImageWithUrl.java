// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.model;

public class ShowImageWithUrl {
	private ShowImage showImage;
	private String imageUrl;

	public ShowImageWithUrl(ShowImage showImage, String imageUrl) {
		this.showImage = showImage;
		this.imageUrl = imageUrl;
	}

	public ShowImage getShowImage() {
		return showImage;
	}

	public String getImageUrl() {
		return imageUrl;
	}
}
