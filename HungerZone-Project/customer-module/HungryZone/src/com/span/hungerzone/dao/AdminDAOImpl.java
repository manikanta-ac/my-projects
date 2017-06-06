package com.span.hungerzone.dao;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.span.hungerzone.model.Admin;
import com.span.hungerzone.model.Feedback;

public class AdminDAOImpl implements AdminDAO {
	private HibernateTemplate hibernateTemplate;
 
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public boolean login(Admin admin) {

		boolean status = false;
	
		Admin testAdmin = (Admin) hibernateTemplate.get(Admin.class,
				admin.getAdminId());
System.out.println(testAdmin);
		if (testAdmin != null) {
			if (testAdmin.getAdminPassword().equals(admin.getAdminPassword())) {
				status = true;
			}

		} else
			status = false;

		return status;

	}

	public boolean adminRegistration(Admin admin) {
		
		try {

			SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");

			String aId = new Integer(prng.nextInt()).toString();
			char[] cid = aId.toCharArray();

			String id = null;
			if (cid[0] == '-') {

				id = new String(cid, 1, cid.length - 1);
			} else
				id = aId;
			String adminId = "HUNGER" + id;

			String apass = new Integer(prng.nextInt()).toString();
			char[] cpass = apass.toCharArray();

			String adminPassword = null;
			if (cpass[0] == '-') {

				adminPassword = new String(cpass, 1, cpass.length - 1);
			} else
				adminPassword = apass;

			System.out.println("Random AdminId: " + adminId);
			System.out.println("Random AdminPassword: " + adminPassword);
			admin.setAdminId(adminId);
			admin.setAdminPassword(adminPassword);
		} catch (NoSuchAlgorithmException ex) {
			System.err.println(ex);
		}
		boolean status = false;
		
		hibernateTemplate.save(admin);
		status=true;
		return status;

	}
	

	@Override
	public boolean saveFeedback(Feedback feedback) {
		
		System.out.println(feedback.getUserName());
		hibernateTemplate.save(feedback);
		
		return true;
	}

}
