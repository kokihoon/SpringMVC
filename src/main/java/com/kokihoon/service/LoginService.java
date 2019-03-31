package main.java.com.kokihoon.service;

import java.util.List;

import main.java.com.kokihoon.model.User;

public interface LoginService {
	public List<User> login(User user) throws Exception;
}
