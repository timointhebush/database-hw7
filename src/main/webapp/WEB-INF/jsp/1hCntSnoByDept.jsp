<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>1-h 학과 별 총 학생 수</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">학과</td>
				<td width="100">학생 수</td>
			</tr>
			<c:forEach items="${cntSnoByDepts}" var="cntSnoByDept">
				<tr>
					<td width="100">${cntSnoByDept.getDept()}</td>
					<td width="100">${cntSnoByDept.getCntSno()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


