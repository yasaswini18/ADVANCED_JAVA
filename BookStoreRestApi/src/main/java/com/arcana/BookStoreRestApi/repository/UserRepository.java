package com.arcana.BookStoreRestApi.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.arcana.BookStoreRestApi.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}