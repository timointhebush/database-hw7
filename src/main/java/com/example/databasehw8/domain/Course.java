package com.example.databasehw8.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class Course {

	@Id
	private String cno;

	private String cname;

	private Integer credit;

	private Integer sessions;
}
