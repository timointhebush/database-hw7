<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-b ${publisherName} 출판사의 책들</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">도서 제목</td>
				<td width="100">도서 가격</td>
				<td width="100">도서 재고 수량</td>
			</tr>
			<c:forEach items="${stocksList}" var="stocks">
				<tr>
					<td width="100">${stocks.getBook().getTitle()}</td>
					<td width="100">${stocks.getBook().getPrice()}</td>
					<td width="100">
						<c:if test="${stocks.getNum() eq 0}">
							재고가 없습니다.
						</c:if>
						<c:if test="${stocks.getNum() ne 0}">
							${stocks.getNum()}
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


