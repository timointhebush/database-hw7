<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-f 과목 별 전체 평균 점수</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">과목 번호</td>
				<td width="100">평균 시험 점수</td>
			</tr>
			<c:forEach items="${meanExamByCnos}" var="meanExamByCno">
				<tr>
					<td width="100"><a href="/enroll/avg-exam/grade?cno=${meanExamByCno.getCno()}">
						${meanExamByCno.getCno()}
					</a></td>
					<td width="100">${meanExamByCno.getMeanExam()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


