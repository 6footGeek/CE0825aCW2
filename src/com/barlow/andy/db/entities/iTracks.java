package com.barlow.andy.db.entities;

/**
 * Created by andy on 4/21/2015.
 */
public interface iTracks {
    void trackCreateTable();
    public void setID(int id);
    public int getID();
    public void setArtistName(String artistName);
    public String getArtistName();
    public void setFirstName(String firstName);
    public String getFirstName();
    public void setLastName(String lastName);
    public String getLastName();
}
