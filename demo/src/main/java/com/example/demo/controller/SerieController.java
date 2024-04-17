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

import com.example.demo.entities.Serie;
import com.example.demo.repository.SerieRepository;

import jakarta.transaction.Transactional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class SerieController {
    @Autowired
    private SerieRepository repository;

    @GetMapping("/series")
    public List<Serie> getSeries() {
        return repository.findAll();
    }

    @GetMapping("/series/{id}")
    public Optional<Serie> getSerie(@PathVariable long id) {
        return repository.findById(id);
    }

    // @SuppressWarnings("null")
    @PostMapping("/series")
    public Serie postSerie(@RequestBody Serie serie) {
        return repository.save(serie);
    }

    @DeleteMapping(value = "/series/{id}")
    public boolean deleteSerie(@PathVariable long id) {
        Optional<Serie> Serie = repository.findById(id);
        if (Serie.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // @GetMapping("/series/title/{title}")
    // public List<Serie> getSerieByTitle(@PathVariable String title) {
    // return repository.findByTitle(title);
    // }
    @Transactional
    @PutMapping("/series/{id}")
    // public ResponseEntity<Serie> updateSerie(@PathVariable Long id, @RequestBody
    // Serie serie) {}
    public ResponseEntity<Serie> updateSerie(@PathVariable long id, @RequestBody Serie newSerie) {
        Optional<Serie> oldSerie = repository.findById(id);
        if (oldSerie.isPresent()) {
            Serie serie = oldSerie.get();
            serie.setTitle(newSerie.getTitle());
            serie.setDescription(newSerie.getDescription());
            serie.setRelease(newSerie.getRelease());
            serie.setGenre(newSerie.getGenre());
            serie.setLength(newSerie.getLength());
            serie.setCategory(newSerie.getCategory());
            serie.setCountry(newSerie.getCountry());
            serie.setDirector(newSerie.getDirector());
            serie.setActors(newSerie.getActors());
            serie.setYear(newSerie.getYear());
            serie.setRating(newSerie.getRating());

            repository.save(serie);
            return new ResponseEntity<Serie>(serie, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}