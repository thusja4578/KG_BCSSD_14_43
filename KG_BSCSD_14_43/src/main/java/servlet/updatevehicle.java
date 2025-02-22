package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vehicle;
import service.web_service;

/**
 * Servlet implementation class updatevehicle
 */
@WebServlet("/updatevehicle")
public class updatevehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatevehicle() {
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
		String vehicleidd=request.getParameter("vehicleid");
		String modell=request.getParameter("model");
		String license_platee=request.getParameter("licenseplate");
		String brandd=request.getParameter("brand");
		String colorr=request.getParameter("color");
		String enginee=request.getParameter("engine");
		String chasii=request.getParameter("chasi");
		String namee=request.getParameter("name");
		String emaill=request.getParameter("email");
		String phonee=request.getParameter("phone");
		String idnumm=request.getParameter("idnum");
		String provider=request.getParameter("provider");
		String policyy=request.getParameter("policy");
		String expire=request.getParameter("expire");
		 web_service userModell = new  web_service();
	        boolean isUpdated = userModell.updatevehicle(vehicleidd,modell,license_platee,brandd,colorr,enginee,chasii,namee,emaill,phonee,idnumm,provider,policyy,expire);

	        if (isUpdated) {
	            request.setAttribute("message", "User updated successfully!");
	        } else {
	            request.setAttribute("message", "Error updating user!");
	        }

	        request.getRequestDispatcher("home.jsp").forward(request, response);
	}
		
	}


