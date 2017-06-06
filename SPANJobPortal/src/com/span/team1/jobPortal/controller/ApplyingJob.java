package com.span.team1.jobPortal.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.span.team1.jobPortal.dao.JobPortalDAO;

public class ApplyingJob extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		String userName = (String) session.getAttribute("userName");		
		int userId = JobPortalDAO.getUserId(userName);
		
		int jobId = Integer.parseInt((String)request.getParameter("jobId"));
		
		JobPortalDAO.applyJob(userId,jobId);
		
		String companyURL = (String)request.getParameter("companyURL");
		
		response.sendRedirect(companyURL);
	}
}
