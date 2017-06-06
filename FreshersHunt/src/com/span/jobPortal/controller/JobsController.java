package com.span.jobPortal.controller;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.span.jobPortal.dao.JobPortalDAO;
import com.span.jobPortal.model.Job;

@ManagedBean(name="jobSeeker")
@SessionScoped
public class JobsController{
	@ManagedProperty("#{user.firstName}")
	private String userName;
	private String retrieveType;
	private Job job;
	private List<Job> jobs;
	
	public String getRetrieveType() {
		return retrieveType;
	}
	public void setRetrieveType(String retrieveType) {
		this.retrieveType = retrieveType;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Job getJob() {
		return job;
	}
	public void setJob(Job job) {
		this.job = job;
	}
	
	public String jobsHistory(){
		retrieveType = "Applied Jobs";
		int userId = JobPortalDAO.getUserId(userName);
		jobs = JobPortalDAO.getJobs(userId);
		return "allJobs";
	}
	
	public String getRecommendedJobs(){
		retrieveType = "Recommended Jobs";
		int userId = JobPortalDAO.getUserId(userName);
		jobs = JobPortalDAO.getRecommendedJobs(userId);
		return "allJobs";
	}
	
	public String viewJob(){
		FacesContext fc = FacesContext.getCurrentInstance();
		Map<String,String> params = fc.getExternalContext().getRequestParameterMap();
		String jobId = params.get("jobId"); 
		job = JobPortalDAO.getJob(Integer.valueOf(jobId));
		return "viewJob";
	}
	
	public String applyJob(){
		int userId = JobPortalDAO.getUserId(userName);
		int jobId = job.getJobId();
		JobPortalDAO.applyJob(userId,jobId);
		return "loadURL";
	}
}
