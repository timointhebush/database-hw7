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
public class Written_by implements Serializable {

	@EmbeddedId
	private Written_byId written_byId;

}
