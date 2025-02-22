package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Driver;
import model.Vehicle;
import service.web_service;

/**
 * Servlet implementation class logvehicle
 */
@WebServlet("/logvehicle")
public class logvehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logvehicle() {
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
		Vehicle user_log=new Vehicle();
		user_log.setModel(request.getParameter("model"));
		user_log.setLicenseplate(request.getParameter("license_palte"));
		web_service serve=new web_service();
		boolean status=serve.validatevehicle(user_log);
		
		
		if(status) { //condition eken ena answer eka true hari false nisa mehema danna puluwan
			Vehicle loggedcus= serve.getonevehicle(user_log);
			request.setAttribute("customer", loggedcus);
			RequestDispatcher dispatcher = request.getRequestDispatcher("vehicleprofile.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}
	}


