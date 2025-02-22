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
<h1>My Profile</h1>
    <c:set var="cus" value="${customer}"/>
      
 <fieldset disabled>
 <!-- ******************************************************************************************************************************************* -->
   <div class="mb-3">
                            <label class="form-label">vehicle ID</label>
                            <input type="text" class="form-control" name="vehicleid" value="${cus.vehicleid} placeholder="plate">
                        </div>
                       
                      <div class="mb-3">
                            <label class="form-label">Lisence plate</label>
                            <input type="text" class="form-control" name="model" value="${cus.model} placeholder="brand">
                        </div>
                             <div class="mb-3">
                            <label class="form-label">Lisence plate</label>
                            <input type="text" class="form-control" name="licenseplate" value="${cus.licenseplate} placeholder="brand">
                        </div>
                     
                        <div class="mb-3">
                            <label class="form-label">color</label>
                            <input type="text" class="form-control" name="color" value="${cus.color} placeholder="color">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">engine capacity</label>
                            <input type="text" class="form-control" name="engine" value="${cus.engine} placeholder="engine capacity">
                        </div>
                         <div class="mb-3">
                            <label class="form-label">chassi number</label>
                            <input type="text" class="form-control" name="chasi" value="${cus.chasi} placeholder="chassi number">
                        </div>
                        <div class="mb-3">
                            <h1>owner Details</h1>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">name</label>
                            <input type="text" class="form-control" name="name" value="${cus.name} placeholder="full name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">email</label>
                            <input type="text" class="form-control" name="email" value="${cus.email} placeholder="E-mail">
                        </div>
                          <div class="mb-3">
                            <label class="form-label">phone</label>
                            <input type="text" class="form-control" name="phone" value="${cus.phone} placeholder="phone">
                        </div>
                        
                         <div class="mb-3">
                            <label class="form-label">ID number</label>
                            <input type="text" class="form-control" name="idnum" value="${cus.idnum} placeholder="ID">
                        </div>
                        
                          <div class="mb-3">
                            <h1>Insuarence details</h1>
                        </div>
                          <div class="mb-3">
                            <label class="form-label">provider name</label>
                            <input type="text" class="form-control" name="provider" value="${cus.provider} placeholder="provider name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">policy number</label>
                            <input type="text" class="form-control" name="policy" value="${cus.policy} placeholder="policy number">
                        </div>
                          <div class="mb-3">
                            <label class="form-label">expire date</label>
                            <input type="text" class="form-control" name="expire" value="${cus.expire} placeholder="expire date">
                        </div>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-danger">Submit</button>
                        </div>
<!-- ********************************************************************************************************************************************* -->


<button type="submit" class="btn btn-danger">submit</button>
</fieldset>
</body>
</html>