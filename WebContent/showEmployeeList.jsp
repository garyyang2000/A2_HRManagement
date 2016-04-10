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
	<c:if test="${empty authUser}">
		<c:redirect url="/index.html" />
	</c:if>
   <h2>Employees List View</h2>
   <p>Here is ${message} :</p>
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
             <td><a href="EditEmployee?id=<c:out value="${employee.employeeId}"/>&dept=${dept}"><c:out value="${employee.employeeId}"/></a></td>
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
	
   <p>To return the <i>Employee List</i> page, click on the Back button in your
   browser or the <i>Return</i> button shown below.</p>
   
   <form action="employeeList.jsp" >
      <input type="submit" value="Return" class="btn btn-default">
   </form>
	
	<hr />
	<div class="container text-center">
	<footer>
	   <p>&copy; Seneca College <script>document.write(new Date().getFullYear())</script> CJV805 </p>
	</footer></div>
</div>
</body>
</html>