package com.example.databasehw7.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.databasehw7.domain.Enroll;
import com.example.databasehw7.domain.EnrollId;
import com.example.databasehw7.domain.Student;
import com.example.databasehw7.projection.SumCreditMeanExam;

public interface EnrollRepository extends JpaRepository<Enroll, EnrollId> {

	@Query(
		value = "select * from Enroll e where e.grade = ?1 and (e.exam < ?2 or e.exam > ?3)",
		nativeQuery = true
	)
	List<Enroll> findWrongGraded(String grade, Integer examFrom, Integer examTo);

	List<Enroll> findAllByStudent(Student student);

	@Query(
		value = "select * from Enroll e "
			+ "join Course c on e.cno = c.cno "
			+ "where e.sno = ?1 and c.cname like %?2%",
		nativeQuery = true)
	List<Enroll> findAllByStudentAndCname(Integer sno, String cname);

	@Query(
		value = "select * from Enroll e "
			+ "join Course c on e.cno = c.cno "
			+ "where e.sno = ?1 and c.credit = ?2",
		nativeQuery = true)
	List<Enroll> findAllByStudentAndCredit(Integer sno, Integer credit);

	@Query(
		value = "select * from Enroll e where e.sno = ?1 and e.exam = ?2",
		nativeQuery = true)
	List<Enroll> findAllByStudentAndExam(Integer sno, Integer exam);

	@Query(
		value = "select * "
			+ "from Enroll e "
			+ "join Student s on e.sno = s.sno "
			+ "where e.exam = (select max(e2.exam) from Enroll e2 where e2.cno = e.cno) ",
		nativeQuery = true
	)
	List<Enroll> findAllMaxExam();

	@Query(
		value = "select * "
			+ "from Enroll e "
			+ "join Student s on e.sno = s.sno "
			+ "where e.exam = (select min(e2.exam) from Enroll e2 where e2.cno = e.cno) ",
		nativeQuery = true
	)
	List<Enroll> findAllMinExam();

	@Query(
		value = "select s.sno sno, sum(c.credit) sumCredit, avg(e.exam) meanExam "
			+ "from Enroll e "
			+ "join Student s on e.sno = s.sno "
			+ "join Course c on e.cno = c.cno "
			+ "group by s.sno ",
		nativeQuery = true
	)
	List<SumCreditMeanExam> findStudentSumCreditMeanExam();
}
