package dev.fabricio.musicserviceapi.service;

import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.entity.Artist;
import dev.fabricio.musicserviceapi.repository.AlbumRepository;
import dev.fabricio.musicserviceapi.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArtistService {


    private final ArtistRepository repository;

    public ArtistService(ArtistRepository artistRepository) {
        this.repository = artistRepository;
    }

    public Artist save(Artist artist) {
        return repository.save(artist);
    }

    public List<Artist> getAllArtists() {
        return repository.findAll();
    }

    public Artist getArtistById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteArtistById(Long id) {
        repository.deleteById(id);
    }

    public Artist updateArtist(Artist artist) {
        return repository.save(artist);
    }



}
