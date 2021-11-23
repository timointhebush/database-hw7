<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <header>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Test page</title>
    </header>
    <body>
        <h2>Hello! employees</h2>

        <table class="table table-hover table table-striped">
            <tr>
                <th>Employee Number</th>
                <th>Employee Name</th>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <th>${employee.getEmpno()}</th>
                    <th>${employee.getEname()}</th>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>


