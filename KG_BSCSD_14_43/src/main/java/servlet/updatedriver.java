package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.web_service;

/**
 * Servlet implementation class updatedriver
 */
@WebServlet("/updatedriver")
public class updatedriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatedriver() {
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
		/*String	driverid;
String name;
String address;
int contact;
String dob;
String idnum;
String licen;*/
		
		String driveridd=request.getParameter("driverid");
		String namee=request.getParameter("name");
		String addresss=request.getParameter("address");
		int contactt=Integer.parseInt(request.getParameter("contact"));
		String dobb=request.getParameter("contact");
		String idnumm=request.getParameter("idnum");
		String licenn=request.getParameter("licen");
		
		 web_service userModell = new  web_service();
	        boolean isUpdated = userModell.updatedriver(driveridd,namee,addresss,contactt,dobb,idnumm,licenn);

	        if (isUpdated) {
	            request.setAttribute("message", "User updated successfully!");
	        } else {
	            request.setAttribute("message", "Error updating user!");
	        }

	        request.getRequestDispatcher("home.jsp").forward(request, response);
	}

}
