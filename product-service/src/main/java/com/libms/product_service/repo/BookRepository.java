package com.libms.product_service.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libms.product_service.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID>{

}
