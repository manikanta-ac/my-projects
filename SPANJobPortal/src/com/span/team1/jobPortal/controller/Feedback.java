package com.span.team1.jobPortal.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.span.team1.jobPortal.dao.JobPortalDAO;


public class Feedback extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{		
		String uname = request.getParameter("fname");
		String comments = request.getParameter("comments");

		JobPortalDAO.feedback(uname,comments);

		response.sendRedirect("View_comments.jsp");

	}

}
