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
 
<h1>Admin Registration</h1>
<hr>
	<form:form name="adminLogin" modelAttribute="admin" action="adminRegistration" method="post">
		<table bgcolor="AliceBlue" cellpadding="5" cellspacing="5">
	<tr>	
  <p style="color:red"> <c:out value="${msg}"></c:out></p>
   </tr>
			<tr>
				<td><form:label path="adminName"/>Admin Name</td>
				<td><form:input path="adminName"/><form:errors path="adminName" cssStyle="color:red"></form:errors>  </td>
			</tr>
			<tr>
				<td><form:label path="adminEmail"/>Email Id</td>
				<td><form:input path="adminEmail"/><form:errors path="adminEmail" cssStyle="color:red"></form:errors>  </td>
			</tr>
			
			<tr>
				<td> <input type="Submit" value="Register"></input></td>
				<td> <input type="reset" value="Reset"></input></td>
				
			</tr>
		</table>

	</form:form>
</body>
</html>