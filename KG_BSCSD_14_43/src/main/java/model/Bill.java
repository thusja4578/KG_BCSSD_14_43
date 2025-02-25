package model;

public class Bill {
	
    private String bookingNumber;
   

	public void setAmount(int amount) {
		this.amount = amount;
	}

	private String customerName;
    private String address;
    private int telephone;
    private String destinationAddress;
    private int distance;
    private int vehicle;
    private int amount;

    public Bill(String bookingNumber, String customerName, String address, int telephone, String destinationAddress, int distance, int vehicle) {
        this.bookingNumber = bookingNumber;
        this.customerName = customerName;
        this.address = address;
        this.telephone = telephone;
        this.destinationAddress = destinationAddress;
        this.distance = distance;
        this.vehicle = vehicle;
        this.amount = distance * vehicle;
    }

    public String getBookingNumber() { return bookingNumber; }
    public void setBookingNumber(String bookingNumber) { this.bookingNumber = bookingNumber; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getTelephone() { return telephone; }
    public void setTelephone(int telephone) { this.telephone = telephone; }

    public String getDestinationAddress() { return destinationAddress; }
    public void setDestinationAddress(String destinationAddress) { this.destinationAddress = destinationAddress; }

    public int getDistance() { return distance; }
    public void setDistance(int distance) { this.distance = distance; }

    public int getVehicle() { return vehicle; }
    public void setVehicle(int vehicle) { this.vehicle = vehicle; }

    public int getAmount() { return amount; }
}
