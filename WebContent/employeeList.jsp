<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Employee List</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="bootstrap/js/bootstrap.min.js" type="text/javascript" ></script>
</head>
<body>

<header>
<div >
	<p>username
        <a href="#">
          <span class="glyphicon glyphicon-log-out"></span>
        </a>
    </p>
</div>
</header>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Employee List</a></li>
      <li><a href="#">New Employee</a></li>
      <li><a href="#">Search Employee</a></li>
      
    </ul>
  </div>
</nav>

<div class="container  body-content">

  <h2>Employee List Page</h2>
  <h5>Show employees in a department by typing in the department id and click on the button next, or click on the <i>Show All Employee</i> for all employees in the company.</h5>
  <hr>
  
  <form role="form" action="ReadCountries">
	  <button type="submit" class="btn btn-default">
	    Retrieve Countries from Oracle DB
     </button>
  </form>

  <form role="form" action="RetrieveCoffees">
     <button type="submit" class="btn btn-default">
       Retrieve Coffees from MySQL DB
     </button>
  </form>

  <hr>
  <footer>
      <p>&copy; Seneca College CJV805 </p>
  </footer>
</div>
</body>
</html>