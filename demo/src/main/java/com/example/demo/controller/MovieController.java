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

import com.example.demo.entities.Movie;
import com.example.demo.repository.MovieRepository;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class MovieController {
    @Autowired
    private MovieRepository repository;

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @GetMapping("/movies/{id}")
    public Optional<Movie> getMovie(@PathVariable long id) {
        return repository.findById(id);
    }

    @PostMapping("/movies")
    public Movie postMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }

    @DeleteMapping(value = "/movies/{id}")
    public boolean deleteMovie(@PathVariable long id) {
        Optional<Movie> Movie = repository.findById(id);
        if (Movie.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Transactional
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie newMovie) {
        Optional<Movie> oldMovie = repository.findById(id);
        if (oldMovie.isPresent()) {
            Movie movie = oldMovie.get();
            movie.setTitle(newMovie.getTitle());
            movie.setDescription(newMovie.getDescription());
            movie.setRelease(newMovie.getRelease());
            movie.setGenre(newMovie.getGenre());
            movie.setLength(newMovie.getLength());
            movie.setCountry(newMovie.getCountry());
            movie.setDirector(newMovie.getDirector());
            movie.setActors(newMovie.getActors());
            movie.setRating(newMovie.getRating());
            movie.setImage_path(newMovie.getImage_path());

            repository.save(movie);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}