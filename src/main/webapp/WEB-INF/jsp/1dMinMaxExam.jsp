<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-d 과목 별 최고, 최저 점수를 획득한 학생</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">과목 번호</td>
				<td width="100">과목 이름</td>
				<td width="100">학생 이름</td>
				<td width="100">학생 학번</td>
				<td width="100">시험 점수</td>
			</tr>
			<c:forEach items="${enrollList}" var="enroll">
				<tr>
					<td width="100">${enroll.getCourse().getCno()}</td>
					<td width="100">${enroll.getCourse().getCname()}</td>
					<td width="100">${enroll.getStudent().getSname()}</td>
					<td width="100">${enroll.getStudent().getSno()}</td>
					<td width="100">${enroll.getExam()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


