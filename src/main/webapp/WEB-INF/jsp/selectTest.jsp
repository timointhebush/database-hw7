<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>레코드 출력</title>
	</header>
	<body>
		<table width="500" border="1">
			<tr>
				<td width="100">학생 번호</td>
				<td width="100">교수 번호</td>
				<td width="100">학생 이름</td>
				<td width="100">년도</td>
				<td width="100">전공</td>
			</tr>
			<c:forEach items="${students}" var="student">
				<tr>
					<td width="100">${student.getSno}</td>
					<td width="100">${student.getPno()}</td>
					<td width="100">${student.getSname()}</td>
					<td width="100">${student.getYear()}</td>
					<td width="100">${student.getDept()}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>


