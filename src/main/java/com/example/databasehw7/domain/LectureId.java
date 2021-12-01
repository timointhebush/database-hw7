package com.example.databasehw7.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

import lombok.Data;

@Embeddable
@Data
public class LectureId {

	@JoinColumn(name = "cno")
	private Course course;

	@JoinColumn(name = "pno")
	private Professor professor;
}
