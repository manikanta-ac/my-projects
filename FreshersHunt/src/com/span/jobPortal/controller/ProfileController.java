package com.span.jobPortal.controller;

import java.text.DateFormatSymbols;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.span.jobPortal.dao.JobPortalDAO;
import com.span.jobPortal.model.UserBean;

@ManagedBean(name="profile")
@SessionScoped
public class ProfileController {
	@ManagedProperty("#{user.firstName}")
	private String userName;
	private String createOrEdit;
	private UserBean user;
	private Map<String, String> daysPulldown;
	private Map<String, String> monthPulldown;
	private Map<String, String> yearPulldown;
	private Map<String, String> countryPulldown;
	private Map<String, String> statePulldown;
	private Map<String, String> cityPulldown;
	private Map<String, String> qualificationPulldown;
	private Map<String, String> yearOfPassPulldown;
	private String fotnSize;
	
	{
		user = new UserBean();
		createOrEdit = "Register";
		daysPulldown = new LinkedHashMap<String, String>();
		monthPulldown = new LinkedHashMap<String, String>();
		yearPulldown = new LinkedHashMap<String, String>();
		countryPulldown = new LinkedHashMap<String, String>();
		statePulldown = new LinkedHashMap<String, String>();
		cityPulldown = new LinkedHashMap<String, String>();
		qualificationPulldown = new LinkedHashMap<String, String>();
		yearOfPassPulldown = new LinkedHashMap<String, String>();
		
		daysPulldown.put("Day", "");
		for(int i=1;i<=31;i++){
			daysPulldown.put(""+i, ""+i);
		}
		
		monthPulldown.put("Month", "");
		String[] shortMonths = new DateFormatSymbols().getShortMonths();
        for (int i = 0; i < shortMonths.length; i++) {
        	monthPulldown.put(shortMonths[i], shortMonths[i]);;
        }
        
        yearPulldown.put("Year", "");
		for(int i=1980;i<=2000;i++){
			yearPulldown.put(""+i, ""+i);
		}
		
		countryPulldown.put("Select Country", "");
		countryPulldown.put("India", "India");
		countryPulldown.put("US", "US");
		countryPulldown.put("Australia", "Australia");
		
		statePulldown.put("Select State", "");
		statePulldown.put("Karnataka", "KA");
		statePulldown.put("Andhra Prdesh", "AP");
		statePulldown.put("Telangana", "TS");
		statePulldown.put("TamilNadu", "TN");
		statePulldown.put("Kerala", "KL");
		
		cityPulldown.put("Select City", "");
		cityPulldown.put("Bangalore", "Bangalore");
		cityPulldown.put("Vijaywada", "Vijaywada");
		cityPulldown.put("Hyderabad", "Hyderabad");
		cityPulldown.put("Chennai", "Chennai");
		cityPulldown.put("Kochi", "Kochi");
		
		qualificationPulldown.put("Select Qualification", "");
		qualificationPulldown.put("B.A", "B.A");
		qualificationPulldown.put("B.Arch", "B.Arch");
		qualificationPulldown.put("B.Com", "B.Com");
		qualificationPulldown.put("B.E/B.Tech", "B.E/B.Tech");
		qualificationPulldown.put("B.Sc", "B.Sc");
		qualificationPulldown.put("BCA", "BCA");
		qualificationPulldown.put("MCA", "MCA");
		qualificationPulldown.put("M.Sc", "M.Sc");
		
		yearOfPassPulldown.put("Year Of Passing", "");
			for(int i=2005;i<=2015;i++){
				yearOfPassPulldown.put(""+i, ""+i);
			}
	}
	public String getCreateOrEdit() {
		return createOrEdit;
	}

	public void setCreateOrEdit(String createOrEdit) {
		this.createOrEdit = createOrEdit;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}
	
	public Map<String, String> getDaysPulldown() {
		return daysPulldown;
	}

	public void setDaysPulldown(Map<String, String> daysPulldown) {
		this.daysPulldown = daysPulldown;
	}

	public Map<String, String> getMonthPulldown() {
		return monthPulldown;
	}

	public void setMonthPulldown(Map<String, String> monthPulldown) {
		this.monthPulldown = monthPulldown;
	}

	public Map<String, String> getYearPulldown() {
		return yearPulldown;
	}

	public void setYearPulldown(Map<String, String> yearPulldown) {
		this.yearPulldown = yearPulldown;
	}

	public Map<String, String> getCountryPulldown() {
		return countryPulldown;
	}

	public void setCountryPulldown(Map<String, String> countryPulldown) {
		this.countryPulldown = countryPulldown;
	}

	public Map<String, String> getStatePulldown() {
		return statePulldown;
	}

	public void setStatePulldown(Map<String, String> statePulldown) {
		this.statePulldown = statePulldown;
	}

	public Map<String, String> getCityPulldown() {
		return cityPulldown;
	}

	public void setCityPulldown(Map<String, String> cityPulldown) {
		this.cityPulldown = cityPulldown;
	}

	public Map<String, String> getQualificationPulldown() {
		return qualificationPulldown;
	}

	public void setQualificationPulldown(
			Map<String, String> qualificationPulldown) {
		this.qualificationPulldown = qualificationPulldown;
	}

	public Map<String, String> getYearOfPassPulldown() {
		return yearOfPassPulldown;
	}

	public void setYearOfPassPulldown(Map<String, String> yearOfPassPulldown) {
		this.yearOfPassPulldown = yearOfPassPulldown;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getFotnSize() {
		return fotnSize;
	}
	public void setFotnSize(String fotnSize) {
		this.fotnSize = fotnSize;
	}
	
	public String registerUser(){
		String firstName = user.getFirstName();
		String email = user.getEmail();
		String pass = user.getPassword();
		String qualification = user.getQualification();
		String collegeName = user.getCollegeName();
		String stream = user.getStream();
		String percentage = user.getPercentage();
		String yearOfPassing = user.getYearOfPassing();
		
		if(createOrEdit.equalsIgnoreCase("Register"))
		{
			JobPortalDAO.storePersonalDetail(firstName, email, pass);
			JobPortalDAO.storeAcademicDetail(firstName, qualification, collegeName, stream, percentage, yearOfPassing);
			return "index";
		}
		else if(createOrEdit.equalsIgnoreCase("Update"))
		{
			JobPortalDAO.updateUserDetails(user,userName);
			return "jobSeekerHome";
		}
		return null;
	}
	
	public String openReigistration(){
		createOrEdit = "Register";
		user = new UserBean();
		return "register";
	}
	
	public String editProfile(){
		int userId = JobPortalDAO.getUserId(userName);
		user = JobPortalDAO.getUserInfo(userId);
		createOrEdit = "Update";
		return "register";
	}
	
	public String viewProfile(){
		int userId = JobPortalDAO.getUserId(userName);
		user = JobPortalDAO.getUserInfo(userId);
		return "viewProfile";
	}
	
	public void setNormalSize(ActionEvent event) {
		fotnSize = "normalFont";
	}
	
	public void setLargeSize(ActionEvent event) {
		fotnSize = "largeFont";
	}
}
