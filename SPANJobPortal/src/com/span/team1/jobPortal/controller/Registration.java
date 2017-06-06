package com.span.team1.jobPortal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.span.team1.jobPortal.dao.JobPortalDAO;
import com.span.team1.jobPortal.model.UserInfo;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String type = request.getParameter("type");
		
		UserInfo user = new UserInfo();
		
		user.setFirstName(request.getParameter("fname"));
		user.setEmail(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		user.setQualification(request.getParameter("Qualification"));
		user.setCollegeName(request.getParameter("cname"));
		user.setStream(request.getParameter("stream"));
		user.setPercentage(request.getParameter("percentage"));
		user.setYearOfPassing(request.getParameter("YearOfPassing"));
		
		String firstName = user.getFirstName();
		String email = user.getEmail();
		String pass = user.getPassword();
		String qualification = user.getQualification();
		String collegeName = user.getCollegeName();
		String stream = user.getStream();
		String percentage = user.getPercentage();
		String yearOfPassing = user.getYearOfPassing();
		
		if(type.equals("Registration"))
		{
			JobPortalDAO.personalDetail(firstName, email, pass);
			JobPortalDAO.academicDetail(firstName, qualification, collegeName, stream, percentage, yearOfPassing);
			response.sendRedirect("home_body.html");
		}
		else if(type.equals("Update Profile"))
		{
			HttpSession session = request.getSession();
			String userName = (String) session.getAttribute("userName");
			
			JobPortalDAO.updateUserDetails(user,userName);
			response.sendRedirect("jobseeker_home.jsp?userName="+email);
		}		
	}
}
