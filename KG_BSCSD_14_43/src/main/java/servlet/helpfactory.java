package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.help;

import service.web_service;


@WebServlet("/helpfactory")
public class helpfactory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public helpfactory() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // Get the size parameter from the form submission
        String size = request.getParameter("size");

        // Use the PhoneFactory to create a phone based on the size
        web_service phoneFactory = new web_service();
        help phone = phoneFactory.createhelp(size);

        if (phone != null) {
            // Set the phone brand as a request attribute and forward to result.jsp
            request.setAttribute("phoneBrand", phone.getChoice());
            request.getRequestDispatcher("helpresult.jsp").forward(request, response);
        } else {
            // Set an error message and forward to error.jsp
            request.setAttribute("error", "Invalid size selected!");
            request.getRequestDispatcher("helperror.jsp").forward(request, response);
        }
    }
	}


