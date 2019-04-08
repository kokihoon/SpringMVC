package main.java.com.kokihoon.service;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

public interface LoginService {
	
	public User login(LoginDto loginDto) throws Exception;
}
