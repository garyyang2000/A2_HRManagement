<%@ page import="java.util.*"%>
<%@ page errorPage="/errorPage.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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


		<table>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="empid" class="control-label">Employee ID</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.employeeId}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="firstName" class="control-label">First Name</label>
					</div></td>
				<td class="col-md-5">
					<div class="form-group">${emp.firstName}</div>
				</td>
			</tr>
			<tr>
				<td class="col-md-2">
					<div class="form-group">
						<label for="lastName" class="control-label">Last Name</label>
					</div>
				</td>
				<td class="col-md-5">
					<div class="form-group">${emp.lastName}</div>
				</td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="email" class="control-label">Email</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.email}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="phoneNumber" class="control-label">Phone
							Number</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.phoneNumber}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="hireDate" class="control-label">Hire Date</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.hireDate}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="jobId" class="control-label">Job ID</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.jobId}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="salary" class="control-label">Salary</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.salary}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="commPct" class="control-label">Comm Pct</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.commissionPct}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="mgrId" class="control-label">Manager ID</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.managerId}</div></td>
			</tr>
			<tr>
				<td class="col-md-2"><div class="form-group">
						<label for="deptId" class="control-label">Department ID</label>
					</div></td>
				<td class="col-md-5"><div class="form-group">
						${emp.departmentId}</div></td>
			</tr>

			<tr>
				<td class="col-md-2"></td>
				<td class="col-md-5"><div class="form-group">
						<c:choose>
							<c:when test="${not empty dept}">
								<form action="GetEmployeeList" method="POST">

									<c:if test="${dept eq 0}">
										<button type="submit" class="btn btn-default" name="btnEmps"
							value="AllEmps">Return to employee list</button>
									</c:if>

									<c:if test="${dept != 0}">
										<c:set var="btnEmps" value="DeptEmps" scope="request" />
									
										<input type="hidden" name="DeptID" value="${dept}">
										<button type="submit" class="btn btn-default" name="btnEmps"
							value="DeptEmps">Return to employee list</button>
									</c:if>
									
							</c:when>
							<c:otherwise>
								<form action="addEmployee.jsp" method="POST">
									<button type="submit" class="btn btn-default">Return
										to add employee page</button>
							</c:otherwise>
						</c:choose>
						</form>
					</div></td>
			</tr>
		</table>

		<div class="container text-center">
			<footer>
				<p>
					&copy; Seneca College
					<script>
						document.write(new Date().getFullYear())
					</script>
					CJV805
				</p>
			</footer>
		</div>
	</div>
</body>
</html>