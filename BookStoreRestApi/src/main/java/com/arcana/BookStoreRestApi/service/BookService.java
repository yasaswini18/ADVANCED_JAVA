package com.arcana.BookStoreRestApi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.arcana.BookStoreRestApi.dto.BookDto;
import com.arcana.BookStoreRestApi.dto.PageResponse;
import com.arcana.BookStoreRestApi.entity.Book;
import com.arcana.BookStoreRestApi.repository.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor                 //for final variables
@Service
public class BookService {
	
	private final ModelMapper modelMapper;
	private final BookRepository repository;
	
	@CacheEvict(value="books",allEntries=true)
	public BookDto createBook(BookDto dto) {
		
		Book book = modelMapper.map(dto,  Book.class);          //DTO to entity
		Book saved = repository.save(book);           //Save the book data and store the returned object
		
		return modelMapper.map(saved, BookDto.class);           //Entity to DTO  
	}
	
	public BookDto updateBookById(Long id, BookDto dto) {
		
		Book existingBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book Id not found"));
		
		existingBook.setTitle(dto.getTitle());
		existingBook.setAuthor(dto.getAuthor());
		existingBook.setPrice(dto.getPrice());
		
		Book updatedBook = repository.save(existingBook);
		return modelMapper.map(updatedBook, BookDto.class);
	}

	public BookDto getBookById(Long id) {
		
		Book foundBook = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		
		return modelMapper.map(foundBook, BookDto.class);
		
	}

	public BookDto deleteById(Long id) {
		
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
		
		repository.deleteById(id);
		
		return modelMapper.map(book, BookDto.class);
	}
	
	public List<BookDto> getAllBooks(){
		
		List<Book> bookList = repository.findAll();
		
		return bookList.stream().map(book -> modelMapper.map(book, BookDto.class)).toList();
	}

	//Pagination + sorting caching
	@Cacheable(value="books",key="#page + '_' + #size + '_' + #sortBy + '_' + #direction")
	public PageResponse<BookDto> getBooks(int page, int size, String sortBy, String direction) {
		
		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
		
		Pageable pageable = PageRequest.of(page, size, sort);
		
		Page<Book> bookPage = repository.findAll(pageable);
		
		List<BookDto> dtoList = bookPage.getContent().stream().map(book -> modelMapper.map(book,  BookDto.class)).toList();
		
		return new PageResponse<>(
				dtoList,
				bookPage.getNumber(),
				bookPage.getSize(),
				bookPage.getTotalElements(),
				bookPage.getTotalPages()
			);
	}
	
}