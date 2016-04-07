<%@page contentType="text/html" pageEncoding="utf-8"%>
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
<div class="container">
		<!-- Static navbar -->
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">HR Management</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li ><a href="employeeList.jsp">Employee List</a></li>
						<li class="active"><a href="addEmployee.jsp">New Employee</a></li>
						<li><a href="#">Search Employee</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">${emp.firstName} ${emp.lastName}</a></li>
						<li class="active"><a href="../navbar-fixed-top/"><span
								class="glyphicon glyphicon-log-out"></span></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
	<div class="container body-content">
		<h2>Add New Employee</h2>
		<p>Here is the information that you retrieved from Oracle
			database:</p>
		<form action="AddEmployee" method="POST">
			<table>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="empid" class="control-label">Employee ID</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="number" class="form-control" id="empId" name="empId"
								required>*
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
							<input type="text" class="form-control" id="salary" name="salary">
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
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="deptId" class="control-label">Department ID</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="number" class="form-control" id="deptId"
								name="deptId">
						</div></td>
				</tr>

				<tr>
					<td class="col-md-2"></td>
					<td class="col-md-5"><div class="form-group">
							<div class="form-group">
								<button type="submit" class="btn btn-success col-sm-3">Save the new employee</button>
							</div>
							<div class="form-group">
								<button type="reset" class="btn btn-warning col-sm-3">Clear</button>
							</div>
						</div></td>
				</tr>
			</table>
		</form>
	</div>
	</div>
</body>
</html>