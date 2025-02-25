package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Bill;
import controller.database;

public class BillService {
    
    public boolean saveBill(Bill bill) {
        try (Connection con = database.getcon()) {
            String query = "INSERT INTO bill (bookingNumber, customerName, address, telephone, destinationAddress, distance, vehicle, amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bill.getBookingNumber());
            ps.setString(2, bill.getCustomerName());
            ps.setString(3, bill.getAddress());
            ps.setInt(4, bill.getTelephone());
            ps.setString(5, bill.getDestinationAddress());
            ps.setInt(6, bill.getDistance());
            ps.setInt(7, bill.getVehicle());
            ps.setInt(8, bill.getAmount());
            
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Bill> getBillByBookingNumber(String bookingNumber) {
        List<Bill> bills = new ArrayList<>();
        try (Connection con = database.getcon()) {
            String query = "SELECT * FROM bill WHERE bookingNumber = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookingNumber);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Bill bill = new Bill(
                    rs.getString("bookingNumber"),
                    rs.getString("customerName"),
                    rs.getString("address"),
                    rs.getInt("telephone"),
                    rs.getString("destinationAddress"),
                    rs.getInt("distance"),
                    rs.getInt("vehicle")
                   
                );
                bills.add(bill);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bills;
    }
}
