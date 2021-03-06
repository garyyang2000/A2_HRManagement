package ca.myseneca.servlets;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.myseneca.model.*;

/**
 * Servlet implementation class AddEmployee It reads in the input information
 * posted from addEmployee.jsp page and forward information to confirmation.jsp
 * if everything is good.
 * 
 * @author  Ge Yang, Bohao Liu, Yan Liu
 * @version 2.0
 * @since   2016-04-10 
 */
@WebServlet("/AddEmployee")
public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddEmployee() {
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

			String message = "";
			String strEmpId = request.getParameter("empId");

			String fName = request.getParameter("firstName");
			String lName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phoneNum = request.getParameter("phoneNum");
			String hireDate = request.getParameter("hireDate");
			String jobId = request.getParameter("jobId");
			String strSalary = request.getParameter("salary");
			String commPct = request.getParameter("commPct");
			String managerId = request.getParameter("managerId");
			String deptId = request.getParameter("deptId");
			Employee emp = new Employee();
			try {
				int empId = Integer.parseInt(strEmpId);
				if ((strSalary != null) && (!strSalary.isEmpty())) {
					BigDecimal salary = new BigDecimal(strSalary);
					emp.setSalary(salary);
				}
				if ((commPct != null) && (!commPct.isEmpty())) {
					BigDecimal commissionPct = new BigDecimal(commPct);
					emp.setCommissionPct(commissionPct);
				}
				if ((managerId != null) && (!managerId.isEmpty())) {
					int mgrId = Integer.parseInt(managerId);
					emp.setManagerId(mgrId);
				}
				int departmentId = Integer.parseInt(deptId);
				emp.setEmployeeId(empId);
				emp.setFirstName(fName);
				emp.setLastName(lName);
				emp.setEmail(email);
				emp.setPhoneNumber(phoneNum);
				emp.setJob(jobId);

				emp.setDepartmentId(departmentId);
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				java.util.Date date = sdf1.parse(hireDate);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
				emp.setHireDate(sqlStartDate);
				DAManager.addEmployee(emp);
				request.setAttribute("emp", emp);
				message = "The following employee information has been added to the database.";
				request.setAttribute("message", message);
				url = "/confirmation.jsp";
			} catch (Exception ex) {
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
