package com.libms.product_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.libms.product_service.dto.BookDto;
import com.libms.product_service.mapper.BookMapper;
import com.libms.product_service.model.Book;

@Configuration
public class MapperConfig {

	@Bean
	BookMapper<Book, BookDto> bookMapper() {
		return new BookMapper<Book, BookDto>();
	}
}
