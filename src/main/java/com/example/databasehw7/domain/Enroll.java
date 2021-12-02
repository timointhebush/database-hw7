package com.example.databasehw7.domain;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@IdClass(EnrollId.class)
public class Enroll implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sno")
	private Student student;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cno")
	private Course course;

	private String grade;

	private Integer exam;
}
