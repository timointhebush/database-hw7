package com.example.databasehw8.bookstore.domain.id;

import com.example.databasehw8.bookstore.domain.Customer;
import com.example.databasehw8.bookstore.domain.Shopping_basket;
import com.example.databasehw8.bookstore.domain.id.Basket_ofId;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(Basket_ofId.class)
public class Basket_of {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "email")
	private Customer customer;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "basketid")
	private Shopping_basket shopping_basket;
}
