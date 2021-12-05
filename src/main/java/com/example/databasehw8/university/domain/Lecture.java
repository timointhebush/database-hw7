package com.example.databasehw8.university.domain;

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
@IdClass(LectureId.class)
public class Lecture implements Serializable {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cno")
	private Course course;

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pno")
	private Professor professor;

	private String lec_time;

	private String room;
}
