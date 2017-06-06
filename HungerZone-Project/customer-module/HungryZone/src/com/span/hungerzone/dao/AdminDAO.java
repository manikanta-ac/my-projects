package com.span.hungerzone.dao;

import com.span.hungerzone.model.Admin;
import com.span.hungerzone.model.Feedback;

public interface AdminDAO {

	boolean login(Admin admin);
	
	boolean adminRegistration(Admin admin);
	
	boolean saveFeedback(Feedback feedback);
}
