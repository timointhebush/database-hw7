package com.example.databasehw8.bookstore.domain;

import com.example.databasehw8.bookstore.domain.id.Written_byId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(Written_byId.class)
public class Written_by implements Serializable {

	@Id
	@JoinColumns({
			@JoinColumn(name = "name"),
			@JoinColumn(name = "address")
	})
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;

	@Id
	@JoinColumn(name = "isbn")
	@ManyToOne(fetch = FetchType.LAZY)
	private Book book;

}
