package dev.fabricio.musicserviceapi.controller;

import dev.fabricio.musicserviceapi.controller.request.ArtistRequest;
import dev.fabricio.musicserviceapi.controller.response.ArtistResponse;
import dev.fabricio.musicserviceapi.entity.Artist;
import dev.fabricio.musicserviceapi.mapper.ArtistMapper;
import dev.fabricio.musicserviceapi.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musicApi/artist")
public class ArtistController {


    private final ArtistService service;

    public ArtistController(ArtistService artistService) {
        this.service = artistService;
    }

    @GetMapping
    public ResponseEntity<List<ArtistResponse>> getAllArtist(){
        List<ArtistResponse> list = service.getAllArtists().stream()
                .map(ArtistMapper::toArtistResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.FOUND).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> getArtistById(@PathVariable Long id){
        ArtistResponse artist = ArtistMapper.toArtistResponse(service.getArtistById(id));
        return ResponseEntity.status(HttpStatus.FOUND).body(artist);
    }

    @PostMapping
    public ResponseEntity<ArtistResponse> createArtist(@RequestBody ArtistRequest artistRequest){
        Artist artist = ArtistMapper.toArtist(artistRequest);
        Artist savedArtist = service.save(artist);
        return ResponseEntity.status(HttpStatus.CREATED).body(ArtistMapper.toArtistResponse(savedArtist));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteArtistById(@PathVariable Long id){
        service.deleteArtistById(id);
        return ResponseEntity.noContent().build();
    }



}
