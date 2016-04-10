package ca.myseneca.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import ca.myseneca.model.*;

/**
 * Servlet implementation class GetEmployeeList
 */
@WebServlet(description = "Get all employee or employee from certain department", urlPatterns = { "/GetEmployeeList" })
public class GetEmployeeList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetEmployeeList() {
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
			String btn = request.getParameter("btnEmps");
			String message = "";
			if (btn == null) {
				// no button has been selected
				url = "/errorPage.jsp";
			} else if (btn.equals("AllEmps")) {
				// All employees button was pressed
				ArrayList<Employee> employees = new ArrayList<Employee>();
				employees = DAManager.getAllEmployees();
				request.setAttribute("employeeList", employees);
				message = "employee information of all employees";
				request.setAttribute("message", message);
				request.setAttribute("dept", 0);
				url = "/showEmployeeList.jsp";
			} else if (btn.equals("DeptEmps")) {
				// update button was pressed
				String deptID = request.getParameter("DeptID");
				int deptId = Integer.parseInt(deptID);
				ArrayList<Employee> employees = new ArrayList<Employee>();
				employees = DAManager.getEmployeesByDepartmentID(deptId);
				String deptName = "";
				if (employees.size() > 0) {
					deptName = employees.get(0).getDeptName();
				}
				request.setAttribute("employeeList", employees);
				message = "employee information of " + deptName + " department";
				request.setAttribute("message", message);
				request.setAttribute("dept", deptId);
				url = "/showEmployeeList.jsp";

			} else {
				// someone has altered the HTML and sent a different value!
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
