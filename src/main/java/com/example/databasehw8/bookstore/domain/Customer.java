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
public class Customer {

	@Id
	private String email;

	private String name;

	private String address;

	private String phone;

}
