package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Evaluation;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

}
