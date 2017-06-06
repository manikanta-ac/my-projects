package com.span.jobPortal.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import com.span.jobPortal.dao.JobPortalDAO;
import com.span.jobPortal.model.Job;

@ManagedBean(name="jobSearch")
@SessionScoped
public class JobSearchController {
	private String industry;
	private String keywords;
	private String experience;
	private String quali;
	private String salary;
	private String location;
	@ManagedProperty("#{jobSeeker}")
	private JobsController jobsController;
	private Map<String, String> categoryPulldown;
	private Map<String, String> experiancePulldown;
	private Map<String, String> qualificationPulldown;
	private Map<String, String> salaryPulldown;
	
	{
		categoryPulldown = new LinkedHashMap<String, String>();
		experiancePulldown = new LinkedHashMap<String, String>();
		qualificationPulldown = new LinkedHashMap<String, String>();
		salaryPulldown = new LinkedHashMap<String, String>();
		
		categoryPulldown.put("Select Category", "none");
		categoryPulldown.put("IT/Software", "IT/Software");
		categoryPulldown.put("Core Technical", "Core Technical");
		categoryPulldown.put("Marketing", "Marketing");
		categoryPulldown.put("Banking", "Banking");
		categoryPulldown.put("HR", "HR");
		
		experiancePulldown.put("Select No.of Years", "none");
		experiancePulldown.put("0-1", "0-1");
		experiancePulldown.put("1-2", "1-2");
		experiancePulldown.put("2-3", "2-3");
		experiancePulldown.put("3-4", "3-4");
		experiancePulldown.put("4-5", "4-5");
		
		qualificationPulldown.put("Select Degree", "none");
		qualificationPulldown.put("B.Tech", "B.Tech");
		qualificationPulldown.put("B.E", "B.E");
		qualificationPulldown.put("MCA", "MCA");
		qualificationPulldown.put("M.Tech", "M.Tech");
		qualificationPulldown.put("MBA", "MBA");
		qualificationPulldown.put("Bcom", "Bcom");
		qualificationPulldown.put("BSc", "BSc");
		
		salaryPulldown.put("Select Range", "none");
		salaryPulldown.put("0-1", "0-1");
		salaryPulldown.put("1-2", "1-2");
		salaryPulldown.put("2-3", "2-3");
		salaryPulldown.put("3-4", "3-4");
		salaryPulldown.put("4-5", "4-5");
		
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getQuali() {
		return quali;
	}
	public void setQuali(String quali) {
		this.quali = quali;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public JobsController getJobsController() {
		return jobsController;
	}
	public void setJobsController(JobsController jobsController) {
		this.jobsController = jobsController;
	}
	public Map<String, String> getCategoryPulldown() {
		return categoryPulldown;
	}
	public void setCategoryPulldown(Map<String, String> categoryPulldown) {
		this.categoryPulldown = categoryPulldown;
	}
	public Map<String, String> getExperiancePulldown() {
		return experiancePulldown;
	}
	public void setExperiancePulldown(Map<String, String> experiancePulldown) {
		this.experiancePulldown = experiancePulldown;
	}
	public Map<String, String> getQualificationPulldown() {
		return qualificationPulldown;
	}
	public void setQualificationPulldown(Map<String, String> qualificationPulldown) {
		this.qualificationPulldown = qualificationPulldown;
	}
	public Map<String, String> getSalaryPulldown() {
		return salaryPulldown;
	}
	public void setSalaryPulldown(Map<String, String> salaryPulldown) {
		this.salaryPulldown = salaryPulldown;
	}
	public String searchJobs(){
		List<Job> jobs = JobPortalDAO.searchjob(industry,keywords,experience,quali,salary,location);
		jobsController.setJobs(jobs);
		jobsController.setRetrieveType("Search Results");
		return "allJobs";
	}
}
