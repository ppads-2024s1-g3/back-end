package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "series")
@EqualsAndHashCode(callSuper = false)
public class Serie extends Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String director;
    private String actors;
    private String seasons;

    public Serie() {

    }

    public Serie(long id, String director, String actors, String seasons) {
        this.id = id;
        this.director = director;
        this.actors = actors;
        this.seasons = seasons;
    }

    public Serie(long id, String title, String description, String release, String genre, String country, String rating,
            String image_path, String content_type, long id2, String director, String actors, String seasons) {
        super(id, title, description, release, genre, country, rating, image_path, content_type);
        id = id2;
        this.director = director;
        this.actors = actors;
        this.seasons = seasons;
    }

}