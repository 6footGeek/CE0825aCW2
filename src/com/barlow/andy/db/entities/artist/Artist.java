package com.barlow.andy.db.entities.artist;

/**
 * Created by andy on 4/8/2015.
 *
 *      My version of a Contact class using OOP
 *      This class takes care of the getters and setters for the Contact object.
 *
 *      int id;
 *      String firstName;
 *      String lastName;
 *
 *
 *      Removed 2 methods from interface as seemed better to keep them in a seperate class -
 *      the following methods are now located in artistDBmethods.java
 *
 *      void save(); (also renamed to insert())
 *      void delete();
 *
 */


public class Artist implements iArtist {
    protected int id;
    protected String artistName;
    protected String firstName;
    protected String lastName;


    public Artist() {
        this.artistName = null;
        this.firstName = null;
        this.lastName = null;

    }

    public Artist(String artistName, String firstName, String lastName) {
        this.artistName = artistName;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void setID(int id) {
        this.id = id;
    }


    public int getID() {
        return id;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getLastName() {
        return lastName;
    }


}