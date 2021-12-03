<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>1-a Student Table</h1>
		<h2>Table tuple 갯수 : ${studentNum}</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">학생 번호</td>
				<td width="100">담당 교수 번호</td>
				<td width="100">학생 이름</td>
				<td width="100">입학 년도</td>
				<td width="100">부서</td>
			</tr>
			<c:forEach items="${studentList}" var="student">
				<tr>
					<td width="100">${student.getSno()}</td>
					<td width="100">${student.getProfessor().getPno()}</td>
					<td width="100"><a href="/student/enroll?sno=${student.getSno()}">${student.getSname()}</a></td>
					<td width="100">${student.getYear()}</td>
					<td width="100">${student.getDept()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


