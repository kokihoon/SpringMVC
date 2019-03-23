package main.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.dao.UserDAO;
import main.java.model.User;
import main.java.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public User getUser(User user) throws Exception {
		return userDAO.get(user);
	}
}
