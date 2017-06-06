package com.span.hungerzone.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.span.hungerzone.dao.AdminDAO;
import com.span.hungerzone.model.Admin;
import com.span.hungerzone.model.Feedback;

public class AdminServiceImpl implements AdminService{
	
@Autowired
AdminDAO adminDAO;
 

	@Override
	public boolean login(Admin admin) {
	
		return adminDAO.login(admin);
		
	}
	
	public boolean adminRegistration(Admin admin)
	{
		
		return adminDAO.adminRegistration(admin);
	}

	@Override
	public boolean saveFeedback(Feedback feedback) {
		
		return adminDAO.saveFeedback(feedback);
	}
}
