package com.booker.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.booker.controllers.annotations.RestEndpoint;
import com.booker.services.users.User;
import com.booker.services.users.UsersService;

@RestController
@CrossOrigin
@RestEndpoint
public class LoginController {

	@Autowired
	UsersService userService;

	@Autowired
	HttpSession session;

	@PostMapping(value = "/login")
	public User login(HttpSession session, @RequestParam("username") String userName,
			@RequestParam("password") String password) {
		User user = null;
		try {
			user = userService.valiateUser(userName, password);
			session.setAttribute("user", user);
		} catch (Exception e) {
			return new User();
		}
		return user;
	}
}
