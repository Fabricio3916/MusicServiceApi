package dev.fabricio.musicserviceapi.controller.request;

import java.util.List;

public record AlbumRequest(String title,
                           Long artist
) {
}
