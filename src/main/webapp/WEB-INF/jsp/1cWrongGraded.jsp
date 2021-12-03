<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-c 학점이 잘못 기재되어있는 학생</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">학생 이름</td>
				<td width="100">학생 학번</td>
				<td width="100">과목 번호</td>
				<td width="100">학점</td>
				<td width="100">시험 점수</td>
				<td width="100">학점 수정</td>
			</tr>
			<c:forEach items="${wrongGradedEnrollList}" var="enroll">
				<tr>
					<td width="100">${enroll.getStudent().getSname()}</td>
					<td width="100">${enroll.getStudent().getSno()}</td>
					<td width="100">${enroll.getCourse().getCno()}</td>
					<td width="100">${enroll.getGrade()}</td>
					<td width="100">${enroll.getExam()}</td>
					<td width="100">
						<form method="get" action="/enroll/wrong/correct">
							<input type="hidden" name="sno" value="${enroll.getStudent().getSno()}">
							<input type="hidden" name="cno" value="${enroll.getCourse().getCno()}">
							<input type="submit" value="학점 수정하기">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


