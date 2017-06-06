package com.span.team1.jobPortal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.span.team1.jobPortal.dao.JobPortalDAO;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		String userName = request.getParameter("userName");		
		String pwd = request.getParameter("password");		
		PrintWriter pw=response.getWriter();
		boolean flag=JobPortalDAO.login(userName,pwd);
		if(flag)
		{
			request.getRequestDispatcher("jobseeker_home.jsp").forward(request, response); 
		}
		else
		{
			pw.println("<div align='right'><h3><pre><font color='red'>Invalid E-Mail/Password </font></pre></h3></div>");
			request.getRequestDispatcher("home_body.html").include(request, response); 
		}
		
	}

}
