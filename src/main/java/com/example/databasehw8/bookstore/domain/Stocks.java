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
public class Stocks implements Serializable {

	@EmbeddedId
	private StocksId stocksId;

	private Integer num;
}
