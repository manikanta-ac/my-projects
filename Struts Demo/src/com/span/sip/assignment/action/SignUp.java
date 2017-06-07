package com.span.sip.assignment.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.span.sip.assignment.dao.UserDAO;
import com.span.sip.assignment.model.User;

public class SignUp extends ActionSupport
{
	private static final long serialVersionUID = 1L;

	public User user = new User();

	public void validate()
	{
		//System.out.println("Validate SignUp>>>>>>>>>>>>>>>>>>>");

		if(user.getUserName()==null || user.getUserName().length()==0)
			addFieldError("user.userName", "Please Enter User Name");
		if(user.getPassword()==null || user.getPassword().length()==0)
			addFieldError("user.password", "Please Enter Password");

		if(user.getUserName()==null || user.getUserName().length()==0 || user.getPassword()==null || user.getPassword().length()==0)
			addActionError("Sign Up Failed");
	}	

	public String addUser()
	{
		//System.out.println("Adding User..........................");

		boolean status = UserDAO.addUser(user);

		if(status)
			return "success";
		else
			return "input";
	}

	public String viewUser()
	{
		System.out.println("View User#################.!");
		
		String userName = ServletActionContext.getRequest().getParameter("userName");
		ServletActionContext.getRequest().setAttribute("type", "View");
		
		user = UserDAO.getUser(userName);

		return "true";
	}

	public String editUser()
	{
		System.out.println("Edit User............!");
		String userName = ServletActionContext.getRequest().getParameter("userName");
		ServletActionContext.getRequest().setAttribute("type", "Edit");
		
		user = UserDAO.getUser(userName);
		
		return "true";
	}

	public String deleteUser()
	{
		String userName = ServletActionContext.getRequest().getParameter("userName");
		boolean status = UserDAO.deleteUser(userName); 
		if(status)
			return "success";
		else
			return "input";
	}

	public String updateUser()
	{
		String userNameOld = (String) ActionContext.getContext().getValueStack().findValue("userName");

		boolean status = UserDAO.editUser(user,userNameOld);

		if(status)
			return "success";
		else
			return "input";
	}
}
