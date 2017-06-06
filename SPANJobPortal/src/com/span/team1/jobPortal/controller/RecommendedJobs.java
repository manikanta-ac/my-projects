package com.span.team1.jobPortal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.span.team1.jobPortal.dao.JobPortalDAO;
import com.span.team1.jobPortal.model.Job;

public class RecommendedJobs extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) 
			            throws ServletException, IOException 
	{
		HttpSession session=request.getSession();
		
		String userName = (String) session.getAttribute("userName");
		
		int id=JobPortalDAO.getUserId(userName);
		
		List<Job> jobs=JobPortalDAO.getRecommendedJobs(id);
		
		request.setAttribute("jobsType", "Recommended Jobs");
		
		request.setAttribute("jobs", jobs);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("jobs_list.jsp");
		
		requestDispatcher.forward(request, response);
	}

}
