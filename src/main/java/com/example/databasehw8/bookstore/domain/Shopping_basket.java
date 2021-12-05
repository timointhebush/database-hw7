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
public class Shopping_basket {

	@Id
	private String basketid;

}
