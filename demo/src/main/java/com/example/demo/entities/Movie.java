package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "movies")
@EqualsAndHashCode(callSuper = false)
public class Movie extends Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String director;
    private String length;
    private String actors;

    public Movie(long id, String director, String length, String actors) {
        this.id = id;
        this.director = director;
        this.length = length;
        this.actors = actors;
    }

    public Movie(long id, String title, String description, String release, String genre, String country, String rating,
            String image_path, String content_type, long id2, String director, String length, String actors) {
        super(id, title, description, release, genre, country, rating, image_path, content_type);
        id = id2;
        this.director = director;
        this.length = length;
        this.actors = actors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie [id=" + id + ", director=" + director + ", length=" + length + ", actors=" + actors + "]";
    }
}
