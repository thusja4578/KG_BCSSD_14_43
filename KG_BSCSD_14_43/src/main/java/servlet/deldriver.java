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
 * Servlet implementation class deldriver
 */
@WebServlet("/deldriver")
public class deldriver extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deldriver() {
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
		Driver del = new Driver();
		del.setIdnum(request.getParameter("idnum"));

		web_service del_ser = new web_service();
		boolean success = del_ser.del_driver(del); // Assuming this method returns a boolean indicating success or failure

		if (success) {
		    response.getWriter().println("<script>alert('Driver deleted successfully!'); window.location='drivertb';</script>");
		} else {
		    response.getWriter().println("<script>alert('Driver deletion failed. Please try again!'); window.location='drivertb';</script>");
		}

	}

}
