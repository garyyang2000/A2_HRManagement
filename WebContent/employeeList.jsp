<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee List</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script type="text/javascript">
	function validateDeptID() {
		var text = document.getElementById('DeptID');
		if (text.value.length == 0) {
			//handle validation response here
			alert("Sorry, you must provid department id before show employees for this department.");
			return false;
		} else {
			//submit form, or whatever the button is supposed to do...
			return true;
		}
	}
</script>
</head>
<body>
	<c:if test="${empty authUser}">
		<c:redirect url="/index.html" />
	</c:if>
	<div class="container">
		<!-- Static navbar -->
		<jsp:include page="header.jsp">
			<jsp:param name="pageIndex" value="1" />
		</jsp:include>
		<div class="container  body-content">
			<h2>Employee List Page</h2>
			<h5>
				Show employees in a department by typing in the department id and
				click on the button next, or click on the <i>Show All Employee</i>
				for all employees in the company.
			</h5>
			<hr>
			<form role="form" action="GetEmployeeList" method="POST">
				<div class="form-group">
					<label for="Department ID" class="col-sm-2 control-label">Department
						ID</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="DeptID"
							placeholder="Department ID" name="DeptID">
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-6">
						<button type="submit" class="btn btn-default" name="btnEmps"
							onclick="return validateDeptID()" value="DeptEmps">Show Department
							Employees</button>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default" name="btnEmps"
							value="AllEmps">Show All Employees</button>
					</div>
				</div>
			</form>


		</div>
		<hr>
		<div class="container text-center">
			<footer>
				<p>
					&copy;
					<script>
						document.write(new Date().getFullYear())
					</script>
					Seneca College CJV805
				</p>
			</footer>
		</div>
	</div>
	<!-- /container -->
</body>
</html>