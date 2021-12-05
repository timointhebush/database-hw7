package com.example.databasehw8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.databasehw8.domain.Enroll;
import com.example.databasehw8.domain.EnrollId;
import com.example.databasehw8.domain.Student;
import com.example.databasehw8.projection.CntSnoByGrade;
import com.example.databasehw8.projection.MeanExamByCno;
import com.example.databasehw8.projection.SumCreditMeanExam;

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

	@Query(
		value = "select e.cno cno, avg(e.exam) meanExam "
			+ "from Enroll e "
			+ "group by e.cno",
		nativeQuery = true
	)
	List<MeanExamByCno> findMeanExamByCno();

	@Query(
		value = "select e.cno cno, e.grade grade, count(e.sno) cntSno "
			+ "from Enroll e "
			+ "group by e.cno, e.grade "
			+ "having e.cno = ?1",
		nativeQuery = true
	)
	List<CntSnoByGrade> findCntSnoByGrade(String cno);
}
