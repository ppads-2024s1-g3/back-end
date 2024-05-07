package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Book;
import com.example.demo.repository.BookRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class BookController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable long id) {
        return repository.findById(id);
    }

      @PostMapping("/books")
    public Book postBook(@RequestBody Book book) {
        return repository.save(book);
    }

    @DeleteMapping(value = "/books/{id}")
    public boolean deleteMovie(@PathVariable long id) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

      @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateMovie(@PathVariable(value = "id") long id, @RequestBody Book newBook) {
        Optional<Book> oldBook = repository.findById(id);
        if (oldBook.isPresent()) {
            Book book = oldBook.get();
            book.setTitle(newBook.getTitle());
            book.setDescription(newBook.getDescription());
            book.setGenre(newBook.getGenre());
            book.setRating(newBook.getRating());
            book.setAuthor(newBook.getAuthor());
            book.setPublisher(newBook.getPublisher());
            book.setPages(newBook.getPages());
            book.setImage_path(newBook.getImage_path());
            repository.save(book);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}