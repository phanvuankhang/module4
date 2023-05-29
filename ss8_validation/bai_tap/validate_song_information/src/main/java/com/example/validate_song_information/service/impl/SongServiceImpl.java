package com.example.validate_song_information.service.impl;

import com.example.validate_song_information.model.Song;
import com.example.validate_song_information.repository.ISongRepository;
import com.example.validate_song_information.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongServiceImpl implements ISongService {
@Autowired
private ISongRepository songRepository;
    @Override
    public List<Song> findAll() {
        return songRepository.findAll();
    }

    @Override
    public void save(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return songRepository.findById(id).get();
    }


}
