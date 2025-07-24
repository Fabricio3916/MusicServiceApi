package dev.fabricio.musicserviceapi.service;

import dev.fabricio.musicserviceapi.entity.Music;
import dev.fabricio.musicserviceapi.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository repository;

    public MusicService(MusicRepository repository) {
        this.repository = repository;
    }

    public Music save(Music music) {
        return repository.save(music);
    }

    public Music getMusicById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Music> getAllMusic() {
        return repository.findAll();
    }

    public void deleteMusicById(Long id) {
        repository.deleteById(id);
    }


}
