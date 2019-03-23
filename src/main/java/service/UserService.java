package main.java.service;

import org.springframework.stereotype.Service;

import main.java.model.User;

@Service
public interface UserService {
	public User getUser(User user) throws Exception;
}
