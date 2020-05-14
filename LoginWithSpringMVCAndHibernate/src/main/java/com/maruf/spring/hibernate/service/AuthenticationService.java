package com.maruf.spring.hibernate.service;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.maruf.spring.hibernate.pojo.User;

public class AuthenticationService {

	
	private HibernateTemplate hibernateTemplate;

	private AuthenticationService() {
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public boolean findUser(String email, String password) {

		boolean isValidUser = false;
		String sqlQuery = "from User u where u.email=? and u.password=?";
		try {
			List<User> userObj = (List<User>) hibernateTemplate.find(sqlQuery, email, password);
			if (userObj != null && userObj.size() > 0) {

				isValidUser = true;
			}
		} catch (Exception e) {
			isValidUser = false;

		}
		return isValidUser;
	}
}