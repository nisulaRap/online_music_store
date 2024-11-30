// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.model;

public class SongDetail {
	private String title;
	private String image;
	private String artist;
	private String audio;

	public SongDetail(String title, String image, String artist, String audio) {
		this.title = title;
		this.image = image;
		this.artist = artist;
		this.audio = audio;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

}
