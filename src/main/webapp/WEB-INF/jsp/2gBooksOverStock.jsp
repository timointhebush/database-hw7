<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-g 재고 ${pivotNum}개 이상 책 ISBN</h1>
		<h2>할인하기</h2>
		<form method="get" action="/book/discount">
			<input type="number" name="discountPercent" placeholder="할인율">
			<input type="hidden" name="pivotNum" value="${pivotNum}">
			<input type="submit" value="할인하기">
		</form>
		<h2>책과 재고</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">ISBN</td>
				<td width="100">재고</td>
			</tr>
			<c:forEach items="${sumNumByBooks}" var="sumNumByBook">
				<tr>
					<td width="100">${sumNumByBook.getSisbn()}</td>
					<td width="100">${sumNumByBook.getSumNum()}</td>
				</tr>
			</c:forEach>
		</table>
		<h2>해당 책 정보</h2>
		<table width="500" border="1">
			<tr>
				<td width="100">ISBN</td>
				<td width="100">제목</td>
				<td width="100">가격</td>
			</tr>
			<c:forEach items="${bookList}" var="book">
			<tr>
				<td width="100">${book.getIsbn()}</td>
				<td width="100">${book.getTitle()}</td>
				<td width="100">${book.getPrice()}</td>
			</tr>
			</c:forEach>
		</table>



	</body>
</html>


