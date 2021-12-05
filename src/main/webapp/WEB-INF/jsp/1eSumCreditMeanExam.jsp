<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-e 학생 별 수강 과목 총 학점, 평균 시험 점수</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">학생 학번</td>
				<td width="100">총 학점</td>
				<td width="100">평균 시험 점수</td>
			</tr>
			<c:forEach items="${sumCreditMeanExams}" var="sumCreditMeanExam">
				<tr>
					<td width="100">${sumCreditMeanExam.getSno()}</td>
					<td width="100">${sumCreditMeanExam.getSumCredit()}</td>
					<td width="100">${sumCreditMeanExam.getMeanExam()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


