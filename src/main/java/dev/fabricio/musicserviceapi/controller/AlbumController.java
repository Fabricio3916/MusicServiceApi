package dev.fabricio.musicserviceapi.controller;


import dev.fabricio.musicserviceapi.controller.request.AlbumRequest;
import dev.fabricio.musicserviceapi.controller.response.AlbumResponse;
import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.mapper.AlbumMapper;
import dev.fabricio.musicserviceapi.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/musicApi/album")
public class AlbumController {


    private final AlbumService service;

    public AlbumController(AlbumService albumService) {
        this.service = albumService;
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> create(@RequestBody AlbumRequest request) {
        Album newAlbum = service.save(AlbumMapper.toAlbum(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(AlbumMapper.toResponse(newAlbum));
    }

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> getAllAlbums() {
        List<AlbumResponse> list = service.getAllAlbums().stream().map(AlbumMapper::toResponse).toList();
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> getAlbumById(@PathVariable Long id){
       return service.findById(id)
               .map( album -> ResponseEntity.ok(AlbumMapper.toResponse(album)))
               .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbumById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
