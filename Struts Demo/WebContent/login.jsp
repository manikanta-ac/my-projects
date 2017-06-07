<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
</head>
<body>
<center>
<h3>User Login Authentication</h3>
	<s:form action="Login.action" method="post">
	<font color="red"><s:actionerror/></font>
		<s:textfield name="userName" label="User Name*"/><br>
		<s:password name="password" label="Password*"/><br>
		<s:submit/> &nbsp;&nbsp;&nbsp;<s:reset/>
	</s:form></center>
<a href="<s:url value="signup.jsp"/>">Sign Up(New User)
</a>
</body>
</html>