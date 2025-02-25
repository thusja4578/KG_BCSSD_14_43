<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>


<!-- ************************************************************************************************************************************************** -->
<div class="container-fluid mt-5">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card shadow-sm">
                    <div class="card-body">
                        <center>
                        <img src="images/1.jpg" class="card-img-top" alt="profile iamage"width="100px" >
                            
                            <h4 class="mt-3"><b>Customer sign-up</b></h4>
                            <span>Account Status: Active</span>
                        </center>
                        <hr />

                      <form method="post" action="add">

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">registration number</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name="registration_number" placeholder="registration number">
</div>


<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">name</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name="name" placeholder="name">
</div>



<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">address</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name="address" placeholder="address">
</div>


<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">nic</label>
  <input type="number" class="form-control" id="formGroupExampleInput" name="nic" placeholder="nic">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">user name</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name="username" placeholder="user name">
</div>

<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">password</label>
  <input type="password" class="form-control" id="formGroupExampleInput" name="password" placeholder="password">
</div>

<button type="submit" class="btn btn-danger">submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
</form>
</body>
</html>