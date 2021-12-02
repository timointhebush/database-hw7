<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-a Enroll Table</h1>
		<h2>Table tuple 갯수 : ${enrollNum}</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">학생 번호</td>
				<td width="100">강좌 번호</td>
				<td width="100">학점</td>
				<td width="100">시험 점수</td>
			</tr>
			<c:forEach items="${enrollList}" var="enroll">
				<tr>
					<td width="100">${enroll.getStudent().getSno()}</td>
					<td width="100">${enroll.getCourse().getCno()}</td>
					<td width="100">${enroll.getGrade()}</td>
					<td width="100">${enroll.getExam()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


