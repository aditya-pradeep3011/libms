package com.libms.product_service.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libms.product_service.dto.BookDto;
import com.libms.product_service.service.BookService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {

	private final BookService bookService;
	
	@Operation(summary = "Get all books")
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@Operation(summary = "Get book by ID")
	@GetMapping("/{id}")
	public ResponseEntity<BookDto> getBookById(@PathVariable UUID id) {
		Optional<BookDto> bookOpt = bookService.getBookById(id);
		return bookOpt.map(book -> new ResponseEntity<>(book, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@Operation(summary = "Create a new book")
	@PostMapping
	public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
		BookDto createdBook = bookService.createBook(bookDto);
		return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
	}
	
	@Operation(summary = "Update an existing book")
	@PutMapping("/{id}")
	public ResponseEntity<BookDto> updateBook(@PathVariable UUID id, @RequestBody BookDto bookDto) {
		Optional<BookDto> updatedBookOpt = bookService.updateBook(id, bookDto);
		return updatedBookOpt.map(updatedBook -> new ResponseEntity<>(updatedBook, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@Operation(summary = "Delete a book")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
		bookService.deleteBook(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
