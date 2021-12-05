package com.example.databasehw8.bookstore.domain;

import com.example.databasehw8.bookstore.domain.id.StocksId;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(StocksId.class)
public class Stocks implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "isbn")
	private Book book;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code")
	private Warehouse warehouse;

	private Integer num;
}
