package dev.fabricio.musicserviceapi.controller.request;

import dev.fabricio.musicserviceapi.entity.Album;

public record MusicRequest(String title,
                           Integer durationInSeconds,
                           Long album,
                           String genre) {
}
