// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.model;

public class SongDetailUrl {
	private SongDetail musicDetail;
	private String imageUrl;
	private String audioUrl;

	public SongDetailUrl(SongDetail musicDetail, String imageUrl, String audioUrl) {
		this.musicDetail = musicDetail;
		this.imageUrl = imageUrl;
		this.audioUrl = audioUrl;
	}

	public SongDetail getMusicDetail() {
		return musicDetail;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getAudioUrl() {
		return audioUrl;
	}

}
