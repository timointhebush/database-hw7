package com.example.databasehw7.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name="EMP")
@Builder
public class Employee {

    @Id
    private int empno;

    private String ename;

    private String job;

    private int mgr;

    private LocalDate hiredate;

    private int sal;

    private int comm;

    private int deptno;
}
