package com.booker.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FacebookAPIController {

	@Autowired
	private Facebook facebook;

	@Autowired
	private ConnectionRepository connectionRepository;

	private static final Logger LOGS = LoggerFactory.getLogger(FacebookAPIController.class);

	@GetMapping
	public String helloFacebook(Model model) {
		if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
			return "redirect:/connect/facebook";
		}

		String[] fields = { "significant_other", "relationship_status", "first_name", "last_name", "name", "work" };
		User userProfile = facebook.fetchObject("me", User.class, fields);

		model.addAttribute("facebookProfile", userProfile);

		return "hello";
	}
}
