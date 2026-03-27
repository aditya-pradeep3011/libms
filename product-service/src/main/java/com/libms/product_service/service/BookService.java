package com.libms.product_service.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.libms.product_service.dto.BookDto;
import com.libms.product_service.mapper.Mapper;
import com.libms.product_service.model.Book;
import com.libms.product_service.repo.BookRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {

	private final BookRepository bookRepository;
	private final Mapper<Book, BookDto> bookMapper;
	
	public List<BookDto> getAllBooks() {
		return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
	}
	
	public Optional<BookDto> getBookById(UUID id) {
		return bookRepository.findById(id).map(bookMapper::toDto);
	}
	
	public BookDto createBook(BookDto bookDto) {
		Book book = bookMapper.toEntity(bookDto);
		Book savedBook = bookRepository.save(book);
		return bookMapper.toDto(savedBook);
	}
	
	public Optional<BookDto> updateBook(UUID id, BookDto bookDto) {
		return bookRepository.findById(id).map(existingBook -> {
			existingBook.setTitle(bookDto.getTitle());
			existingBook.setAuthor(bookDto.getAuthor());
			existingBook.setPublisher(bookDto.getPublisher());
			existingBook.setPublicationYear(bookDto.getPublicationYear());
			Book updatedBook = bookRepository.save(existingBook);
			return bookMapper.toDto(updatedBook);
		});
	}
	
	public void deleteBook(UUID id) {
		bookRepository.deleteById(id);
	}
}
