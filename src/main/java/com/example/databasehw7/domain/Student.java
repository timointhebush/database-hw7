package com.example.databasehw7.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DEPT_NAME")
	private String deptName;

	@Column(name = "TOT_CRED")
	private Integer tot;
}
