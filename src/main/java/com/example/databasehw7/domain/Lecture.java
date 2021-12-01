package com.example.databasehw7.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
public class Lecture {

	@EmbeddedId
	private LectureId lectureId;

	private String lec_time;

	private String room;
}
