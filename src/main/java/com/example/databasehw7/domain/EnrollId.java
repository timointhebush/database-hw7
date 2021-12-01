package com.example.databasehw7.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import lombok.Data;

@Data
@Embeddable
public class EnrollId implements Serializable {

	@JoinColumn(name = "sno")
	private Student student;

	@JoinColumn(name = "cno")
	private Course course;
}
