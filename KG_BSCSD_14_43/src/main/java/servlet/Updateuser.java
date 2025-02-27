package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.web_service;

/**
 * Servlet implementation class Updateuser
 */
@WebServlet("/Updateuser")
public class Updateuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Updateuser() {
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
		/*String registration_number;
String name;
String address;
int nic;
String username;
String password;*/
		
		String registration_numberr=request.getParameter("registration_number");
		String namee=request.getParameter("name");
		String addresss=request.getParameter("address");
		int nicc=Integer.parseInt(request.getParameter("nic"));
		String usernamee=request.getParameter("username");
		String passwordd=request.getParameter("password");
		
		 web_service userModell = new  web_service();
	        boolean isUpdated = userModell.updateuser(registration_numberr,namee,addresss,nicc,usernamee,passwordd);

	        if (isUpdated) {
	            request.setAttribute("message", "User updated successfully!");
	        } else {
	            request.setAttribute("message", "Error updating user!");
	        }

	        request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	}


