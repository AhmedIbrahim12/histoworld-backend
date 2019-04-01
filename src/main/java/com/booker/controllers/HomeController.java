package com.booker.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booker.controllers.annotations.RestEndpoint;
import com.booker.services.roles.RolesService;
import com.booker.services.users.User;

@RestController
@RestEndpoint
public class HomeController {

	@Autowired
	RolesService rolesService;

	@GetMapping(value = "/getUserRoles")
	public List<String> getUserRoles(HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user.getUserName().equals("Admin")) {
			return rolesService.getAllRoles().stream().map(role -> role.getRoleName()).collect(Collectors.toList());
		}
		return new ArrayList<String>();
	}
}
