<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Search Result</title>
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
	         <th>Name</th>
	         <th>Department</th>
	         <th>Job ID</th>
	         <th>Salary</th>
	         <th>Email</th>
	         <th>Phone Number</th>	        	         
	      </tr>
	          <c:forEach var="employee" items="${employeeList}" >
           <tr>
             <td><c:out value="${employee.firstName}"/> <c:out value="${employee.lastName}"/></td>
             <td><c:out value="${employee.deptName}"/></td>
             <td><c:out value="${employee.jobId}"/></td>
             <td><c:out value="${employee.salary}"/></td>
             <c:choose>
            <c:when test="${fn:contains(employee.email, '@')}">
  				 <td><a href="mailto:<c:out value="${employee.email}"/>"><c:out value="${employee.email}"/></td>
			</c:when>
			<c:otherwise>
             <td><a href="mailto:<c:out value="${employee.email}"/>@myseneca.ca"><c:out value="${employee.email}"/>@myseneca.ca</td>
             </c:otherwise>
             </c:choose>
             <td><c:out value="${employee.phoneNumber}"/></td>
             
           </tr> 
	      </c:forEach>
	    </table>
	  </div>
	</div>    
	<hr/>
<div class="container text-center">
	<footer>
	   <p>&copy; Seneca College CJV805 </p>
	</footer></div>
</div>
</body>
</html>