package com.BookSecurity.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.BookSecurity.Entity.Book;

public interface BookRepository extends JpaRepository<Book,Long>{
	
}
