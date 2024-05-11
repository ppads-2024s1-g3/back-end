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

import com.example.demo.entities.Comment;
import com.example.demo.repository.CommentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class CommentController {
    @Autowired
    private CommentRepository repository;

    @GetMapping("/comments")
    public List<Comment> getComments() {
        return repository.findAll();
    }

    @GetMapping("/comments/{id}")
    public Optional<Comment> getCommentById(@PathVariable long id) {
        return repository.findById(id);
    }

    @PostMapping("/comments")
    public Comment postComment(@RequestBody Comment comment) {
        return repository.save(comment);
    }

    @DeleteMapping(value = "/comments/{id}")
    public boolean deleteComment(@PathVariable long id) {
        Optional<Comment> comment = repository.findById(id);
        if (comment.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }


    @PutMapping("/comments/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(value = "id") long id, @RequestBody Comment newComment) {
        Optional<Comment> oldComment = repository.findById(id);
        if (oldComment.isPresent()) {
            Comment comment = oldComment.get();
            comment.setRating(newComment.getRating());
            comment.setUser(newComment.getUser());
            comment.setContent(newComment.getContent());
            repository.save(comment);
            return new ResponseEntity<Comment>(comment, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}