package com.example.databasehw7.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "STUDENT")
@Getter
@Setter
@Builder
public class Student {

	@Id
	private Integer sno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pno")
	private Professor professor;

	private String sname;

	private Integer year;

	private String dept;
}
