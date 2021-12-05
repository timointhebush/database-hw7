<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Student</title>
	</header>

	<body>
		<h1>2-a Author Table</h1>
		<table width="500" border="1">
			<tr>
				<td width="100">작가 이름</td>
				<td width="100">작가 주소</td>
				<td width="100">URL</td>
			</tr>
			<c:forEach items="${authorList}" var="author">
				<tr>
					<td width="100">
						<a href="/author/book?name=${author.getName()}&address=${author.getAddress()}">
								${author.getName()}
						</a>
					</td>
					<td width="100">${author.getAddress()}</td>
					<td width="100">${author.getUrl}</td>
				</tr>
			</c:forEach>
		</table>

	</body>
</html>


