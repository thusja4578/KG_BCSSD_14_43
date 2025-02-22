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
<table class="table">
  <thead>
    <tr>
      <th scope="col">Driverid</th>
      <th scope="col">name</th>
      <th scope="col">address</th>
      <th scope="col">contact</th>
       <th scope="col">date of birth</th>
       <th scope="col">id number</th>
        <th scope="col">license number</th>
      
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="cus" items="${cust}">
  <tr>
  <td>${cus.driverid}</td>
  <td>${cus.name}</td>
  <td>${cus.address}</td>
  <td>${cus.contact}</td>
  <td>${cus.dob}</td>
  <td>${cus.idnum}</td>
  <td>${cus.licen}</td>
  
   <td><form action="" method="post">
    <input type="hidden" name="idnum" value="${cus.idnum}">
    <button type="submit">add</button>
    </form></td>
    <td>
    <form action ="deldriver" method="post">
    <input type="hidden" name="idnum" value="${cus.idnum}">
    <button type="submit">delete</button>
    </form>
    </td>
 
   
  </tr>
  </c:forEach>
   
  </tbody>
</table>
</body>
</html>