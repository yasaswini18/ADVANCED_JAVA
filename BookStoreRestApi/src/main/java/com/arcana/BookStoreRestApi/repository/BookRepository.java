package com.arcana.BookStoreRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arcana.BookStoreRestApi.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	
}
