<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-b ${student.getSname()}가 수강하는 Course</h1>
		<h2>검색하기</h2>
		<form method="get" action="/student/enroll/search/cname">
			<input type="hidden" name="sno" value="${student.getSno()}">
			<p>Course 이름 :
				<input type="text" name="cname">
				<input type="submit" name="Submit" value="검색">
			</p>
		</form>
		<form method="get" action="/student/enroll/search/credit">
			<input type="hidden" name="sno" value="${student.getSno()}">
			<p>학점 :
				<input type="text" name="credit">
				<input type="submit" name="Submit" value="검색">
			</p>
		</form>
		<form method="get" action="/student/enroll/search/exam">
			<input type="hidden" name="sno" value="${student.getSno()}">
			<p>시험 점수 :
				<input type="text" name="exam">
				<input type="submit" name="Submit" value="검색">
			</p>
		</form>

		<table width="500" border="1">
			<tr>
				<td width="100">강좌 번호</td>
				<td width="100">강좌 이름</td>
				<td width="100">강좌 학점</td>
				<td width="100">강좌 교시</td>
				<td width="100">학생 성적</td>
				<td width="100">시험 점수</td>
			</tr>
			<c:forEach items="${enrollList}" var="enroll">
				<tr>
					<td width="100">${enroll.getCourse().getCno()}</td>
					<td width="100">${enroll.getCourse().getCname()}</td>
					<td width="100">${enroll.getCourse().getCredit()}</td>
					<td width="100">${enroll.getCourse().getSessions()}</td>
					<td width="100">${enroll.getGrade()}</td>
					<td width="100">${enroll.getExam()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


