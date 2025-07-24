package dev.fabricio.musicserviceapi.repository;

import dev.fabricio.musicserviceapi.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long> {
}
