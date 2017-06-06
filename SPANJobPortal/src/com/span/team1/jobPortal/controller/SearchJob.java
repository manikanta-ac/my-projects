package com.span.team1.jobPortal.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.span.team1.jobPortal.dao.JobPortalDAO;
import com.span.team1.jobPortal.model.Job;

public class SearchJob extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String industry=request.getParameter("industry");
		String keywords=request.getParameter("keywords");
		String experience=request.getParameter("experience");
		String quali=request.getParameter("quali");
		String salary=request.getParameter("salary");
		String location=request.getParameter("location");	
		
		List<Job> jobs = JobPortalDAO.searchjob(industry,keywords,experience,quali,salary,location);
		
		request.setAttribute("jobs", jobs);
		request.setAttribute("jobsType","Search Results");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jobs_list.jsp");
		dispatcher.forward(request, response);
	}

}
