package com.arcana.BookStoreRestApi.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.arcana.BookStoreRestApi.dto.BookDto;
import com.arcana.BookStoreRestApi.dto.PageResponse;
import com.arcana.BookStoreRestApi.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("api/book")
@Tag(name="Book Management System", description="Backend API Testing for Book Management System")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	
	@PostMapping("/add")
	@Operation(summary = "Adding Book", description="Adding a new book in the table")
	@ApiResponse(responseCode = "200", description = "Book added successfully")
	public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookDto dto){
		
		BookDto savedBook = bookService.createBook(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
	}
	
	@PutMapping("/updateBook/{id}")
	@Operation(summary = "Updating Book", description="Updating an existing book in the table")
	@ApiResponse(responseCode = "200", description = "Book updated successfully")
	public ResponseEntity<BookDto> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto dto){
		
		BookDto updatedBook = bookService.updateBookById(id, dto);
		return ResponseEntity.ok(updatedBook);
	}
	
	@GetMapping("/getBook/{id}")
	@Operation(summary = "Fetching Book", description="Fetching a book using id from the table")
	@ApiResponse(responseCode = "200", description = "Book fetched successfully")
	public ResponseEntity<BookDto> getBookById(@PathVariable Long id){
		
		BookDto foundBook = bookService.getBookById(id);
		return ResponseEntity.ok(foundBook);
	}
	
	@DeleteMapping("/deleteBook/{id}")
	@Operation(summary = "Deleting Book", description="Deleting the book from the table")
	@ApiResponse(responseCode = "200", description = "Book deleted successfully")
	public ResponseEntity<BookDto> deleteBook(@PathVariable Long id){
		
		BookDto deletedBook = bookService.deleteById(id);
		return ResponseEntity.ok(deletedBook);
	}
	
	@GetMapping("/getAllBook")
	@Operation(summary = "Fetching All Books", description="Fetching all the books from table")
	@ApiResponse(responseCode = "200", description = "Books fetched successfully")
	public ResponseEntity<List<BookDto>> findAllBook(){
		
		List<BookDto> dtoList = bookService.getAllBooks();
		return ResponseEntity.ok(dtoList);
	}
	
	@GetMapping
	@Operation(summary = "Fetching All Books(Pagination)", description="Fetching all the books from the table in pages")
	@ApiResponse(responseCode = "200", description = "Book fetched successfully")
	public ResponseEntity<PageResponse<BookDto>> getBook(
		
		@Parameter(name="Page Number")@RequestParam(defaultValue = "0") int page,
		@Parameter(name="Page Size")@RequestParam(defaultValue = "5") int size,
		@Parameter(name="Sort By")@RequestParam(defaultValue = "id") String sortBy,
		@Parameter(name="Direction")@RequestParam(defaultValue = "asc") String direction) {
		
		PageResponse<BookDto> books = bookService.getBooks(page, size, sortBy, direction);
		
		return ResponseEntity.ok(books);
	}
}
