package com.span.jobPortal.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.span.jobPortal.dao.JobPortalDAO;

@ManagedBean(name="user")
@SessionScoped
public class UserBean 
{
	private int Id;
	private String firstName;
	private String email;
	private String password;
	private String qualification;
	private String collegeName;
	private String stream;
	private String percentage;
	private String yearOfPassing;

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getQualification() 
	{
		return qualification;
	}
	public void setQualification(String qualification) 
	{
		this.qualification = qualification;
	}
	public String getCollegeName() 
	{
		return collegeName;
	}
	public void setCollegeName(String collegeName) 
	{
		this.collegeName = collegeName;
	}
	public String getStream() 
	{
		return stream;
	}
	public void setStream(String stream) 
	{
		this.stream = stream;
	}
	public String getPercentage() 
	{
		return percentage;
	}
	public void setPercentage(String percentage) 
	{
		this.percentage = percentage;
	}
	public String getYearOfPassing() 
	{
		return yearOfPassing;
	}
	public void setYearOfPassing(String yearOfPassing) 
	{
		this.yearOfPassing = yearOfPassing;
	}
	
	public String login(){
		FacesContext context = FacesContext.getCurrentInstance();
		if (getEmail().equals("")) {
			context.addMessage("j_idt24:un",new FacesMessage("Email-Id required"));
		}else{
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(getEmail());
			if(!matcher.matches()){
				context.addMessage("j_idt24:un",new FacesMessage("Email should of format 'abc@xyz.com'"));
			}
		}
		if (getPassword().equals("")) {
			context.addMessage("j_idt24:pd",new FacesMessage("Password required"));
		}

		if (context.getMessageList().size() > 0) {
			return null;
		} else {
			boolean isExists=JobPortalDAO.login(email,password);
			if(isExists){
				firstName = JobPortalDAO.getUserName(email);
				return "jobSeekerHome";
			}else{
				context.addMessage("j_idt24:both",new FacesMessage("Invalid Email/Password."));
				return null;
			}
		}
	}

	public String logout() {
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
				.getSession(false)).invalidate();
		return "index";
	}

}