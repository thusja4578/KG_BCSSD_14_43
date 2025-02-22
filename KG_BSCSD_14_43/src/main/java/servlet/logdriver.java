package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Driver;

import service.web_service;

/**
 * Servlet implementation class logdriver
 */
@WebServlet("/logdriver")
public class logdriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logdriver() {
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
		Driver user_log=new Driver();
		user_log.setIdnum(request.getParameter("idnum"));
		user_log.setLicen(request.getParameter("licen"));
		web_service serve=new web_service();
		boolean status=serve.validatedriver(user_log);
		
		
		if(status) { //condition eken ena answer eka true hari false nisa mehema danna puluwan
			Driver loggedcus= serve.getonedriver(user_log);
			request.setAttribute("customer", loggedcus);
			RequestDispatcher dispatcher = request.getRequestDispatcher("driverprofile.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}
	}


