package com.span.hungerzone.service;

import com.span.hungerzone.model.Admin;
import com.span.hungerzone.model.Feedback;

public interface AdminService {
	
	
	boolean login(Admin admin);
	boolean adminRegistration(Admin admin);
	boolean saveFeedback(Feedback feedback);
	
}
