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
 * Servlet implementation class delvehicle
 */
@WebServlet("/delvehicle")
public class delvehicle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delvehicle() {
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
Vehicle dell=new Vehicle();
		
		
		
		dell.setIdnum(request.getParameter("idnum"));
		web_service dell_ser=new web_service();
		dell_ser.del_vehicle(dell);
		RequestDispatcher dis=request.getRequestDispatcher("vehicletb");
		dis.forward(request, response);
	}
	}


