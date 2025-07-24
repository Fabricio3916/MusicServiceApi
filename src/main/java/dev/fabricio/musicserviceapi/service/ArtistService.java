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
    private final AlbumService albumService;

    public ArtistService(ArtistRepository artistRepository, AlbumService albumService) {
        this.repository = artistRepository;
        this.albumService = albumService;
    }

    public Artist save(Artist artist) {
        artist.setAlbums(findAlbum(artist.getAlbums()));
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

    private List<Album> findAlbum (List<Album> albums){
        List<Album> albumList = new ArrayList<>();
        albums.forEach(album -> albumService.findById(album.getId()).ifPresent(albumList::add));
        return albumList;
    }

}
