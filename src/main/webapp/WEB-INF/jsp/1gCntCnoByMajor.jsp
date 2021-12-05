<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-g 학과 별 개설된 강좌 수</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">학과</td>
				<td width="100">강좌 수</td>
			</tr>
			<c:forEach items="${cntCnoByMajors}" var="cntCnoByMajor">
				<tr>
					<td width="100">${cntCnoByMajor.getMajor()}</td>
					<td width="100">${cntCnoByMajor.getCntCno()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


