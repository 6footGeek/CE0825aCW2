package com.barlow.andy.db.entities.artist;

/**
 * Created by andy on 4/8/2015.
 *
 *
 *      This class takes care of the getters and setters for the Artist object.
 *
 *
 */


public class Artist implements iArtist {
    protected int id;
    protected String artistName;
    protected String firstName;
    protected String lastName;


    public Artist() {

    }

    public Artist(String artistName, String firstName, String lastName) {
        this.artistName = artistName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}