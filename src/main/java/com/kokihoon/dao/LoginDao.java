package main.java.com.kokihoon.dao;

import java.util.List;

import main.java.com.kokihoon.model.User;

public interface LoginDao {
	public List<User> login(User user) throws Exception;
}
