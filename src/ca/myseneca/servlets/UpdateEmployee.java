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
 * Servlet implementation class UpdateEmployee This servlet class read all the
 * user information from EditEmployee.jsp. Then update the database and forward
 * to confirmation.jsp.
 * 
 * @author Ge Yang, Bohao Liu, Yan Liu
 * @version 2.0
 * @since 2016-04-10
 * 
 */
@WebServlet("/UpdateEmployee")
public class UpdateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateEmployee() {
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
			String btn = request.getParameter("btnEdit");

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
			String dept = request.getParameter("dept");
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
				String message = "";
				if (btn.equals("Update")) {
					if (DAManager.updateEmployee(emp) > 0) {
						request.setAttribute("emp", emp);
						message = "The following employee information has been updated to the database.";
						request.setAttribute("message", message);
						request.setAttribute("dept", dept);
						url = "/confirmation.jsp";
					} else {
						message = "Failed to update to the database, please check your input and try again.";
						request.setAttribute("message", message);
						url = "/errorPage.jsp";
					}
				} else {
					if (DAManager.deleteEmployeeByID(empId) > 0) {
						request.setAttribute("emp", emp);
						message = "The following employee information has been deleted from database.";
						request.setAttribute("message", message);
						request.setAttribute("dept", dept);
						url = "/confirmation.jsp";
					} else {
						message = "Failed to update to the database, please check your input and try again.";
						request.setAttribute("message", message);
						url = "/errorPage.jsp";
					}
				}
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
