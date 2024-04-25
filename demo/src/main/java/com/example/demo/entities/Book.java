package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "books")
@EqualsAndHashCode(callSuper = false)
@SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
public class Book extends Content {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String author;
    private String publisher;
    private String pages;

    public Book() {
    }

    public Book(long id, String title, String description, String release, String genre, String country, String rating,
            String image_path, String content_type) {
        super(id, title, description, release, genre, country, rating, image_path, content_type);
    }

    public Book(long id, String author, String publisher, String pages) {
        this.id = id;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    public Book(long id, String title, String description, String release, String genre, String country, String rating,
            String image_path, String content_type, long id2, String author, String publisher, String pages) {
        super(id, title, description, release, genre, country, rating, image_path, content_type);
        id = id2;
        this.author = author;
        this.publisher = publisher;
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", author=" + author + ", publisher=" + publisher + ", pages=" + pages + "]";
    }

}
