<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table>
    <tr>
        <th>Driver ID</th>
        <th>Driver Name</th>
        <th>Vehicle ID</th>
        <th>Vehicle Model</th>
    </tr>
    <c:forEach var="assignment" items="${assignments}">
        <tr>
            <td>${assignment.driverId}</td>
            <td>${assignment.driverName}</td>
            <td>${assignment.vehicleId}</td>
            <td>${assignment.vehicleModel}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>