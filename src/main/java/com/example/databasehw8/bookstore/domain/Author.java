package com.example.databasehw8.bookstore.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(AuthorId.class)
public class Author implements Serializable {

	@Id
	private String name;

	@Id
	private String address;

	private String url;
}
