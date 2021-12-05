<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-c ${customerName} 주문 책</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">도서 제목</td>
				<td width="100">출판사</td>
				<td width="100">저자</td>
			</tr>
			<c:forEach items="${bookPublisherAuthors}" var="bpa">
				<tr>
					<td width="100">${bpa.getBname()}</td>
					<td width="100">${bpa.getPname()}</td>
					<td width="100">${bpa.getAname()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


