package com.example.databasehw8.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name="EMP")
@Getter
@Builder
public class Employee {

    @Id
    private int empno;

    private String ename;

    private String job;

    private Integer mgr;

    private LocalDate hiredate;

    private int sal;

    private Integer comm;

    private int deptno;
}
