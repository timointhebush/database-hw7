package com.example.databasehw8.bookstore.domain;

import com.example.databasehw8.bookstore.domain.id.Published_byId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(Published_byId.class)
public class Published_by implements Serializable {

	@Id
	@JoinColumn(name = "name")
	@ManyToOne(fetch = FetchType.LAZY)
	private Publisher publisher;

	@Id
	@JoinColumn(name = "isbn")
	@ManyToOne(fetch = FetchType.LAZY)
	private Book book;

}
