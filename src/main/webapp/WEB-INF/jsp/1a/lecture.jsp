<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lecture</title>
	</header>

	<body>
		<h1>1-a Lecture Table</h1>
		<h2>Table tuple 갯수 : ${lectureNum}</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">강좌 번호</td>
				<td width="100">교수 번호</td>
				<td width="100">시간표</td>
				<td width="100">강의실</td>
			</tr>
			<c:forEach items="${lectureList}" var="lecture">
				<tr>
					<td width="100">${lecture.getCourse().getCno()}</td>
					<td width="100">${lecture.getProfessor().getPno()}</td>
					<td width="100">${lecture.getLec_time()}</td>
					<td width="100">${lecture.getRoom()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


