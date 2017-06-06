package com.span.jobPortal.model;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import com.span.jobPortal.dao.JobPortalDAO;

@ManagedBean(name="feedback")
public class FeedbackBean {
	private String name;
	private String comments;
	private List<FeedbackBean> allFeedbacks = new ArrayList<FeedbackBean>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public List<FeedbackBean> getAllFeedbacks() {
		return allFeedbacks;
	}
	public void setAllFeedbacks(List<FeedbackBean> allFeedbacks) {
		this.allFeedbacks = allFeedbacks;
	}
	public String storeFeedback(){
		JobPortalDAO.feedback(name,comments);
		allFeedbacks = JobPortalDAO.getAllComments();
		return "viewComments";
	}
}
