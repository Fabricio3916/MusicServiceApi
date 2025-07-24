package dev.fabricio.musicserviceapi.mapper;

import dev.fabricio.musicserviceapi.controller.request.MusicRequest;
import dev.fabricio.musicserviceapi.controller.response.AlbumResponse;
import dev.fabricio.musicserviceapi.controller.response.MusicResponse;
import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.entity.Music;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MusicMapper {

    public static Music toMusic(MusicRequest musicRequest) {

        Album album = Album.builder().id(musicRequest.album()).build();

        return Music.builder()
                .title(musicRequest.title())
                .durationInSeconds(musicRequest.durationInSeconds())
                .album(album)
                .genre(musicRequest.genre())
                .build();
    }

    public static MusicResponse toMusicResponse(Music music) {

        AlbumResponse albumResponse = AlbumMapper.toResponse(music.getAlbum());

        return MusicResponse.builder()
                .id(music.getId())
                .title(music.getTitle())
                .durationInSeconds(music.getDurationInSeconds())
                .album(albumResponse)
                .genre(music.getGenre())
                .build();
    }



}
