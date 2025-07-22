package dev.fabricio.musicserviceapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "music")
@Getter
@Setter
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "duration_seconds", nullable = false)
    private int durationInSeconds;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    private String genre;

}
