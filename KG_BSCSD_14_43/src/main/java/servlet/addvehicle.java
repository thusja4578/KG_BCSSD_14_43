package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import service.web_service;

/**
 * Servlet implementation class addvehicle
 */
@WebServlet("/addvehicle")
public class addvehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addvehicle() {
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
		Vehicle app1=new Vehicle();
		app1.setVehicleid(request.getParameter("vehicleid"));
		app1.setModel(request.getParameter("model"));
		app1.setLicenseplate(request.getParameter("licenseplate"));
		app1.setBrand(request.getParameter("brand"));
		app1.setColor(request.getParameter("color"));
		app1.setEngine(request.getParameter("engine"));
		app1.setChasi(request.getParameter("chasi"));
		app1.setName(request.getParameter("name"));
		app1.setEmail(request.getParameter("email"));
		app1.setPhone(request.getParameter("phone"));
		app1.setIdnum(request.getParameter("idnum"));
		app1.setProvider(request.getParameter("provider"));
		app1.setPolicy(request.getParameter("policy"));
		app1.setExpire(request.getParameter("expire"));
		web_service app2=new web_service();
		app2.add_vehicle(app1);
		RequestDispatcher dis=request.getRequestDispatcher("home.jsp");
		dis.forward(request, response);
		
		
		
		
	}

}
