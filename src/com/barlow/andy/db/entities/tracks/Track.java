package com.barlow.andy.db.entities.tracks;

/**
 * Created by andy on 4/21/2015.
 */
public class Track implements iTrack {
    protected int id;
    protected int artistId;
    protected int albumId;
    protected String trackName;
    protected double trackLength;


    public Track() {

    }

    public Track(int getArtistId, int getAlbumId, String trackName, double trackLength) {
        this.artistId = getArtistId;
        this.albumId = getAlbumId;
        this.trackName = trackName;
        this.trackLength = trackLength;

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

    public void setArtistID(int artistId) {
        this.artistId = artistId;
    }

    @Override
    public int getAlbumID() {
        return albumId;
    }

    public void setAlbumID(int albumId) {
        this.albumId = albumId;
    }

    @Override
    public String getTrackName() {
        return trackName;
    }

    @Override
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public double getTrackLength() {
        return trackLength;
    }

    @Override
    public void setTrackLength(double trackLength) {
        this.trackLength = trackLength;
    }
}
