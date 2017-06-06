   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Administrator Home</title>
</head>
<body>

<c:out value="${msg}"></c:out>
<h2 align="center">Welcome To Admin</h2>

<table>
	<tr>

		<td>
		<form:form action="addRestaurant" name="addrestaurant" method="Get">
		<input type="submit" value="Add Restaurant"/>
		</form:form>
		</td>
		<td><form:form action="changePassword" name="changePasswordPage" method="POST">
		<input type="submit" value="Change Password"/>
		</form:form></td>
		<td><form:form action="logout" name="logout" method="Get">
		<input type="submit" value="Logout"/>
		</form:form></td>
	
	</tr>
	<tr>
		<table cellspacing="5" border="1" width="60%">
			<tr>
				<th>Restaurants</th>
				<th>Categories</th>
				<th>Dishes</th>
			</tr>
			<tr>
			<c:forEach items="${restaurants}" var="restaurant">
			<c:if test="${emp.id!=0}">
				<td><form:checkbox path="selectedRestaurants" value="restaurant"/></td>
				<td><a href="editDetails/${restaurant}"><c:out value="${restaurant}"/></a></td>
			</c:if>
			</c:forEach>
			</tr>
		</table>
	</tr>
</table>

</body>
</html>
