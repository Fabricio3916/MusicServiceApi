package dev.fabricio.musicserviceapi.repository;

import dev.fabricio.musicserviceapi.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
