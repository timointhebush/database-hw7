package com.example.databasehw8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.databasehw8.domain.Lecture;
import com.example.databasehw8.domain.LectureId;
import com.example.databasehw8.projection.CntCnoByMajor;

public interface LectureRepository extends JpaRepository<Lecture, LectureId> {

	@Query(value = "select p.pmajor major, count(l.cno) cntCno "
		+ "from Lecture l "
		+ "  join Professor p on l.pno = p.pno "
		+ "group by p.pmajor",
		nativeQuery = true
	)
	public List<CntCnoByMajor> findCntLec();
}
