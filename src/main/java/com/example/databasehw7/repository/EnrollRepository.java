package com.example.databasehw7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.domain.EnrollId;
import com.example.databasehw7.domain.Student;

public interface EnrollRepository extends JpaRepository<Enroll, EnrollId> {

	@Query(
		value = "select * from Enroll e where e.grade = ?1 and (e.exam < ?2 or e.exam > ?3)",
		nativeQuery = true
	)
	List<Enroll> findWrongGraded(String grade, Integer examFrom, Integer examTo);

	@Query(
		value = "select * from Enroll e "
			+ "join e.course c "
			+ "where e.student = ?1 and (c.cname like %?2% or e.grade = ?3 or e.exam = ?4)",
		nativeQuery = true
	)
	List<Enroll> findByStudentAndSearch(Student student, String cname, String grade, Integer exam);

	List<Enroll> findAllByStudent(Student student);
}
