package com.BookSecurity.Service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.BookSecurity.DTO.BookRequest;
import com.BookSecurity.DTO.BookResponse;
import com.BookSecurity.Entity.Book;
import com.BookSecurity.Repository.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	private final ModelMapper modelMapper;
	
	@PreAuthorize("hasRole('ADMIN')")
	public BookResponse addBook(BookRequest request)
	{
		Book book = modelMapper.map(request, Book.class);
		Book saved = bookRepository.save(book);
		return modelMapper.map(saved,BookResponse.class);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteBook(Long id)
	{
		bookRepository.deleteById(id);
	}
	
	public List<BookResponse> getAllBooks()
	{
		return bookRepository.findAll().stream()
				             .map(book->modelMapper.map(book,BookResponse.class))
				             .toList();
	}
}
