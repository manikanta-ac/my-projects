<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>change Password</title>
</head>
<body>

<h1>Change Password</h1>
<hr>
	<form:form name="ChangePass" modelAttribute="admin" action="changePassword/{newAdminPassword}/{confirmNewAdminPassword}" method="post">
		<table bgcolor="AliceBlue" cellpadding="5" cellspacing="5">
	<tr>	
  <p style="color:red"> <c:out value="${msg}"></c:out></p>
   </tr>
			<tr>
				<td><form:label path="adminPassword"/>Current Admin Password</td>
				<td><form:input path="adminPassword"/><form:errors path="adminPassword" cssStyle="color:red"></form:errors>  </td>
			</tr>
			<tr>
				<td><form:label path="newAdminPassword"/>New Admin Password</td>
				<td><form:password path="newAdminPassword"/>
			<form:errors path="newAdminPassword" cssStyle="color:red"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="confirmNewAdminPassword"/>Confirm New Admin Password</td>
				<td><form:password path="confirmNewAdminPassword"/>
			<form:errors path="confirmNewAdminPassword" cssStyle="color:red"></form:errors></td>
			</tr>
			
			<tr>
			
				<td> <input type="Submit" value="Change Password"></input></td>
				<td> <input type="reset" value="Reset"></input></td>
				
			</tr>
		</table>

	</form:form>
</body>
</html>