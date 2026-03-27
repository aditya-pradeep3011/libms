package com.libms.product_service.mapper;

import com.libms.product_service.dto.BookDto;
import com.libms.product_service.model.Book;

public class BookMapper<T, U> implements Mapper<Book, BookDto> {

	@Override
	public BookDto toDto(Book t) {
		if (t == null) {
			return null;
		}
		
		BookDto dto = new BookDto();
		dto.setId(t.getId());
		dto.setTitle(t.getTitle());
		dto.setAuthor(t.getAuthor());
		dto.setPublisher(t.getPublisher());
		dto.setPublicationYear(t.getPublicationYear());
		
		return dto;
	}

	@Override
	public Book toEntity(BookDto u) {
		if (u == null) {
			return null;
		}
		
		Book book = new Book();
		book.setId(u.getId());
		book.setTitle(u.getTitle());
		book.setAuthor(u.getAuthor());
		book.setPublisher(u.getPublisher());
		book.setPublicationYear(u.getPublicationYear());
		
		return book;
	}

}
