package dev.fabricio.musicserviceapi.controller.response;

import lombok.Builder;

import java.util.List;

@Builder
public record AlbumResponse(Long id,
                            String title,
                            ArtistResponse artist,
                            List<MusicResponse> tracks) {
}
