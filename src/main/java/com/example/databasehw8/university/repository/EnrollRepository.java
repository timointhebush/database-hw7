package com.example.databasehw8.university.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.databasehw8.university.domain.Enroll;
import com.example.databasehw8.university.domain.EnrollId;
import com.example.databasehw8.university.domain.Student;
import com.example.databasehw8.university.projection.CntSnoByGrade;
import com.example.databasehw8.university.projection.MeanExamByCno;
import com.example.databasehw8.university.projection.SumCreditMeanExam;

public interface EnrollRepository extends JpaRepository<Enroll, EnrollId> {

	/**
	 * 잘못 학점이 설정된 Enroll을 반환
	 * @param grade
	 * @param examFrom
	 * @param examTo
	 * @return
	 */
	@Query(
		value = "select * from Enroll e where e.grade = ?1 and (e.exam < ?2 or e.exam > ?3)",
		nativeQuery = true
	)
	List<Enroll> findWrongGraded(String grade, Integer examFrom, Integer examTo);

	List<Enroll> findAllByStudent(Student student);

	/**
	 * 학생 번호와 수강하는 Course 이름으로 검색
	 * @param sno
	 * @param cname
	 * @return
	 */
	@Query(
		value = "select * from Enroll e "
			+ "join Course c on e.cno = c.cno "
			+ "where e.sno = ?1 and c.cname like %?2%",
		nativeQuery = true)
	List<Enroll> findAllByStudentAndCname(Integer sno, String cname);

	/**
	 * 학생 번호와 Credit으로 검색
	 * @param sno
	 * @param credit
	 * @return
	 */
	@Query(
		value = "select * from Enroll e "
			+ "join Course c on e.cno = c.cno "
			+ "where e.sno = ?1 and c.credit = ?2",
		nativeQuery = true)
	List<Enroll> findAllByStudentAndCredit(Integer sno, Integer credit);

	/**
	 * 학생 번호와 exam으로 검색
	 * @param sno
	 * @param exam
	 * @return
	 */
	@Query(
		value = "select * from Enroll e where e.sno = ?1 and e.exam = ?2",
		nativeQuery = true)
	List<Enroll> findAllByStudentAndExam(Integer sno, Integer exam);

	/**
	 * 최고 점수를 받은 학생들을 반환
	 * @return
	 */
	@Query(
		value = "select * "
			+ "from Enroll e "
			+ "join Student s on e.sno = s.sno "
			+ "where e.exam = (select max(e2.exam) from Enroll e2 where e2.cno = e.cno) ",
		nativeQuery = true
	)
	List<Enroll> findAllMaxExam();

	/**
	 * 최저 점수를 받은 학생들을 반환
	 * @return
	 */
	@Query(
		value = "select * "
			+ "from Enroll e "
			+ "join Student s on e.sno = s.sno "
			+ "where e.exam = (select min(e2.exam) from Enroll e2 where e2.cno = e.cno) ",
		nativeQuery = true
	)
	List<Enroll> findAllMinExam();

	/**
	 * Credit 합과 평균 시험 점수를 반환
	 * @return
	 */
	@Query(
		value = "select s.sno sno, sum(c.credit) sumCredit, avg(e.exam) meanExam "
			+ "from Enroll e "
			+ "join Student s on e.sno = s.sno "
			+ "join Course c on e.cno = c.cno "
			+ "group by s.sno ",
		nativeQuery = true
	)
	List<SumCreditMeanExam> findStudentSumCreditMeanExam();

	/**
	 * cno에 따른 평균 시험 점수를 반환
	 * @return
	 */
	@Query(
		value = "select e.cno cno, avg(e.exam) meanExam "
			+ "from Enroll e "
			+ "group by e.cno",
		nativeQuery = true
	)
	List<MeanExamByCno> findMeanExamByCno();

	/**
	 * 학년에 따른 학생 수를 반환
	 * @param cno
	 * @return
	 */
	@Query(
		value = "select e.cno cno, e.grade grade, count(e.sno) cntSno "
			+ "from Enroll e "
			+ "group by e.cno, e.grade "
			+ "having e.cno = ?1",
		nativeQuery = true
	)
	List<CntSnoByGrade> findCntSnoByGrade(String cno);
}
