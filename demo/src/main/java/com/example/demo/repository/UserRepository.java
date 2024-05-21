package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT users FROM User users WHERE email =:email AND password =:password")
    public User findOneByEmailAndPassword(@Param("email") String email, @Param("password") String password);
    
}