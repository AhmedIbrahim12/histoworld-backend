package com.booker.services.roles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

	@Autowired
	RolesRepository rulesRepo;

	public List<Role> getAllRoles() {
		return rulesRepo.findAll();
	}
}
