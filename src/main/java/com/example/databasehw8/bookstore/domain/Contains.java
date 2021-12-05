package com.example.databasehw8.bookstore.domain;

import com.example.databasehw8.bookstore.domain.id.ContainsId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(ContainsId.class)
public class Contains implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basketid")
	private Shopping_basket shopping_basket;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn")
	private Book book;

	private Integer num;
}
