<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-f 작가 별 책 정보</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">작가 이름</td>
				<td width="100">총 책 개수</td>
				<td width="100">책 최고 가격</td>
				<td width="100">책 최저 가격</td>
				<td width="100">책 평균 가격</td>
			</tr>
			<c:forEach items="${cntMinMaxAvgByAuthors}" var="cntMinMaxAvgByAuthor">
				<tr>
					<td width="100">${cntMinMaxAvgByAuthor.getAname()}</td>
					<td width="100">${cntMinMaxAvgByAuthor.getCnt()}</td>
					<td width="100">${cntMinMaxAvgByAuthor.getMaxPrice()}</td>
					<td width="100">${cntMinMaxAvgByAuthor.getMinPrice()}</td>
					<td width="100">${cntMinMaxAvgByAuthor.getAvgPrice()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


