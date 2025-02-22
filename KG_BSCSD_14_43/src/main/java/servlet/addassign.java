package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Assignment;
import service.web_service;

/**
 * Servlet implementation class addassign
 */
@WebServlet("/addassign")
public class addassign extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addassign() {
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
		Assignment app1=new Assignment ();
		app1.setDriverId(request.getParameter("did"));
		app1.setVehicleId(request.getParameter("vid"));
		web_service app2=new web_service();
		app2.reg_as(app1);
RequestDispatcher dispatcher=request.getRequestDispatcher("home.jsp");
		
		dispatcher.forward(request, response);
	}

}
