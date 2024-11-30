// IT Number : IT22050908
// Name		 : Premaratne R.A.N.C.

package com.song.model;

public class ShowImage {
    private String image;
    private String title;
    private String artistName;

    public ShowImage(String image, String title, String artistName) {
        this.image = image;
        this.title = title;
        this.artistName = artistName;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}