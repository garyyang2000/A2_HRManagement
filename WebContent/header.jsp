<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
   
   <nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">HR Management</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li <c:if test="${param.pageIndex eq 1}"> class="active" </c:if>>
						<a href="employeeList.jsp">Employee List</a></li>
						<li <c:if test="${param.pageIndex eq 2}"> class="active" </c:if>>
						<a href="addEmployee.jsp">New Employee</a></li>
						<li <c:if test="${param.pageIndex eq 3}"> class="active" </c:if>>
						<a href="searchEmployee.jsp">Search Employee</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<c:if test="${not empty authUser}">
							<li ><a href="#">${authUser.firstName} ${authUser.lastName}</a></li>
						</c:if>
						
						<li class="active"><a href="logout.jsp"><span
								class="glyphicon glyphicon-log-out"></span></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>