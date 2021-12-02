<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>professor</title>
	</header>

	<body>
		<h1>1-a Professor Table</h1>
		<h2>Table tuple 갯수 : ${professorNum}</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">교수 번호</td>
				<td width="100">교수 이름</td>
				<td width="100">교수 전공</td>
				<td width="100">교수 부서</td>
			</tr>
			<c:forEach items="${professorList}" var="professor">
				<tr>
					<td width="100">${professor.getPno()}</td>
					<td width="100">${professor.getPname()}</td>
					<td width="100">${professor.getPmajor()}</td>
					<td width="100">${professor.getPdept()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


