package dev.fabricio.musicserviceapi.mapper;

import dev.fabricio.musicserviceapi.controller.request.AlbumRequest;
import dev.fabricio.musicserviceapi.controller.request.ArtistRequest;
import dev.fabricio.musicserviceapi.controller.response.AlbumResponse;
import dev.fabricio.musicserviceapi.controller.response.ArtistResponse;
import dev.fabricio.musicserviceapi.controller.response.MusicResponse;
import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.entity.Artist;
import lombok.experimental.UtilityClass;

import java.util.List;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class ArtistMapper {

    public static Artist toArtist (ArtistRequest artistRequest){

        List<Album> albums = artistRequest.albums().stream()
                .map(album -> Album.builder().id(album).build())
                .toList();

        return Artist.builder()
                .name(artistRequest.name())
                .albums(albums)
                .build();
    }

    public static ArtistResponse toArtistResponse (Artist artist){

        List<AlbumResponse> albums = artist.getAlbums().stream()
                .map(AlbumMapper::toResponse)
                .toList();

        return ArtistResponse.builder()
                .id(artist.getId())
                .name(artist.getName())
                .albums(albums)
                .build();
    }


}
