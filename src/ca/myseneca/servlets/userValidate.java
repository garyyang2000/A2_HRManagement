package ca.myseneca.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ca.myseneca.datasource.*;
import ca.myseneca.model.*;
/**
 * Servlet implementation class userValidate
 */
@WebServlet(description = "validate user's credential", urlPatterns = { "/userValidate" })
public class userValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ConnectionPool pool = ConnectionPool.getInstance(); // Oracl on Zenit
	//Connection conn = null;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = -1;
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		result = DAManager.getEmployeeID(userName, passWord);
		
		request.setAttribute("employeeID", result);

		this.getServletContext().getRequestDispatcher("/EmployeeList.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
