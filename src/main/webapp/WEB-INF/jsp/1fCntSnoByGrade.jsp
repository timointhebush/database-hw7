<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-f ${cname} 과목 성적 별 학생 수</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">과목 번호</td>
				<td width="100">성적</td>
				<td width="100">학생 수</td>
			</tr>
			<c:forEach items="${cntSnoByGrades}" var="cntSnoByGrade">
				<tr>
					<td width="100">${cntSnoByGrade.getCno()}</td>
					<td width="100">${cntSnoByGrade.getGrade()}</td>
					<td width="100">${cntSnoByGrade.getCntSno()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


