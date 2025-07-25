package dev.fabricio.musicserviceapi.mapper;

import dev.fabricio.musicserviceapi.controller.request.AlbumRequest;
import dev.fabricio.musicserviceapi.controller.response.AlbumResponse;
import dev.fabricio.musicserviceapi.controller.response.ArtistResponse;
import dev.fabricio.musicserviceapi.controller.response.MusicResponse;
import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.entity.Artist;
import dev.fabricio.musicserviceapi.entity.Music;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class AlbumMapper {

    public static Album toAlbum (AlbumRequest request){

        Artist artist = Artist.builder()
                .id(request.artist())
                .build();

        return Album.builder()
                .title(request.title())
                .artist(artist)
                .build();
    }

    public static AlbumResponse toResponse(Album album){

        String artist = album.getArtist().getName();
        List<String> tracks = album.getTracks() != null
                ? album.getTracks().stream().map(Music::getTitle).toList()
                : List.of();

        return AlbumResponse.builder()
                .id(album.getId())
                .title(album.getTitle())
                .tracks(tracks)
                .artist(artist)
                .build();
    }

}
