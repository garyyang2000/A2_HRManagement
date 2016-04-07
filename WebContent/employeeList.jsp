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
 <div class="container">

      <!-- Static navbar -->
      <nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
          
            <a class="navbar-brand" href="#">HR Management</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Employee List</a></li>
              <li><a href="#">New Employee</a></li>
              <li><a href="#">Search Employee</a></li>
              
            </ul>
            <ul class="nav navbar-nav navbar-right">
             
              <li><a href="#">${emp.firstName} ${emp.lastName}</a></li>
              <li class="active"><a href="../navbar-fixed-top/"><span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
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

    </div> <!-- /container -->
</body>
</html>