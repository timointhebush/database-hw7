<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-b Publisher Table</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">출판사 이름</td>
				<td width="100">출판사 주소</td>
				<td width="100">연락처</td>
				<td width="100">URL</td>
			</tr>
			<c:forEach items="${publisherList}" var="publisher">
				<tr>
					<td width="100">
						<a href="/publisher/book?name=${publisher.getName()}">
								${publisher.getName()}
						</a>
					</td>
					<td width="100">${publisher.getAddress()}</td>
					<td width="100">${publisher.getPhone()}</td>
					<td width="100">${publisher.getUrl()}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


