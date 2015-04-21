package com.barlow.andy.db.entities.tracks;

/**
 * Created by andy on 4/21/2015.
 */
public class Track implements iTrack {
    protected int id;
    protected int getArtistId;
    protected int getAlbumId;
    protected String trackName;
    protected double trackLength;


    public Track() {
        this.id = Integer.parseInt(null);
        this.getArtistId = Integer.parseInt(null);
        this.getAlbumId = Integer.parseInt(null);
        this.trackName = null;
        this.trackLength = Double.parseDouble(null);

    }

    public Track(int id, int getArtistId, int getAlbumId, String trackName, double trackLength) {

        this.id = id;
        this.getArtistId = getArtistId;
        this.getAlbumId = getAlbumId;
        this.trackName = trackName;
        this.trackLength = trackLength;

    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public int getArtistID() {
        return getArtistId;
    }

    @Override
    public int getAlbumID() {
        return getAlbumId;
    }

    @Override
    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    @Override
    public String getTrackName() {
        return trackName;
    }

    @Override
    public void setTrackLength(double trackLength) {
        this.trackLength = trackLength;
    }

    @Override
    public double getTrackLength() {
        return trackLength;
    }
}
