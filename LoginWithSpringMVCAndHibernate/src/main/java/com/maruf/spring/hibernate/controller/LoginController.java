package com.maruf.spring.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.maruf.spring.hibernate.service.AuthenticationService;
import com.maruf.spring.hibernate.service.EmailValidationService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private AuthenticationService authenticateService;
	
	@Autowired
	private EmailValidationService emailValidationService;

	// Checks if the user credentials are valid or not.
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public ModelAndView validateUsr(@RequestParam("email") String email, @RequestParam("password") String password) {
		
		// Checks if the email is valid or not.
		boolean isValidEmail = emailValidationService.emailValidate(email);
		
		if(isValidEmail)
		{
			
			String msg = "";
			boolean isValidUser = authenticateService.findUser(email, password);

			if (isValidUser) {
				msg = "Welcome " + email + "!";
			} else {
				msg = "Invalid credentials";
			}

			return new ModelAndView("result", "output", msg);
			
		}
		
		else
		{
			String msg = "Enter valid email!!";
			return new ModelAndView("index","emailerror",msg);
		}
	}
}