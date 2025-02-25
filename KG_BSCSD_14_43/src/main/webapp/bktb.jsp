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
      <th scope="col">bookingNumber</th>
      <th scope="col">customerName</th>
      <th scope="col">address</th>
      <th scope="col">telephone</th>
       <th scope="col">destination address</th>
       <th scope="col">distance</th>
        <th scope="col">vehicle</th>
         <th scope="col">amount</th>
      
    </tr>
  </thead>
  <tbody>
  
  <c:forEach var="cus" items="${cust}">
  <tr>
  <td>${cus.bookingNumber}</td>
  <td>${cus.customerName}</td>
  <td>${cus.address}</td>
  <td>${cus.telephone}</td>
  <td>${cus.destinationAddress}</td>
  <td>${cus.vehicle}</td>
  <td>${cus.amount}</td>
  
   <td><form action="" method="post">
    <input type="hidden" name="idnum" value="${cus.bookingNumber}">
    <button type="submit">add</button>
    </form></td>
    <td>
    <form action ="delbk" method="post">
    <input type="hidden" name="bookingNumber" value="${cus.bookingNumber}">
    <button type="submit">delete</button>
    </form>
    </td>
 
   
  </tr>
  </c:forEach>
   
  </tbody>
</table>
</body>
</html>