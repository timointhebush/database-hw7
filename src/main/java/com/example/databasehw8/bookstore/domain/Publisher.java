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
public class Publisher {

	@Id
	private String name;

	private String address;

	private String phone;

	private String url;

}
