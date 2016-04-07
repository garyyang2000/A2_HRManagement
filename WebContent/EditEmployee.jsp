<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Edit Employee</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<div class="container body-content">
		<h2>Edit Employee</h2>
		<p>Here is the information that you retrieved from Oracle
			database:</p>
		<form action="UpdateEmployee" method="POST">
			<table>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="empid" class="control-label">Employee ID</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="number" class="form-control" id="empId" name="empId"
								value=${emp.employeeId} required disabled>*
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="firstName" class="control-label">First Name</label>
						</div></td>
					<td class="col-md-5">
						<div class="form-group">
							<input type="text" class="form-control" id="firstName"
								name="firstName" value=${emp.firstName}>
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
								name="lastName" value=${emp.lastName}>
						</div>
					</td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="email" class="control-label">Email</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="text" class="form-control" id="email" name="email"
								value=${emp.email}>
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="phoneNumber" class="control-label">Phone
								Number</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="text" class="form-control" id="phoneNum"
								name="phoneNum" value=${emp.phoneNumber}>
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="hireDate" class="control-label">Hire Date</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="text" class="form-control" id="hireDate"
								name="hireDate" value=${emp.hireDate}>
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="jobId" class="control-label">Job ID</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="text" class="form-control" id="jobId" name="jobId"
								value=${emp.jobId}>
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="salary" class="control-label">Salary</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="text" class="form-control" id="salary" name="salary"
								value=${emp.salary}>
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="commPct" class="control-label">Comm Pct</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="text" class="form-control" id="commPct"
								name="commPct" value=${emp.commissionPct}>
						</div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="mgrId" class="control-label">Manager ID</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="number" class="form-control" id="managerId"
								name="managerId" value=${emp.managerId}>
							<div></td>
				</tr>
				<tr>
					<td class="col-md-2"><div class="form-group">
							<label for="deptId" class="control-label">Department ID</label>
						</div></td>
					<td class="col-md-5"><div class="form-group">
							<input type="number" class="form-control" id="deptId" name="deptId"
								value=${emp.departmentId}>
						</div></td>
				</tr>

				<tr>
					<td class="col-md-2"></td>
					<td class="col-md-5"><div class="form-group">
							<div class="form-group">
								<button type="submit" class="btn btn-success col-sm-3">Update</button>
							</div>
							<div class="form-group">
								<button type="cancel" class="btn btn-warning col-sm-3">Delete</button>
							</div>
						</div></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>