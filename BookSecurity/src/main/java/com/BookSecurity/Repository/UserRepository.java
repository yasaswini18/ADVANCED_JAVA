package com.BookSecurity.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BookSecurity.Entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User> findByUsername(String username);
}
