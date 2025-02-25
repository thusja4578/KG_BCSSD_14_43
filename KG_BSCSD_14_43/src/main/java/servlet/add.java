package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.register;
import service.web_service;


@WebServlet("/add")
public class add extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public add() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 register app1 = new register();
	        app1.setRegistration_number(request.getParameter("registration_number"));
	        app1.setName(request.getParameter("name"));
	        app1.setAddress(request.getParameter("address"));
	        
	        try {
	            app1.setNic(Integer.parseInt(request.getParameter("nic")));
	        } catch (NumberFormatException e) {
	            response.getWriter().println("<script>alert('Invalid NIC. Please enter a valid number.'); window.location='register.jsp';</script>");
	            return;
	        }

	        app1.setUsername(request.getParameter("username"));
	        app1.setPassword(request.getParameter("password"));

	        web_service app2 = new web_service();
	        boolean success = false;
			try {
				success = app2.reg_user(app1);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (success) {
	            response.getWriter().println("<script>alert('Registration Successful!'); window.location='home.jsp';</script>");
	        } else {
	            response.getWriter().println("<script>alert('Registration Failed. Please try again!'); window.location='register.jsp';</script>");
	        }
	    }
		
	}


