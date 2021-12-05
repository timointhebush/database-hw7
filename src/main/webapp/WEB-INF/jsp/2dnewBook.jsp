<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ENROLL</title>
	</header>

	<body>
		<h1>2-d 새로운 도서 등록</h1>
		<h2>등록하기</h2>
		<form method="post" action="/book/register">
			<p>책 ISBN : <input type="text" name="isbn"></p>
			<p>책 제목 : <input type="text" name="title"></p>
			<p>책 년도 : <input type="text" name="year"></p>
			<p>책 가격 : <input type="text" name="price"></p>

			<p>저자 이름 : <input type="text" name="aName"></p>
			<p>저자 주소 : <input type="text" name="aAddress"></p>
			<p>저자 URL : <input type="text" name="aUrl"></p>

			<p>출판사 이름 : <input type="text" name="pName"></p>
			<p>출판사 주소 : <input type="text" name="pAddress"></p>
			<p>출판사 연락처 : <input type="text" name="phone"></p>
			<p>출판사 URL : <input type="text" name="pUrl"></p>

			<p>창고 별 재고 입력</p>
			<c:forEach items="${warehouseList}" var="warehouse">
				<p>${warehouse.getCode()} : <input type="text" name="${warehouse.getCode()}Num"></p>
			</c:forEach>

			<p><input type="submit" name="Submit" value="등록하기"></p>
		</form>

	</body>
</html>


