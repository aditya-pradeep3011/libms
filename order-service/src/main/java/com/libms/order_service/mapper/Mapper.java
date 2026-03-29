package com.libms.order_service.mapper;

public interface Mapper<T, U> {
	
	T toEntity(U dto);
	
	U toDto(T entity);

}
