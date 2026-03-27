package com.libms.product_service.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "T_BOOKS")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "author", nullable = false)
	private String author;
	
	@Column(name = "publisher", nullable = false)
	private String publisher;
	
	@Column(name = "publication_year", nullable = false)
	private Integer publicationYear;
	
	@Column(name = "added_date", nullable = false)
	private LocalDateTime addedDateTime;
	
	@Column(name = "updated_date")
	private LocalDateTime updatedDateTime;
	
	@PrePersist
	private void prePersist() {
		this.addedDateTime = LocalDateTime.now();
		this.updatedDateTime = LocalDateTime.now();
	}
	
	@PreUpdate
	private void preUpdate() {
		this.updatedDateTime = LocalDateTime.now();
	}
}
