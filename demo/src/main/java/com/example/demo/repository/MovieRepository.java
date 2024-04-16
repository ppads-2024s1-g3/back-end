package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByTitle(String title);

}
