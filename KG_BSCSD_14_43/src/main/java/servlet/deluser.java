package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Driver;
import model.register;
import service.web_service;

/**
 * Servlet implementation class deluser
 */
@WebServlet("/deluser")
public class deluser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deluser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		register dell = new register();
		dell.setRegistration_number(request.getParameter("registration_number"));

		web_service del_ser = new web_service();
		boolean success = del_ser.del_user(dell); // Assuming this method returns a boolean indicating success or failure

		if (success) {
		    response.getWriter().println("<script>alert('User deleted successfully!'); window.location='usertb';</script>");
		} else {
		    response.getWriter().println("<script>alert('User deletion failed. Please try again!'); window.location='usertb';</script>");
		}

	}

}
