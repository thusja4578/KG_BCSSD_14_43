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


@WebServlet("/logcus")
public class logcus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public logcus() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		register user_log=new register();
		user_log.setUsername(request.getParameter("username"));
		user_log.setPassword(request.getParameter("password"));
		web_service serve=new web_service();
		boolean status=serve.validate(user_log);
		
		
		if(status) { //condition eken ena answer eka true hari false nisa mehema danna puluwan
			register loggedcus= serve.getone(user_log);
			request.setAttribute("customer", loggedcus);
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		doGet(request, response);
	}
	}


