package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Bill;
import service.BillService;

@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BillService billService = new BillService();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("download".equals(action)) {
            String bookingNumber = request.getParameter("bookingNumber");
            downloadBill(response, bookingNumber);
        } else {
            processBill(request, response);
        }
    }

    private void processBill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String bookingNumber = getParameterOrDefault(request, "order_number", "Unknown");
        String customerName = getParameterOrDefault(request, "name", "No Name");
        String address = getParameterOrDefault(request, "address", "No Address");
        String destinationAddress = getParameterOrDefault(request, "desaddress", "No Destination");

        int telephone = parseIntOrDefault(request.getParameter("tel"), 0);
        int distance = parseIntOrDefault(request.getParameter("destance"), 0);
        int vehicle = parseIntOrDefault(request.getParameter("option"), 0);
        int amount = parseIntOrDefault(request.getParameter("amount"), 0);

        // Debugging log (can be printed to server logs)
        System.out.println("Booking Number: " + bookingNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Address: " + address);
        System.out.println("Telephone: " + telephone);
        System.out.println("Destination Address: " + destinationAddress);
        System.out.println("Distance: " + distance);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Amount: " + amount);

        // Create and save the bill object
        Bill bill = new Bill(bookingNumber, customerName, address, telephone, destinationAddress, distance, vehicle);

        if (billService.saveBill(bill)) {
            response.sendRedirect("result.jsp");
        } else {
            response.sendRedirect("error.jsp?message=Error saving bill");
        }
    }

    private void downloadBill(HttpServletResponse response, String bookingNumber) throws IOException {
        List<Bill> bills = billService.getBillByBookingNumber(bookingNumber);
        
        response.setContentType("text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=bill_receipt.txt");

        PrintWriter writer = response.getWriter();

        if (bills.isEmpty()) {
            writer.println("No records found for Booking Number: " + bookingNumber);
        } else {
            writer.println("==============================================");
            writer.println("               MEGA CITY CAB                  ");
            writer.println("             TRANSACTION RECEIPT               ");
            writer.println("================================================");

            for (Bill bill : bills) {
                writer.println("Booking Number   : " + bill.getBookingNumber());
                writer.println("Customer Name    : " + bill.getCustomerName());
                writer.println("Address          : " + bill.getAddress());
                writer.println("Telephone        : " + bill.getTelephone());
                writer.println("Destination      : " + bill.getDestinationAddress());
                writer.println("Distance (km)    : " + bill.getDistance());
                writer.println("Vehicle          : " + bill.getVehicle());
                writer.println("Amount (Rs.)     : " + bill.getAmount());
                writer.println("---------------------------------------------");
            }
            
            writer.println("              THANK YOU! VISIT AGAIN         ");
            writer.println("=============================================");
        }
        
        writer.flush();
        writer.close();
    }

    /**
     * Helper method to get a request parameter with a default value if missing.
     */
    private String getParameterOrDefault(HttpServletRequest request, String paramName, String defaultValue) {
        String value = request.getParameter(paramName);
        return (value == null || value.trim().isEmpty()) ? defaultValue : value.trim();
    }

    /**
     * Helper method to safely parse an integer value from a string.
     * Returns the default value if parsing fails.
     */
    private int parseIntOrDefault(String value, int defaultValue) {
        if (value == null || value.trim().isEmpty()) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }
}
