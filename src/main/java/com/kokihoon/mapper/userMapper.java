package main.java.com.kokihoon.mapper;

import main.java.com.kokihoon.model.User;

public interface userMapper {

	public User login(User user) throws Exception;
	
	public void register(User user) throws Exception;
}
