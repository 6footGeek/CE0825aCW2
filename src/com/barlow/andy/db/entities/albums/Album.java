package com.barlow.andy.db.entities.albums;


/**
 * Created by andy on 4/21/2015.
 *      This class takes care of the getters and setters for the Album object.
 */
public class Album implements iAlbum {
    protected int id;
    protected int artistId;
    protected String albumTitle;
    protected int releaseYear;

    public Album() {


    }

    public Album(int getArtistId, String title, int releaseYear) {
        this.id = id;
        this.artistId = getArtistId;
        this.albumTitle = title;
        this.releaseYear = releaseYear;
    }


    @Override
    public int getID() {
        return id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getArtistID() {
        return artistId;
    }

    @Override
    public String getAlbumTitle() {
        return albumTitle;
    }

    @Override
    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
    }

    @Override
    public int getReleaseYear() {
        return releaseYear;
    }

    @Override
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
