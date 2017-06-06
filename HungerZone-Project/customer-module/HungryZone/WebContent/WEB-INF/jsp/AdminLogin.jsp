<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>
 
<h1>Admin Login</h1>
<hr>
	<form:form name="adminLogin" modelAttribute="admin" action="adminLogin" method="post">
		<table bgcolor="AliceBlue" cellpadding="5" cellspacing="5">
	<tr>	
  <p style="color:red"> <c:out value="${msg}"></c:out></p>
   </tr>
			<tr>
				<td><form:label path="adminId"/>Admin Id</td>
				<td><form:input path="adminId"/><form:errors path="adminId" cssStyle="color:red"></form:errors>  </td>
			</tr>
			<tr>
				<td><form:label path="adminPassword"/>Admin Password</td>
				<td><form:password path="adminPassword"/>
			<form:errors path="adminPassword" cssStyle="color:red"></form:errors></td>
			</tr>
			
			<tr>
				<td> <input type="Submit" value="Login"></input></td>
				<td> <input type="reset" value="Reset"></input></td>
				
			</tr>
		</table>

	</form:form>
</body>
</html>