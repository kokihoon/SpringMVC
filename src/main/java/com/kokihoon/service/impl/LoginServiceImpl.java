package main.java.com.kokihoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.java.com.kokihoon.dao.LoginDao;
import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;
import main.java.com.kokihoon.service.LoginService;

@Service
public class LoginServiceImpl  implements LoginService{
	
	@Autowired
	LoginDao dao;
	
	@Override
	public User login(LoginDto loginDto) throws Exception {
		return dao.login(loginDto);
	}
}
