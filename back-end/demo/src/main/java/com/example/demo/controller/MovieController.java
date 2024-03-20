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

    @GetMapping("/movie")
    public List<Movie> getMovies() {
        return repository.findAll();
    }

    @GetMapping("/movie/{id}")
    public Optional<Movie> getMovie(@PathVariable long id) {
        return repository.findById(id);
    }

    @PostMapping("/movie")
    public Movie postMovie(@RequestBody Movie Movie) {
        return repository.save(Movie);
    }

    @DeleteMapping(value = "/movie/{id}")
    public boolean deleteMovie(@PathVariable long id) {
        Optional<Movie> Movie = repository.findById(id);
        if (Movie.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @PutMapping("/movie/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable(value = "id") Long id,
            @RequestBody Movie newMovie) {
        Optional<Movie> oldMovie = repository.findById(id);
        if (oldMovie.isPresent()) {
            Movie Movie = oldMovie.get();
            Movie.setTitle(newMovie.getTitle());
            Movie.setDescription(newMovie.getDescription());
            Movie.setReleaseDate(newMovie.getReleaseDate());
            Movie.setGenre(newMovie.getGenre());
            Movie.setLength(newMovie.getLength());
            Movie.setCategory(newMovie.getCategory());
            Movie.setCountry(newMovie.getCountry());
            Movie.setDirector(newMovie.getDirector());
            Movie.setCast(newMovie.getCast());
            Movie.setYear(newMovie.getYear());
            Movie.setRating(newMovie.getRating());
            repository.save(Movie);
            return new ResponseEntity<Movie>(Movie, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // @GetMapping("/movie/{param1}/{param2}")
    // public List<Movie> getProdutoEspec(@PathVariable String param1, @PathVariable
    // String param2) {
    // List<Movie> l = repository.findAll();
    // List<Movie> lf = new ArrayList<>();
    // if (param2.equals("")) {
    // return l;
    // }
    // for (Movie p : l) {
    // String attr = param1;
    // String word = param2;
    // switch (attr) {
    // case "id":
    // int temp1 = Integer.parseInt(word);
    // if (p.getId() == temp1)
    // lf.add(p);
    // break;
    // case "nome":
    // String n = p.getNome().toLowerCase();
    // word = word.toLowerCase();
    // if (n.contains(word))
    // lf.add(p);
    // break;
    // case "cargo":
    // String c = p.getCargo().toLowerCase();
    // word = word.toLowerCase();
    // if (c.contains(word))
    // lf.add(p);
    // break;
    // case "salario":
    // int temp2 = Integer.parseInt(word);
    // if (p.getSalario() == temp2)
    // lf.add(p);
    // break;
    // default:
    // lf.add(p);
    // }
    // }
    // return lf;
    // }
}