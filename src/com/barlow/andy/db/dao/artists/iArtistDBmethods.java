package com.barlow.andy.db.dao.artists;


import com.barlow.andy.db.entities.artist.Artist;

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


public interface iArtistDBmethods {

    void artistCreateTable();

    void insert(Artist artist);

    List<Artist> selectAll();

    void delete(String artistToDelete);

    void update(Artist artist, String artistName);
}
