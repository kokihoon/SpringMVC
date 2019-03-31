package main.java.com.kokihoon.mapper;

import java.util.List;

import main.java.com.kokihoon.model.User;

public interface userMapper {

	public List<User> login(User user) throws Exception;
}
