<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<header>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>레코드 삽입</title>
</header>
<body>
<p> Book,에 새로운 레코드를 삽입(추가) 했습니다.</p>
${book.getTitle()}
<p> Author, Written_by에 새로운 레코드를 삽입(추가) 했습니다.</p>
${author.getName()}
<p> Publisher, Published_by에 새로운 레코드를 삽입(추가) 했습니다.</p>
${publisher.getName()}
</body>
</html>

