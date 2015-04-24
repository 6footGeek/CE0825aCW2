package com.barlow.andy.db.dao.albums;

import com.barlow.andy.db.ConnectionUtil;
import com.barlow.andy.db.entities.albums.Album;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *       albumDBmethods keeps the dao methods seperate from the album class for future ease of use.
 *
 *
 *      artistCreateTable() <-- create table in DB if not exist
 *      List<Artist> selectAll() <-- lists all contacts in db
 *      insert() <-- insert method
 *      update() <-- update method
 *
 *
 *
 *
 *          albumCreateTable();
 *              Creates a contacts table in the DB if it doesnt exist.
 *              Sets up columns for int id, first_name varchar(100) and last_name varchar(100).
 *
 *          insert();
 *              insert is the DB insert function. inserts album object taken as parameter.
 *
 *
 *          delete();
 *              delete is the DB delete function. It deletes row from database where id = id that is passed as int parameter.
 *
 *
 *          selectAll();
 *              method allows all records to be displayed in format of appropriate data fields. Just used for display / test purposes.
 *
 *          update();
 *              update method allows the updating of previously saved info in the contact DB. it takes an object of the updated data and the unique id of the contact to be updated.
 *
 */

public class albumDBmethods implements iAlbumDBmethods {
    @Override
    public void albumCreateTable() {
        Connection c = null;
        Statement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.createStatement();

            sql.execute("CREATE TABLE IF NOT EXISTS album (id integer primary key unique, album_title varchar(100), release_year INTEGER, artist_id INTEGER)");
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
    public void insert(Album album) {
        Connection c = null;
        PreparedStatement preparedStatement = null;

        try {
            c = ConnectionUtil.getConnection();
            preparedStatement = c.prepareStatement("INSERT INTO album(album_title, release_year, artist_id)"
                    + "Values(?,?,?)");
            preparedStatement.setString(1, album.getAlbumTitle());
            preparedStatement.setInt(2, album.getReleaseYear());
            preparedStatement.setInt(3, album.getArtistID());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO album + "
                    + "Values(" + album.getAlbumTitle() + "," + album.getReleaseYear());
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
    public List<Album> selectAll() {
        List<Album> albums = new ArrayList<Album>();
        Connection c = null;
        Statement sql = null;
        ResultSet result = null;
        try {
            c = ConnectionUtil.getConnection();
            sql = c.createStatement();
            result = sql.executeQuery("SELECT * FROM album");

            while (result.next()) {
                Album album = new Album();
                album.setID(result.getInt("id"));
                album.setAlbumTitle(result.getString("album_title"));
                album.setReleaseYear(result.getInt("release_year"));

                albums.add(album);
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

        return albums;
    }

    @Override
    public void delete(String albumToDelete) {
        Connection c = null;
        PreparedStatement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.prepareStatement("DELETE FROM album WHERE album_title = ?");
            sql.setString(1, albumToDelete);
            sql.executeUpdate();
            System.out.println("Deleted: " + albumToDelete + " album..");

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
    public void update(Album album, String albumName) {
        Connection c = null;
        PreparedStatement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.prepareStatement("UPDATE album SET " +
                    "album_title = ?, release_year = ? WHERE album_title = ?");
            sql.setString(1, album.getAlbumTitle());
            sql.setInt(2, album.getReleaseYear());
            sql.setString(3, albumName);
            sql.executeUpdate();
            System.out.println("UPDATE album SET " +
                    "album title = " + album.getAlbumTitle() + " release year = " + album.getReleaseYear() + " WHERE album name =  " + albumName);

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
}

