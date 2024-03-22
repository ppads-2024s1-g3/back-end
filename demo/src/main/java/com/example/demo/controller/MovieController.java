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

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class MovieController {
    @Autowired
    private MovieRepository repository;

    @GetMapping("/movies") // FUNCIONOU
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @GetMapping("/movies/{id}") // FUNCIONOU
    public Optional<Movie> getMovie(@PathVariable long id) {
        return repository.findById(id);
    }

    @SuppressWarnings("null")
    @PostMapping("/movie") // FUNCIONOU
    public Movie postMovie(@RequestBody Movie movie) {
        return repository.save(movie);
    }

    @DeleteMapping(value = "/movie/{id}") // FUNCIONOU
    public boolean deleteMovie(@PathVariable long id) {
        Optional<Movie> Movie = repository.findById(id);
        if (Movie.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @GetMapping("/movie/title/{title}") // FUNCIONOU
    public List<Movie> getMovieByTitle(@PathVariable String title) {
        return repository.findByTitle(title);
    }

    @PutMapping("/movies/{id}") // FUNCIONOU
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") long id, @RequestBody Movie newMovie) {
        Optional<Movie> oldMovie = repository.findById(id);
        if (oldMovie.isPresent()) {
            Movie movie = oldMovie.get();
            movie.setTitle(newMovie.getTitle());
            movie.setDescription(newMovie.getDescription());
            movie.setReleaseDate(newMovie.getReleaseDate());
            movie.setGenre(newMovie.getGenre());
            movie.setLength(newMovie.getLength());
            movie.setCategory(newMovie.getCategory());
            movie.setCountry(newMovie.getCountry());
            movie.setDirector(newMovie.getDirector());
            movie.setActors(newMovie.getActors());
            movie.setYear(newMovie.getYear());
            movie.setRating(newMovie.getRating());
            repository.save(movie);
            return new ResponseEntity<Movie>(movie, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // @PutMapping("/produtos/{id}")
    // public ResponseEntity<Produto> updateProduto(@PathVariable(value = "id") Long
    // id, @RequestBody Produto newProduto) {
    // Optional<Produto> oldProduto = repository.findById(id);
    // if (oldProduto.isPresent()) {
    // Produto produto = oldProduto.get();
    // produto.setNome(newProduto.getNome());
    // produto.setDescricao(newProduto.getDescricao());
    // produto.setMarca(newProduto.getMarca());
    // produto.setValor(newProduto.getValor());
    // repository.save(produto);
    // return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    // } else
    // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    // }

}