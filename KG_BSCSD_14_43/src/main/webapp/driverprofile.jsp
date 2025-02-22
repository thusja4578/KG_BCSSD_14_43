<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<h1>My Profile</h1>
    <c:set var="cus" value="${customer}"/>
      
 <fieldset disabled>
 <!-- ******************************************************************************************************************************************* -->
  <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="driverid" value="${cus.driverid} placeholder="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">address</label>
                            <input type="text" class="form-control" name="name" value="${cus.name} placeholder="address">
                        </div>
                         
                        <div class="mb-3">
                            <label class="form-label">contact</label>
                            <input type="text" class="form-control" name="address" value="${cus.address} placeholder="contact">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input type="text" class="form-control" name="contact" value="${cus.contact} placeholder="Date of Birth">
                        </div>
                         <div class="mb-3">
                            <label class="form-label">ID card number</label>
                            <input type="text" class="form-control" name="dob" value="${cus.dob} placeholder="ID card number">
                        </div>
                       
                        <div class="mb-3">
                            <label class="form-label">Driving licen card number</label>
                            <input type="text" class="form-control" name="idnum" value="${cus.idnum} placeholder="Driving licen">
                        </div>
                       <div class="mb-3">
                            <label class="form-label">Driving licen card number</label>
                            <input type="text" class="form-control" name="licen" value="${cus.licen} placeholder="Driving licen">
                        </div>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-danger">Submit</button>
                        </div>
<!-- ********************************************************************************************************************************************* -->


<button type="submit" class="btn btn-danger">submit</button>
</fieldset>
</body>
</html>