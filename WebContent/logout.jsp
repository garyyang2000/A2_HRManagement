<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Logout</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
		<%
            session.removeAttribute("authUser");
        %>
	<div class="container">

		<h2>HR Management</h2>

		<form class="form-horizontal">
			<h4>You are now logged out.</h4>
			<p>You can <a href="index.html">return to login page</a>.</p>
		</form>	
		<hr/>
		<div class="container text-center">
			<footer>
				<p>&copy; Seneca College <script>document.write(new Date().getFullYear())</script> CJV805 </p>
			</footer>
		</div>
	</div>

</body>
</html>