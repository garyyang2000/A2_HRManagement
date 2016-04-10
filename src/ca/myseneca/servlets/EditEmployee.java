package ca.myseneca.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.myseneca.model.*;

/**
 * Servlet implementation class EditEmployee. It checks employee id forwarded by
 * showEmployeeList.jsp then get all the employee information and inject it to
 * EditEmployee.jsp.
 * 
 * @author Ge Yang, Bohao Liu, Yan Liu
 * @version 2.0
 * @since 2016-04-10
 */
@WebServlet("/EditEmployee")
public class EditEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditEmployee() {
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
		String url = "";
		HttpSession session = request.getSession();
		if (null == session.getAttribute("authUser")) {
			url = "/index.html";

		} else {
			String strEmpID = request.getParameter("id");
			String strDeptId = request.getParameter("dept");
			int empID = Integer.parseInt(strEmpID);
			Employee emp = DAManager.getEmployeeByID(empID);
			ArrayList<Department> depts = DAManager.getAllDepartments();
			if (emp != null) {
				request.setAttribute("emp", emp);
				request.setAttribute("departments", depts);
				request.setAttribute("dept", strDeptId);
				url = "/EditEmployee.jsp";
			} else {
				url = "/errorPage.jsp";
			}
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
