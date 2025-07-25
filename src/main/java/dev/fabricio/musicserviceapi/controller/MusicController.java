package dev.fabricio.musicserviceapi.controller;

import dev.fabricio.musicserviceapi.controller.request.MusicRequest;
import dev.fabricio.musicserviceapi.controller.response.MusicResponse;
import dev.fabricio.musicserviceapi.entity.Music;
import dev.fabricio.musicserviceapi.mapper.MusicMapper;
import dev.fabricio.musicserviceapi.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/musicApi/music")
public class MusicController {


    private final MusicService musicService;

    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping
    public ResponseEntity<List<MusicResponse>> findAll() {
        List<MusicResponse> list = musicService.getAllMusic().stream()
                .map(MusicMapper::toMusicResponse)
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<MusicResponse> saveMusic(@RequestBody MusicRequest request) {
        Music newMusic = MusicMapper.toMusic(request);
        newMusic = musicService.save(newMusic);
        Music completeMusic = musicService.getMusicById(newMusic.getId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(MusicMapper.toMusicResponse(completeMusic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicResponse> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(MusicMapper.toMusicResponse(musicService.getMusicById(id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        musicService.deleteMusicById(id);
        return ResponseEntity.noContent().build();
    }

}
