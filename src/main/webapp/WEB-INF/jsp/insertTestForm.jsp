<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
	<header>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>레코드 삽입</title>
	</header>
	<body>
		<p>Student 테이블에 레코드 삽입(추가) 예제</p>
		<form name="stuform" method="post" action="/student">
			<p>아이디 : <input type="text" name="id"></p>
			<p>이름 : <input type="text" name="name"></p>
			<p>학과명 : <input type="text" name="deptName"></p>
			<p>이수학점 : <input type="text" name="tot"></p>
			<p><input type="submit" name="Submit" value="보내기"></p>
		</form>
	</body>
</html>

