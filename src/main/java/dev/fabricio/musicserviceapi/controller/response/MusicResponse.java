package dev.fabricio.musicserviceapi.controller.response;

import dev.fabricio.musicserviceapi.entity.Album;
import lombok.Builder;

@Builder
public record MusicResponse(Long id,
                            String title,
                            Integer durationInSeconds,
                            String album,
                            String artist,
                            String genre) {
}
