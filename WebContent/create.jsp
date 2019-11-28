<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> <!-- Verify 1 / not this one-->
<title>CRUD</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<h2>Create!</h2>
	<br>
	<form class="form-group" action="CreateServlet" method="POST">
		<label for="txtIdProduct">Id Product</label>
		<input class="form-control" type="text" id="txtIdProduct" name="txtIdProduct" disabled placeholder="Id Product Automatically Generated" > 
		<br>
		<label for="txtNameProduct">Product</label>
		<input class="form-control" type="text" id="txtNameProduct" name="txtNameProduct" placeholder="Name"requeried> 
		<br>
		<label for="txtPriceProduct">Price</label>
		<input class="form-control" type="text" id="PriceProduct" name="txtPriceProduct"  placeholder="$0.0"> 
		
		<br>
		<input class="btn btn-success" type="submit" value="Create Product">
	</form>


	<br>
	<a href="index.jsp"><input class="btn btn-info" type="button" id="GoBack" value="Go Back"></a>
<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="js/script.js"></script>
</body>
</html>