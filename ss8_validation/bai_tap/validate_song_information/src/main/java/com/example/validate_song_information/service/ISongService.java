package com.example.validate_song_information.service;

import com.example.validate_song_information.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(Integer id);
}
