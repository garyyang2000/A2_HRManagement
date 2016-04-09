<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<c:if test="${empty authUser}">
		<c:redirect url="/index.html" />
	</c:if>
	<div class="container">
		<jsp:include page="header.jsp">
			<jsp:param name="pageIndex" value="3" />
		</jsp:include>
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
				<p>&copy; Seneca College <script>document.write(new Date().getFullYear())</script> CJV805</p>
			</footer>
		</div>
	</div>
	<!-- /container -->
</body>
</html>