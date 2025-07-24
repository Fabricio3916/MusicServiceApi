package dev.fabricio.musicserviceapi.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record ArtistResponse(Long id,
                             String name,
                             List<AlbumResponse> albums) {
}
