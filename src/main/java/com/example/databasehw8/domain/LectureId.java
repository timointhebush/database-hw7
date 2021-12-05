package com.example.databasehw8.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureId implements Serializable {
	private Course course;
	private Professor professor;
}
