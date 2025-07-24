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

        List<Music> tracks = request.tracks().stream()
                .map(music -> Music.builder().id(music).build())
                .toList();

        return Album.builder()
                .title(request.title())
                .artist(artist)
                .tracks(tracks)
                .build();
    }

    public static AlbumResponse toResponse(Album album){

        List<MusicResponse> tracks = album.getTracks().stream().map(MusicMapper::toMusicResponse).toList();
        ArtistResponse artist = ArtistMapper.toArtistResponse(album.getArtist()); // arrumar loop infinito de mapper

        return AlbumResponse.builder()
                .id(album.getId())
                .title(album.getTitle())
                .tracks(tracks)
                .artist(artist)
                .build();
    }

}
