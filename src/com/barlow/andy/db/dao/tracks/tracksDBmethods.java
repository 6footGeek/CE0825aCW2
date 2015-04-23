package com.barlow.andy.db.dao.tracks;

import com.barlow.andy.db.ConnectionUtil;
import com.barlow.andy.db.entities.tracks.Track;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 4/21/2015.
 */
public class tracksDBmethods implements iTracksDBmethods {
    @Override
    public void tracksCreateTable() {
        Connection c = null;
        Statement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.createStatement();

            sql.execute("CREATE TABLE IF NOT EXISTS track (id integer primary key unique, track_name varchar(100), track_length DOUBLE, artist_id INTEGER, album_id INTEGER)");
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
    public void insert(Track track) {
        Connection c = null;
        PreparedStatement preparedStatement = null;

        try {
            c = ConnectionUtil.getConnection();
            preparedStatement = c.prepareStatement("INSERT INTO track(track_name, track_length, artist_id, album_id)"
                    + "Values(?,?,?,?)");
            preparedStatement.setString(1, track.getTrackName());
            preparedStatement.setDouble(2, track.getTrackLength());
            preparedStatement.setInt(3, track.getArtistID());
            preparedStatement.setInt(4, track.getAlbumID());
            preparedStatement.executeUpdate();
            System.out.println("INSERT INTO track");
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
    public List<Track> selectAll() {
        List<Track> tracks = new ArrayList<Track>();
        Connection c = null;
        Statement sql = null;
        ResultSet result = null;
        try {
            c = ConnectionUtil.getConnection();
            sql = c.createStatement();
            result = sql.executeQuery("SELECT * FROM track");

            while (result.next()) {
                Track track = new Track();
                track.setID(result.getInt("id"));
                track.setTrackName(result.getString("track_name"));
                track.setTrackLength(result.getDouble("track_length"));
                track.setAlbumID(result.getInt("album_id"));
                track.setArtistID(result.getInt("artist_id"));

                tracks.add(track);
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

        return tracks;
    }

    @Override
    public void delete(String trackToDelete) {
        Connection c = null;
        PreparedStatement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.prepareStatement("DELETE FROM track WHERE track_name = ?");
            sql.setString(1, trackToDelete);
            sql.executeUpdate();
            System.out.println("Deleted: " + trackToDelete);

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
    public void update(Track track, String trackName) {
        Connection c = null;
        PreparedStatement sql = null;

        try {
            c = ConnectionUtil.getConnection();
            sql = c.prepareStatement("UPDATE track SET track_name" +
                    "= ?, track_length = ?, artist_id = ?, album_id = ? WHERE track_name = ?");
            sql.setString(1, track.getTrackName());
            sql.setDouble(2, track.getTrackLength());
            sql.setInt(3, track.getArtistID());
            sql.setInt(4, track.getAlbumID());
            sql.setString(5, trackName);
            sql.executeUpdate();
            System.out.println("UPDATE artist");

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
