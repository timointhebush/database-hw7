<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-c Customer Table</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">이메일</td>
				<td width="100">이름</td>
				<td width="100">주소</td>
				<td width="100">연락처</td>
			</tr>
			<c:forEach items="${customerList}" var="customer">
				<tr>
					<td width="100">${customer.getEmail()}</td>
					<td width="100">
						<a href="/customer/book?email=${customer.getEmail()}">
								${customer.getName()}
						</a>
					</td>
					<td width="100">${customer.getAddress()}</td>
					<td width="100">${customer.getPhone()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


