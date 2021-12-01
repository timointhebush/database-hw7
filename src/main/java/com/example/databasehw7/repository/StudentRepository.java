package com.example.databasehw7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.databasehw7.domain.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

	@Override
	@Query(
		value = "SELECT * FROM STUDENT",
		nativeQuery = true
	)
	List<Student> findAll();

	@Modifying
	@Transactional
	@Query(
		value = "insert into STUDENT(ID, NAME, DEPT_NAME, TOT_CRED) values (:id, :name, :dept_name, :tot_cred)",
		nativeQuery = true
	)
	void saveOne(
		@Param("id") String id,
		@Param("name") String name,
		@Param("dept_name") String dept_name,
		@Param("tot_cred") Integer tot_cred
	);
}
