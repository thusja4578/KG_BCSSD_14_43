<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Sign-up</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container-fluid mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow-sm">
                <div class="card-body">
                    <center>
                        <img src="images/1.jpg" class="card-img-top" alt="profile image" width="100px">
                        <h4 class="mt-3"><b>Customer Sign-up</b></h4>
                        <span>Account Status: Active</span>
                    </center>
                    <hr />

                    <form method="post" action="BillServlet">
                        <div class="mb-3">
                            <label class="form-label">Booking Number</label>
                            <input type="text" class="form-control" name="order_number" placeholder="Booking Number">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Customer Name</label>
                            <input type="text" class="form-control" name="name" placeholder="Name">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control" name="address" placeholder="Address">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Telephone Number</label>
                            <input type="number" class="form-control" name="tel" placeholder="Telephone">
                        </div>
                        <div class="mb-3">
                            <h1>Destination Details</h1>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control" name="desaddress" placeholder="Destination Address">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Distance</label>
                            <input type="number" class="form-control" name="destance" placeholder="Distance">
                        </div>
                        <div class="mb-3">
                            <label for="options">Choose a Vehicle:</label>
                            <select id="options" name="option" class="form-control">
                                <option value="100">Tuk Tuk</option>
                                <option value="200">Van</option>
                                <option value="300">Car</option>
                                <option value="400">Jeep</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <button type="submit" class="btn btn-danger">Submit</button>
                        </div>
                    </form>
                    
                    <h1>Download Bills</h1>
                    <form action="BillServlet" method="post">
                        <input type="hidden" name="action" value="download">
                        <button type="submit" class="btn btn-primary">Download Bills</button>
                    </form>
                    
                      <form action="BillServlet" method="post">
        <input type="hidden" name="action" value="download">
        <label for="bookingNumber">Enter Booking Number:</label>
        <input type="text" id="bookingNumber" name="bookingNumber" required>
        <button type="submit">Download Receipt</button>
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