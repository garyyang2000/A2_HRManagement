<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Search Employee</title>
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
						<li><a href="employeeList.jsp">Employee List</a></li>
						<li><a href="addEmployee.jsp">New Employee</a></li>
						<li class="active"><a href="#">Search Employee</a></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#">${emp.firstName} ${emp.lastName}</a></li>
						<li class="active"><a href="index.html"><span
								class="glyphicon glyphicon-log-out"></span></a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
			<!--/.container-fluid -->
		</nav>
		<div class="container  body-content">

			<h2>Search For Employee</h2>
			<h5>Search for an employee by typing in any part of name, email
				address, phone number or department.</h5>
			<hr>
			<form role="form" action="SearchEmployees" method="POST"
				class="form-inline">
				<div class="form-group">

					<input type="text" class="form-control" id="keyWord" name="keyWord"
						placeholder="Search here...">
				</div>

				<button type="submit" class="btn btn-default">Search</button>
			</form>
			<hr>

		</div>
		<div class="container text-center">
			<footer>
				<p>&copy; Seneca College CJV805</p>
			</footer>
		</div>
	</div>
	<!-- /container -->
</body>
</html>