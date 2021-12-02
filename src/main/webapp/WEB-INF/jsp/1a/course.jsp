<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>COURSE</title>
	</header>

	<body>
		<h1>1-a Course Table</h1>
		<h2>Table tuple 갯수 : ${courseNum}</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">강좌 번호</td>
				<td width="100">강좌 이름</td>
				<td width="100">학점</td>
				<td width="100">교시</td>
			</tr>
			<c:forEach items="${courseList}" var="course">
				<tr>
					<td width="100">${course.getCno()}</td>
					<td width="100">${course.getCname()}</td>
					<td width="100">${course.getCredit()}</td>
					<td width="100">${course.getSessions()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


