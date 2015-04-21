package com.barlow.andy.db.entities.tracks;

/**
 * Created by andy on 4/21/2015.
 */
public interface iTrack {
    public void setID(int id);

    public int getID();

    public int getArtistID();

    public int getAlbumID();

    public void setTrackName(String trackName);
    public String getTrackName();

    public void setTrackLength(double trackLength);
    public double getTrackLength();

}