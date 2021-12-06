<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-f 전체 도서 평균 가격</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">평균 가격</td>
			</tr>
			<c:forEach items="${avgBookPrices}" var="avgBookPrice">
				<tr>
					<td width="100">${avgBookPrice.getAvgPrice()}</td>
				</tr>
			</c:forEach>
		</table>

		<h1>2-f 년도 별 평균 가격</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">년도</td>
				<td width="100">평균 가격</td>
			</tr>
			<c:forEach items="${avgBookPriceByYears}" var="avgBookPriceByYear">
				<tr>
					<td width="100">${avgBookPriceByYear.getYear()}</td>
					<td width="100">${avgBookPriceByYear.getAvgPrice()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


