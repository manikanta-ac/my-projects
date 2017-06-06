<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready(function() {
	$("#select").click(function () { alert(this.checked); });
    
	

});
</script>
</head>
<body>

	<h1>Restaurant Details</h1>
	<form:form name="addRestaurant" modelAttribute="Restaurant"
		action="addRestaurant" method="post">
		<table>
			<tr>
				<td><form:label path="restaurantName" />Restaurant Name</td>
				<td><form:input path="restaurantName" />
					<form:errors path="restaurantName"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="restaurnatAddress" />Restaurant Address</td>
				<td><form:textarea path="restaurnatAddress" /> <form:errors
						path="restaurnatAddress"></form:errors></td>
			</tr>
			<tr><td>Category</td>
  <td>
  <ul>
	<form:checkboxes element="li" items="${categories}" path="categories" id="select"/>
	</ul>
	    </td>
			<tr>
				<td><input type="Submit" value="Update" ></input></td>
				<td><input type="reset" value="Reset"></input></td>

			</tr>
		</table>

	</form:form>
</body>
</html>