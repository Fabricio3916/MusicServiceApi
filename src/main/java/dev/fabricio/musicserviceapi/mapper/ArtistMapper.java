package dev.fabricio.musicserviceapi.mapper;

import dev.fabricio.musicserviceapi.controller.request.AlbumRequest;
import dev.fabricio.musicserviceapi.controller.request.ArtistRequest;
import dev.fabricio.musicserviceapi.controller.response.AlbumResponse;
import dev.fabricio.musicserviceapi.controller.response.ArtistResponse;
import dev.fabricio.musicserviceapi.controller.response.MusicResponse;
import dev.fabricio.musicserviceapi.entity.Album;
import dev.fabricio.musicserviceapi.entity.Artist;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@UtilityClass
public class ArtistMapper {

    public static Artist toArtist (ArtistRequest artistRequest){

        return Artist.builder()
                .name(artistRequest.name())
                .build();
    }

    public static ArtistResponse toArtistResponse (Artist artist){

        List<String> albums = artist.getAlbums() != null
                ? artist.getAlbums().stream().map(Album::getTitle).toList()
                : List.of();

        return ArtistResponse.builder()
                .id(artist.getId())
                .name(artist.getName())
                .albums(albums)
                .build();
    }


}
