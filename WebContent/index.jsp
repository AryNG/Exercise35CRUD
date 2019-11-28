<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CRUD with Statements</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"> 
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<h2>Virtual Store</h2>
    <div class="list-group">
        <ul>
            <li class="list-group-item list-group-item-action"><a href="create.jsp">Create</a></li>
            <li class="list-group-item list-group-item-action dropdown">
                <a class="dropdown dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">Read<samp class="caret"></samp></a>
                <ul class="dropdown-menu" role="menu">
                	<a class="dropdown-item" href="readGeneral.jsp">General</a>
                    <a class="dropdown-item" href="readIndividual.jsp">Individual</a>
                </ul>
            </li>
            <li class="list-group-item list-group-item-action"><a href="update.jsp">Update</a></li>
            <li class="list-group-item list-group-item-action"><a href="delete.jsp">Delete</a></li>
        </ul>
    </div>
	<!-- Scripts -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="js/script.js"></script>
</body>
</html>