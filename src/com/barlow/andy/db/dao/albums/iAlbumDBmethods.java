package com.barlow.andy.db.dao.albums;

import com.barlow.andy.db.entities.albums.Album;

import java.util.List;

/**
 * Created by andy on 4/22/2015.
 */
public interface iAlbumDBmethods {
    void albumCreateTable();

    void insert(Album album);

    List<Album> selectAll();

    void delete(String albumToDelete);

    void update(Album album, String albumName);
}
