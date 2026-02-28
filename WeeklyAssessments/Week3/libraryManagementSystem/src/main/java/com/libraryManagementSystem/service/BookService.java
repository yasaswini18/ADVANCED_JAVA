package com.libraryManagementSystem.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.libraryManagementSystem.exception.BookNotFoundException;
import com.libraryManagementSystem.model.Book;
@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private long bookCounter = 1;

    public void addBook(Book book) {
        book.setId(bookCounter++);
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book viewBookById(Long id) {
        return books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .orElseThrow(() ->
                        new BookNotFoundException("Book with ID " + id + " not found"));
    }

    public void deleteBook(Long id) {
        boolean removed = books.removeIf(
            b -> id.equals(b.getId())
        );

        if (!removed) {
            throw new BookNotFoundException(
                "Book with ID " + id + " not found");
        }
    }
}