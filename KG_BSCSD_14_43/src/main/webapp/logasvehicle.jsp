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
                        <h4 class="mt-3"><b>vehicle profile</b></h4>
                        <span>Account Status: Active</span>
                    </center>
                    <hr />

                    <form method="post" action="logvehicle">
                        <div class="mb-3">
                            <label class="form-label">plate</label>
                            <input type="text" class="form-control" name="model" placeholder="model">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">brand</label>
                            <input type="text" class="form-control" name="license_plate" placeholder="license plate">
                        </div>
                          
                        <div class="mb-3">
                            <button type="submit" class="btn btn-danger">log in</button>
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