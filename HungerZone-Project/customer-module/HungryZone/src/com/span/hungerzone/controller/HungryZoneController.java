package com.span.hungerzone.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.span.hungerzone.model.Admin;
import com.span.hungerzone.model.Customer;
import com.span.hungerzone.model.Feedback;
import com.span.hungerzone.model.Restaurant;
import com.span.hungerzone.service.AdminService;

@Controller
public class HungryZoneController {

	@Autowired
	AdminService adminservice;
	@Autowired
	Admin admin;

	Restaurant restaurant;
	boolean status = false;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView Home() {
		ModelAndView model = new ModelAndView("Home");
		model.addObject("feedback", new Feedback());
		return model;
	}

	@RequestMapping(value = "/feedback", method = RequestMethod.GET)
	public ModelAndView feedback(Feedback feedback, BindingResult result,
			Model model) {

		adminservice.saveFeedback(feedback);
		ModelAndView results = new ModelAndView("Home");
		model.addAttribute("msg", "Feedback submitted successfully");
		return results;
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView welcome() {
		ModelAndView result = new ModelAndView("AdminLogin");
		result.addObject("admin", new Admin());
		return result;
	}
	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public ModelAndView customer() {
		ModelAndView result = new ModelAndView("Registration");
		result.addObject("customer", new Customer());
		return result;
	}
	@RequestMapping(value = "/customerLogin", method = RequestMethod.GET)
	public ModelAndView customerLogin() {
		ModelAndView result = new ModelAndView("Login");
		result.addObject("customer", new Customer());
		return result;
	}

	@RequestMapping(value = "/changePasswordPage", method = RequestMethod.GET)
	public ModelAndView changePasswordPage() {
		ModelAndView result = new ModelAndView("ChangePassword");
		result.addObject("admin", new Admin());
		return result;
	}

	@RequestMapping(value = "/changePassword/{adminPassword}/{newAdminPassword}/{confirmNewAdminPassword}", method = RequestMethod.GET)
	public ModelAndView changePassword(@ModelAttribute("admin") Admin admin,
			@PathVariable Long adminPassword,
			@PathVariable Long newAdminPassword,
			@PathVariable Long confirmNewAdminPassword, BindingResult result,
			Model modal) {
		System.out.println(adminPassword);
		System.out.println(newAdminPassword);
		System.out.println(confirmNewAdminPassword);

		ValidationUtils.rejectIfEmptyOrWhitespace(result, "adminPassword",
				"adminPassword.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "newAdminPassword",
				"newAdminPassword.required");

		ValidationUtils.rejectIfEmptyOrWhitespace(result,
				"confirmNewAdminPassword", "confirmNewAdminPassword.required");
		if (result.hasErrors()) {
			return new ModelAndView("ChangePassword");
		}
		// boolean status=adminservice.changePassword(admin);
		if (status) {
			modal.addAttribute("msg",
					"Hello Admin, Your Password has been changed");
			return new ModelAndView("AdminHome");
		} else {
			modal.addAttribute("msg",
					"Sorry, Some Error has been occured!!! Try Again");
			return new ModelAndView("ChangePassword");
		}
	}

	@RequestMapping(value = "/adminRegPage", method = RequestMethod.GET)
	public ModelAndView adminRegPage() {
		ModelAndView result = new ModelAndView("AdminRegistration");
		result.addObject("admin", new Admin());
		return result;
	}

	@RequestMapping(value = "/adminRegistration", method = RequestMethod.POST)
	public ModelAndView adminRegistration(@ModelAttribute("admin") Admin admin,
			BindingResult result, Model model, HttpSession session) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "adminName",
				"adminName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "adminEmail",
				"adminEmail.required");

		if (result.hasErrors()) {
			return new ModelAndView("AdminRegistration");
		}
		System.out.println(admin.getAdminName());
		status = adminservice.adminRegistration(admin);
		if (status) {
			model.addAttribute("msg", "Admin Created");
			return new ModelAndView("Home");
		} else {
			return new ModelAndView("AdminRegistration");
		}
	}

	/*
	 * @RequestMapping(value = "/welcome", method = RequestMethod.GET) public
	 * ModelAndView welcome() { ModelAndView result = new
	 * ModelAndView("Invoice"); result.addObject("invoice", new Invoice());
	 * return result; }
	 */

	@RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("admin") Admin admin,
			BindingResult result, Model model, HttpSession session) {
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "adminId",
				"adminId.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(result, "adminPassword",
				"adminPassword.required");
		if (result.hasErrors()) {
			return new ModelAndView("AdminLogin");
		}

		status = adminservice.login(admin);

		if (status) {
			session.setAttribute("adminId", admin.getAdminId());
			System.out.println("home" + session.getAttribute("adminId"));
			model.addAttribute("msg", "Now You are Logged In");
			return new ModelAndView("AdminHome");
		} else {

			model.addAttribute("msg", "Enter Correct AdminId Or Admin Password");
			return new ModelAndView("AdminLogin");

		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {

		String adminId = session.getAttribute("adminId").toString();

		if (adminId != null) {

			adminId = null;
			session.invalidate();

		}
		model.addAttribute("msg", "You are Logged Out now");

		return "Home";

	}

	@ModelAttribute("category")
	public List<String> createHobbiesList() {
		List<String> category = new ArrayList<String>();

		category.add("Italian");
		category.add("Chinese");
		category.add("Indian");
		category.add("Japanese");
		return category;
	}

	@RequestMapping(value = "/addRestaurant", method = RequestMethod.GET)
	public ModelAndView addRestaurant(
			@ModelAttribute("category") List<String> category) {
		ModelAndView result = new ModelAndView("AddRestaurant");

		result.addObject("categories", category);

		result.addObject("Restaurant", new Restaurant());

		return result;
	}

}
