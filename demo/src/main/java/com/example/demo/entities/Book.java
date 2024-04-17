package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String release_date;
    private String genre;
    private String category;
    private String year;
    private String rating;
    private String author;
    private String publisher;
    private String pages;

    public Book() {
    }

    public Book(long id, String title, String description, String release, String genre, String category, String year,
            String rating, String author, String publisher, String pages) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.release_date = release;
        this.genre = genre;
        this.category = category;
        this.year = year;
        this.rating = rating;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release) {
        this.release_date = release;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
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
        return "Book [id=" + id + ", title=" + title + ", description=" + description + ", release=" + release_date
                + ", genre=" + genre + ", category=" + category + ", year=" + year + ", rating=" + rating + ", author="
                + author + ", publisher=" + publisher + ", pages=" + pages + "]";
    }
}
