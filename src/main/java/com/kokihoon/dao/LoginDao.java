package main.java.com.kokihoon.dao;

import main.java.com.kokihoon.model.User;

public interface LoginDao {
	public User login(User user) throws Exception;
}
