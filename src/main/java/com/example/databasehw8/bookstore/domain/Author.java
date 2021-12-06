package com.example.databasehw8.bookstore.domain;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

import com.example.databasehw8.bookstore.domain.id.AuthorId;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Author implements Serializable {

	@EmbeddedId
	private AuthorId authorId;

	private String url;
}
