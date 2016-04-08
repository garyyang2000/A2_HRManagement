package ca.myseneca.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ca.myseneca.model.*;
/**
 * Servlet implementation class SearchEmployees
 */
@WebServlet("/SearchEmployees")
public class SearchEmployees extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployees() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String keyWord=request.getParameter("keyWord");
		String url="";
		if (keyWord!=null && (!keyWord.isEmpty())){
			ArrayList<Employee> employees= new ArrayList<Employee>();
			employees=DAManager.searchEmployee(keyWord);
			request.setAttribute("employeeList", employees);
			
			url="/searchResult.jsp";
		}else{
			url="/searchEmployee.jsp";
		}
		this.getServletContext().getRequestDispatcher(url)
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
