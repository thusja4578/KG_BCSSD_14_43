<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h2>Select Phone Size</h2>
    <form action="${pageContext.request.contextPath}/helpfactory" method="post">
        <label for="size">Choose size:</label>
        <select name="size" id="size">
            <option value="low">Low</option>
            <option value="medium">Medium</option>
            <option value="large">Large</option>
        </select>
        <input type="submit" value="Submit">
    </form>
</body>
</html>