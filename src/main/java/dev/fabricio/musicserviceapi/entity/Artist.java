package dev.fabricio.musicserviceapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Album> albums;

}
