package dev.fabricio.musicserviceapi.service;

import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.entity.Music;
import dev.fabricio.musicserviceapi.repository.AlbumRepository;
import dev.fabricio.musicserviceapi.repository.MusicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository repository;
    private final AlbumRepository albumRepository;

    public MusicService(MusicRepository repository, AlbumRepository albumRepository) {
        this.repository = repository;
        this.albumRepository = albumRepository;
    }

    public Music save(Music music) {
        Album album = albumRepository.findById(music.getAlbum().getId())
                .orElseThrow(() -> new EntityNotFoundException("Album not found"));
        music.setAlbum(album);
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
