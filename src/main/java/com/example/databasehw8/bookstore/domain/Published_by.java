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
public class Published_by implements Serializable {

	@EmbeddedId
	private Published_byId published_byId;

}
