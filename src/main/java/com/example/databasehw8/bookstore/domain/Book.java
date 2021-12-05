package com.example.databasehw8.bookstore.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Book {

	@Id
	private String isbn;

	private String title;

	private Integer year;

	private Integer price;

}
