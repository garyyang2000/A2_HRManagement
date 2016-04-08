<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Employee List</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
   <script src="bootstrap/js/bootstrap.min.js" type="text/javascript" ></script>
</head>
<body>
<div class="container body-content">

   <h2>Employees List View</h2>
   <p>Here is the information that you retrieved from Oracle database:</p>
   <div class="row">
     <div class="col-md-6">
	    <table class="table table-striped">
	      <tr>
	         <th>Employee ID</th>
	         <th>First Name</th>
	         <th>Last Name</th>
	         <th>Email</th>
	         <th>Phone Number</th>
	         <th>Hire Date</th>
	         <th>Job ID</th>
	         <th>Salary</th>
	         <th>Commission Pct</th>
	         <th>Manager ID</th>
	         <th>Department ID</th>
	      </tr>
	
         <c:forEach var="employee" items="${employeeList}" >
           <tr>
             <td><a href="EditEmployee?id=<c:out value="${employee.employeeId}"/>"><c:out value="${employee.employeeId}"/></td>
             <td><c:out value="${employee.firstName}"/></td>
             <td><c:out value="${employee.lastName}"/></td>
             <td><c:out value="${employee.email}"/></td>
             <td><c:out value="${employee.phoneNumber}"/></td>
             <td><c:out value="${employee.hireDate}"/></td>
             <td><c:out value="${employee.jobId}"/></td>
             <td><c:out value="${employee.salary}"/></td>
             <td><c:out value="${employee.commissionPct}"/></td>
             <td><c:out value="${employee.managerId}"/></td>
             <td><c:out value="${employee.departmentId}"/></td>
           </tr> 
	      </c:forEach>
	    </table>
	  </div>
	</div>    
	
   <p>To return the login page, click on the Back button in your
   browser or the Return button shown below.</p>
   
   <form action="index.html" >
      <input type="submit" value="Return">
   </form>
	
	<hr />
	<footer>
	   <p>&copy; Seneca College CJV805 </p>
	</footer>
</div>
</body>
</html>