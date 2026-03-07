package com.BookSecurity.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookSecurity.DTO.BookRequest;
import com.BookSecurity.DTO.BookResponse;
import com.BookSecurity.Service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
	private final BookService bookService;
	@GetMapping
	public ResponseEntity<List<BookResponse>> getAllBooks()
	{
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@PostMapping
	public ResponseEntity<BookResponse> addBook(@RequestBody BookRequest request)
	{
		return ResponseEntity.ok(bookService.addBook(request));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id)
	{
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
	}
	
}
