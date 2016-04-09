<%@ page import="java.util.*"%>
<%@ page errorPage="/errorPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

<title>Confirmation</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>

	<div class="container body-content">
	
	<h2>Confirmation</h2>
   <p>${message}</p>
  
   <form action="employeeList.jsp" method="POST">
   <table >
   <tr ><td class="col-md-2"><div class="form-group">
    <label for="empid" class="control-label">Employee ID</label></div></td>
    <td class="col-md-5"><div class="form-group">
     ${emp.employeeId}</div>
    
  </td></tr>
  <tr><td class="col-md-2"><div class="form-group">
    <label for="firstName" class="control-label">First Name</label></div></td><td class="col-md-5">
    <div class="form-group">
     ${emp.firstName}
   </div>
  </td></tr>
 <tr><td class="col-md-2"> <div class="form-group">
    <label for="lastName" class="control-label">Last Name</label></div></td><td class="col-md-5">
   <div class="form-group">
      ${emp.lastName}
    </div>
  </td></tr>
  <tr><td class="col-md-2"><div class="form-group">
    <label for="email" class="control-label">Email</label></div>
    </td><td class="col-md-5"><div class="form-group">
      ${emp.email}
    </div>
  </td></tr>
  <tr><td class="col-md-2"><div class="form-group">
    <label for="phoneNumber" class="control-label">Phone Number</label></div>
    </td><td class="col-md-5"><div class="form-group">
      ${emp.phoneNumber}
   </div>
  </td></tr>
  <tr><td class="col-md-2"><div class="form-group">
    <label for="hireDate" class="control-label">Hire Date</label></div>
    </td><td class="col-md-5"><div class="form-group">
      ${emp.hireDate}</div>
   </td></tr>
  <tr><td class="col-md-2"><div class="form-group">
    <label for="jobId" class="control-label">Job ID</label></div>
   </td><td class="col-md-5"><div class="form-group">
      ${emp.jobId}</div>
    </td></tr>
  <tr><td class="col-md-2"><div class="form-group">
    <label for="salary" class="control-label">Salary</label></div>
    </td><td class="col-md-5"><div class="form-group">
     ${emp.salary}</div>
    </td></tr>
   <tr><td class="col-md-2"><div class="form-group">
    <label for="commPct" class="control-label">Comm Pct</label></div>
    </td><td class="col-md-5"><div class="form-group">
      ${emp.commissionPct}</div>
    </td></tr>
   <tr><td class="col-md-2"><div class="form-group">
    <label for="mgrId" class="control-label">Manager ID</label></div>
    </td><td class="col-md-5"><div class="form-group">
      ${emp.managerId}</div>
    
  </td></tr>
   <tr><td class="col-md-2"><div class="form-group">
    <label for="deptId" class="control-label">Department ID</label></div>
   </td><td class="col-md-5"><div class="form-group">
      ${emp.departmentId}
   </div>
  </td></tr>
  
   <tr><td class="col-md-2">
    
   </td><td class="col-md-5"><div class="form-group">
   <input type="button" value="Return" onclick="javascript:history.go(-2)" class="btn btn-success col-sm-3">
   <%--    <a href="/GetEmployeeList" class="btn btn-success col-sm-3">Return</a> --%>
	   
   </div>
  </td></tr>
  </table>
   </form>   
	   <div class="container text-center">
<footer>
      <p>&copy; Seneca College <script>document.write(new Date().getFullYear())</script> CJV805 </p>
  </footer>
  </div>
</div>
</body>
</html>