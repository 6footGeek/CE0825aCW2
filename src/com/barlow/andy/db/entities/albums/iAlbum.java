package com.barlow.andy.db.entities.albums;

/**
 * Created by andy on 4/22/2015.
 */
public interface iAlbum {
    int getID();

    void setID(int id);

    int getArtistID();

    String getAlbumTitle();

    void setAlbumTitle(String albumTitle);

    int getReleaseYear();

    void setReleaseYear(int releaseYear);

}
