<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="ca.myseneca.model.*"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Add New Employee</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<c:if test="${empty authUser}">
		<c:redirect url="/index.html" />
	</c:if>
	<div class="container">
		<jsp:include page="header.jsp">
			<jsp:param name="pageIndex" value="2" />
		</jsp:include>
		<div class="container body-content">
			<h2>Add New Employee</h2>
			<p>Please input new employee information:</p>
			<hr />
			
			<form action="AddEmployee" method="POST">
				<table>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="empid" class="control-label">Employee ID*</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="number" class="form-control" id="empId"
									name="empId" required>
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="firstName" class="control-label">First Name</label>
							</div></td>
						<td class="col-md-5">
							<div class="form-group">
								<input type="text" class="form-control" id="firstName"
									name="firstName">
							</div>
						</td>
					</tr>
					<tr>
						<td class="col-md-2">
							<div class="form-group">
								<label for="lastName" class="control-label">Last Name</label>
							</div>
						</td>
						<td class="col-md-5">
							<div class="form-group">
								<input type="text" class="form-control" id="lastName"
									name="lastName">
							</div>
						</td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="email" class="control-label">Email</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="text" class="form-control" id="email" name="email">
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="phoneNumber" class="control-label">Phone
									Number</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="text" class="form-control" id="phoneNum"
									name="phoneNum">
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="hireDate" class="control-label">Hire Date</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="text" class="form-control" id="hireDate"
									name="hireDate" placeholder="yyyy-mm-dd">
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="jobId" class="control-label">Job ID</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="text" class="form-control" id="jobId" name="jobId">
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="salary" class="control-label">Salary</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="text" class="form-control" id="salary"
									name="salary">
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="commPct" class="control-label">Comm Pct</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="text" class="form-control" id="commPct"
									name="commPct">
							</div></td>
					</tr>
					<tr>
						<td class="col-md-2"><div class="form-group">
								<label for="mgrId" class="control-label">Manager ID</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<input type="number" class="form-control" id="managerId"
									name="managerId">
								<div></td>
					</tr>
					<tr><%!%>
						<td class="col-md-2"><div class="form-group">
								<label for="deptId" class="control-label">Department</label>
							</div></td>
						<td class="col-md-5"><div class="form-group">
								<select class="form-control" name="deptId">

									<%
										ArrayList<Department> departmentList = (ArrayList<Department>) DAManager.getAllDepartments();
										if (departmentList != null) {
											for (Department dpt : departmentList) {
									%>
									<option value="<%=dpt.getDeptId()%>"><%=dpt.getDeptName()%></option>

									<%
										}
										}
									%>
								</select>

							</div></td>
					</tr>


					<tr>
						<td class="col-md-2"></td>
						<td class="col-md-5"><div class="form-group pull-right">
								<div class="form-group">
									<button type="submit" class="btn btn-success">Save</button>

									<button type="reset" class="btn btn-warning">Clear</button>
								</div>
							</div></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<hr />
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
</body>
</html>