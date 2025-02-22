<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container-fluid mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body">
                    <center>
                        <img src="images/1.jpg" class="card-img-top" alt="profile image" width="100px">
                        <h4 class="mt-3"><b>Driver profile</b></h4>
                        <span>Account Status: Active</span>
                    </center>
                    <hr />

                    <form method="post" action="adddriver">
                        <div class="mb-3">
                            <label class="form-label">Name</label>
                            <input type="number" class="form-control" name="driverid" placeholder="name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">address</label>
                            <input type="text" class="form-control" name="name" placeholder="address">
                        </div>
                         
                        <div class="mb-3">
                            <label class="form-label">contact</label>
                            <input type="number" class="form-control" name="address" placeholder="contact">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Date of Birth</label>
                            <input type="number" class="form-control" name="contact" placeholder="Date of Birth">
                        </div>
                         <div class="mb-3">
                            <label class="form-label">ID card number</label>
                            <input type="date" class="form-control" name="dob" placeholder="ID card number">
                        </div>
                       
                        <div class="mb-3">
                            <label class="form-label">Driving licen card number</label>
                            <input type="text" class="form-control" name="idnum" placeholder="Driving licen">
                        </div>
                       <div class="mb-3">
                            <label class="form-label">Driving licen card number</label>
                            <input type="text" class="form-control" name="licen" placeholder="Driving licen">
                        </div>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-danger">Submit</button>
                        </div>
                    </form>
                    
                   
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.bundle.min.js"></script>
</body>
</html>