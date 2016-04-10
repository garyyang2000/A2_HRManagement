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
import javax.servlet.http.HttpSession;

import ca.myseneca.datasource.*;
import ca.myseneca.model.*;

/**
 * Servlet implementation class userValidate This servlet class is the start of
 * all the function servlets. It checks user's identification and save the
 * validation information in the session. All the following servlet and jsp page
 * will check the session to judge if a user can perform the action.
 * 
 * @author Ge Yang, Bohao Liu, Yan Liu
 * @version 2.0
 * @since 2016-04-10
 * 
 */
@WebServlet(description = "validate user's credential", urlPatterns = "/userValidate")
public class userValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public userValidate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int result = -1;
		String url = "";
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		result = DAManager.getEmployeeID(userName, passWord);
		if (result > 0) {
			HttpSession session = request.getSession();

			// setting session to expire in 30 minutes
			session.setMaxInactiveInterval(30 * 60);
			Employee emp = DAManager.getEmployeeByID(result);
			session.setAttribute("authUser", emp);

			url = "/employeeList.jsp";
		} else {
			url = "/index.html";
		}
		this.getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
