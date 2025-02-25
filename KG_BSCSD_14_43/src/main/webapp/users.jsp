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
      <th scope="col">Registration_number</th>
      <th scope="col">name</th>
      <th scope="col">address</th>
      <th scope="col">NIC</th>
       <th scope="col">username</th>
       <th scope="col">password</th>
        
      
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="cus" items="${cust}">
  <tr>
  <td>${cus.registration_number}</td>
  <td>${cus.name}</td>
  <td>${cus.address}</td>
  <td>${cus.nic}</td>
  <td>${cus.username}</td>
  <td>${cus.password}</td>

  
   <td><form action="" method="post">
    <input type="hidden" name="registration_number" value="${cus.registration_number}">
    <button type="submit">add</button>
    </form></td>
    <td>
    <form action ="deluser" method="post">
    <input type="hidden" name="registration_number" value="${cus.registration_number}">
    <button type="submit">delete</button>
    </form>
    </td>
 
   
  </tr>
  </c:forEach>
   
  </tbody>
</table>
</body>
</html>