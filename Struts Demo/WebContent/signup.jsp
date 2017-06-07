<%@page import="com.span.sip.assignment.dao.UserDAO"%>
<%@page import="com.span.sip.assignment.model.User"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Sign Up Page</title>
</head>
<body>
<%
	String type = (String)request.getAttribute("type");
	String action = "";
	if(type==null)
		action = "SignUp.action";
	else if(type.equals("View"))
		action = "View.action";
	else if(type.equals("Edit"))
		action = "Update.action";
	
	ActionContext.getContext().getValueStack().set("action", action);
%>
<br>
<br>
<br>
<br>
<br>
<div align="center">
<s:form action="%{action}" method="post" enctype="multipart/form-data">
<font color="red"><s:actionerror/></font>
		<s:textfield label="User Name*"/>
		<s:password name="user.password" label="Password*"/>
		
		<s:radio name="user.gender" label="Gender" list="#{'male':'Male','female':'Female'}" />
		<s:select name="user.college" 
				  label="Select a College"
				  headerKey="Select" headerValue="Select" 
				  list="#{'MSRIT':'MSRIT','PESCET':'PESCET','DAIT':'DAIT','SVEC':'SVEC' }"/>
		
		<s:select name="user.address"
				  label="Select a Address"
				   headerKey="Select" headerValue="Select" 
				  list="#{'Bangalore':'Bangalore','Hyderabad':'Hyderabad','Chennai':'Chennai','Delhi':'Delhi' }"/>
		<s:textfield name="user.phoneNo" label="Phone Number"/>
		<s:textfield name="user.email" label="Email Id" />
		<s:textarea name="user.aboutYou" label="About You" />
		<s:checkbox name="user.alerts" label="Would want information through mail?"/>
		<s:file name="user.resume" accept="text/plain"/>
		<% if(!("View".equals(type)))
		{%>
		<s:submit/><s:reset/>
		<%
		}%>
</s:form>
</div>
<s:form action="login.jsp">
	<s:submit value="Back"/>
</s:form>

</body>
</html>