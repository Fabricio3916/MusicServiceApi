package dev.fabricio.musicserviceapi.repository;

import dev.fabricio.musicserviceapi.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {
}
