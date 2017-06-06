<%@page import="java.util.Date" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>
	<p class="userheader" ><%= new Date() %>	&nbsp; &nbsp; <a href="userhome.jsp" style="text-decoration: none;">Home</a> &nbsp; &nbsp;
	<a href="signout.jsp" style="text-decoration: none;">Sign out</a>	&nbsp; &nbsp; Welcome <%= session.getAttribute("userName") %>.....!</p>
	<p class="login">Thank You, Your ticket has been booked successfully</p>
</body>
</html>