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

                    <form method="post" action="updatevehicle">
                        <div class="mb-3">
                            <label class="form-label">vehicle ID</label>
                            <input type="text" class="form-control" name="vehicleid" placeholder="plate">
                        </div>
                       
                          <div class="mb-3">
                            <label for="options">Choose a Vehicle:</label>
                            <select id="options" name="model" class="form-control">
                                <option value="tuk tuk">Tuk Tuk</option>
                                <option value="van">Van</option>
                                <option value="car">Car</option>
                                <option value="jeep">Jeep</option>
                            </select>
                            
                             <div class="mb-3">
                            <label class="form-label">Lisence plate</label>
                            <input type="text" class="form-control" name="licenseplate" placeholder="brand">
                        </div>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">color</label>
                            <input type="text" class="form-control" name="color" placeholder="color">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">engine capacity</label>
                            <input type="text" class="form-control" name="engine" placeholder="engine capacity">
                        </div>
                         <div class="mb-3">
                            <label class="form-label">chassi number</label>
                            <input type="text" class="form-control" name="chasi" placeholder="chassi number">
                        </div>
                        <div class="mb-3">
                            <h1>owner Details</h1>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">name</label>
                            <input type="text" class="form-control" name="name" placeholder="full name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">email</label>
                            <input type="text" class="form-control" name="email" placeholder="E-mail">
                        </div>
                          <div class="mb-3">
                            <label class="form-label">phone</label>
                            <input type="number" class="form-control" name="phone" placeholder="phone">
                        </div>
                        
                         <div class="mb-3">
                            <label class="form-label">ID number</label>
                            <input type="number" class="form-control" name="idnum" placeholder="ID">
                        </div>
                        
                          <div class="mb-3">
                            <h1>Insuarence details</h1>
                        </div>
                          <div class="mb-3">
                            <label class="form-label">provider name</label>
                            <input type="text" class="form-control" name="provider" placeholder="provider name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">policy number</label>
                            <input type="text" class="form-control" name="policy" placeholder="policy number">
                        </div>
                          <div class="mb-3">
                            <label class="form-label">expire date</label>
                            <input type="date" class="form-control" name="expire" placeholder="expire date">
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