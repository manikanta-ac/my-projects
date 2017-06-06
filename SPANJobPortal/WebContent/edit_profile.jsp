<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
</head>
<body>
<%@ page import="com.span.team1.jobPortal.dao.JobPortalDAO" %>
<%@ page import="com.span.team1.jobPortal.model.UserInfo" %>
<% 
String userName = (String) session.getAttribute("userName");

int id=JobPortalDAO.getUserId(userName);

UserInfo userInfo=JobPortalDAO.getUserInfo(id);

request.setAttribute("userInfo", userInfo);

%>
<jsp:forward page="register.jsp?fType=Update Profile"/>
</body>
</html>