package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
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

   
}
