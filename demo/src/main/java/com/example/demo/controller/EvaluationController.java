package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Evaluation;
import com.example.demo.repository.EvaluationRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class EvaluationController {
    @Autowired
    private EvaluationRepository repository;

    @GetMapping("/evaluations")
    public List<Evaluation> getEvaluations() {
        return repository.findAll();
    }

    @GetMapping("/evaluations/{id}")
    public Optional<Evaluation> getEvaluationById(@PathVariable long id) {
        return repository.findById(id);
    }

  
    @PostMapping("/evaluations")
    public Evaluation postEvaluation(@RequestBody Evaluation evaluation) {
        return repository.save(evaluation);
    }

    @DeleteMapping(value = "/evaluations/{id}")
    public boolean deleteEvaluation(@PathVariable long id) {
        Optional<Evaluation> evaluation = repository.findById(id);
        if (evaluation.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}