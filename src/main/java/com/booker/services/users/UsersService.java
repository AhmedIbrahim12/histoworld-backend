package com.booker.services.users;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booker.services.roles.RolesService;
import com.booker.services.users.exceptions.UserNotFoundException;
import com.booker.services.users.exceptions.WrongPasswordException;

@Service
public class UsersService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RolesService rolesService;

	@Autowired
	private HttpSession session;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public void addUser(User user) {
		userRepo.save(user);
	}

	public User findByName(String userName) {
		return userRepo.findByuserName(userName);
	}

	public User valiateUser(String userName, String password) throws UserNotFoundException, WrongPasswordException {
		User user = findByName(userName);
		if (user == null) {
			throw new UserNotFoundException();
		}

		if (!user.getUserPassword().equals(password)) {
			throw new WrongPasswordException();
		}

		return user;
	}
}
