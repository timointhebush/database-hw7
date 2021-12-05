package com.example.databasehw8.repository;

import com.example.databasehw8.projection.CntSnoByDept;
import com.example.databasehw8.projection.CntSnoByYear;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.databasehw8.domain.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select s.year year, count(s.sno) cntSno " +
            "from Student s " +
            "group by s.year ",
    nativeQuery = true)
    public List<CntSnoByYear> getCntSnoByYear();

    @Query(value = "select s.dept year, count(s.sno) cntSno " +
            "from Student s " +
            "group by s.dept ",
            nativeQuery = true)
    public List<CntSnoByDept> getCntSnoByDept();

}
