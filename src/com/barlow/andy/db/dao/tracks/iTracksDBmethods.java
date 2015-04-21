package com.barlow.andy.db.dao.tracks;

import com.barlow.andy.db.entities.tracks.Track;

import java.util.List;

/**
 * Created by andy on 4/8/2015.
 *
 *
 *      interface for DB functionality. Added:
 *
 *      contactCreateTable() <-- create table in DB if not exist
 *      List<Artist> selectAll() <-- lists all contacts in db
 *      insert() <-- instead of "save();"
 *      update() <-- update method for solution
 *
 *
 *
 */



public interface iTracksDBmethods {

    void tracksCreateTable();

    void insert(Track track);

    List<Track> selectAll();

    void delete(String trackToDelete);

    void update(Track track, String trackName);
}


