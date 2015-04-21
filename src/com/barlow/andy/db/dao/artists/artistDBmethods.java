package com.barlow.andy.db.dao.artists;
import com.barlow.andy.db.ConnectionUtil;
import com.barlow.andy.db.entities.artist.Artist;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 4/8/2015.
 *      artistDBmethods keeps the dao methods seperate from the artist class for future ease of use.
 *
 *
 *      contactCreateTable() <-- create table in DB if not exist
 *      List<Contact> selectAll() <-- lists all contacts in db
 *      insert() <-- instead of "save();"
 *      update() <-- update method seperate from save()/insert() for cleaner solution
 *
 *
 *
 *
 *          contactCreateTable();
 *              Creates a contacts table in the DB if it doesnt exist.
 *              Sets up columns for int id, first_name varchar(100) and last_name varchar(100).
 *
 *          insert();
 *              insert is the DB insert function. inserts Contact object taken as parameter.
 *              Inserts first_name and last_name up to length of 100 into DB. int id is auto_increment so not included here.
 *
 *          delete();
 *              delete is the DB delete function. It deletes row from database where id = id that is passed as int parameter.
 *              int id is unique so allows for correct deletion of record rather than deleting by first_name/last_name which could be duplicated.
 *
 *          selectAll();
 *              method allows all records to be displayed in format of id, first_name, last_name. Just used for display / test purposes.
 *
 *          update();
 *              update method allows the updating of previously saved info in the contact DB. it takes a contact object of the updated data and the unique id of the contact to be updated.
 *
 */


public class artistDBmethods implements iArtistDBmethods {
    @Override
    public void artistCreateTable() {
        Connection c = null;
        Statement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.createStatement();

            sql.execute("CREATE TABLE IF NOT EXISTS artist (id integer primary key unique, artist_name varchar(100), first_name varchar(100), last_name varchar(100))");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sql != null) {
                try {
                    sql.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Override
    public void insert(Artist artist) {
        Connection c = null;
        PreparedStatement preparedStatement = null;

        try {
            c = ConnectionUtil.getConnection();
            preparedStatement = c.prepareStatement("INSERT INTO artist(artist_name, first_name, last_name)"
                    + "Values(?,?,?)");
            preparedStatement.setString(1, artist.getArtistName());
            preparedStatement.setString(2, artist.getFirstName());
            preparedStatement.setString(3, artist.getLastName());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO artist(artist_name, first_name, last_name)"
                    + "Values(" + artist.getArtistName() + ","+ artist.getFirstName() + ","  + artist.getLastName() + ")");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    @Override
    public List<Artist> selectAll() {
        List<Artist> artists = new ArrayList<Artist>();
        Connection c = null;
        Statement sql = null;
        ResultSet result = null;
        try {
            c = ConnectionUtil.getConnection();
            sql = c.createStatement();
            result = sql.executeQuery("SELECT * FROM artist");

            while (result.next()) {
                Artist artist = new Artist();
                artist.setID(result.getInt("id"));
                artist.setArtistName(result.getString("artist_name"));
                artist.setFirstName(result.getString("first_name"));
                artist.setLastName(result.getString("last_name"));

                artists.add(artist);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (sql != null) {
                try {
                    sql.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return artists;
    }

    @Override
    public void delete(String artistToDelete) {
        Connection c = null;
        PreparedStatement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.prepareStatement("DELETE FROM artist WHERE artist_name = ?");
            sql.setString(1, artistToDelete);
            sql.executeUpdate();
            System.out.println("Deleted: " + artistToDelete);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sql != null) {
                try {
                    sql.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void update(Artist artist, String artistName) {
        Connection c = null;
        PreparedStatement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.prepareStatement("UPDATE artist SET " +
                    "artist_name = ?, first_name = ?, last_name = ? WHERE artist_name = ?");
            sql.setString(1, artist.getArtistName());
            sql.setString(2, artist.getFirstName());
            sql.setString(3, artist.getLastName());
            sql.setString(4, artistName);
            sql.executeUpdate();
            System.out.println("UPDATE artist SET " +
                    "artist_name = " + artist.getArtistName() + " first_name = " + artist.getFirstName() + ", last_name = " + artist.getLastName() +" WHERE artistName =  " + artistName);

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(sql != null) {
                try {
                    sql.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if( c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}