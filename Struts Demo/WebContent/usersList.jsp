<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.span.sip.assignment.dao.UserDAO"%>
<%@page import="com.span.sip.assignment.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
</head>
<body>
<%
	List<User> users = UserDAO.getAllUsers();
%>
	<table cellpadding="2" cellspacing="3">
		<tr>
			<th>User Name</th>
			<th>Password</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>College</th>
			<th>About</th>
			<th>Action</th>
		</tr>
		<%
			for(User user:users)
			{
		%>
			<tr>
				<td><%= user.getUserName() %></td>
				<td><%= user.getPassword() %></td>
				<td><%= user.getEmail() %></td>
				<td><%= (user.getPhoneNo()!=0)?(user.getPhoneNo()):"" %></td>
				<td><%= (user.getGender()!=null)?(user.getGender()):"" %></td>
				<td><%= (!"Select".equals(user.getCollege()))?(user.getCollege()):"" %></td>				
				<td><%= user.getAboutYou() %></td>
				<td><a href="<s:url action="Edit">
							 <s:param name="userName"><%= user.getUserName() %></s:param>
							 </s:url>">Edit</a>
					<a href="<s:url action="Delete.action">
							 <s:param name="userName"><%= user.getUserName() %></s:param>
							 </s:url>">Delete</a>
					<a href='<s:url action="View.action">
							 <s:param name="userName"><%= user.getUserName() %></s:param>
							 </s:url>'>View</a>
				</td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>