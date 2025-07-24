package dev.fabricio.musicserviceapi.service;

import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {


    private final AlbumRepository repository;

    public AlbumService(AlbumRepository albumRepository) {
        this.repository = albumRepository;
    }

    public Album save(Album album) {
        return repository.save(album);
    }

    public List<Album> getAllAlbums() {
        return repository.findAll();
    }

    public Optional<Album> findById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
