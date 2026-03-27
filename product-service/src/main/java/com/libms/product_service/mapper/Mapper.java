package com.libms.product_service.mapper;

public interface Mapper<T, U> {
	U toDto(T t);
	T toEntity(U u);
}
