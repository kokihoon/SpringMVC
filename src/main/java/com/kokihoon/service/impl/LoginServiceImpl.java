package main.java.com.kokihoon.service.impl;

import java.util.Date;

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

	@Override
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception {
		dao.keepLogin(userId, sessionId, sessionLimit);
		
	}

	@Override
	public User checkLoginBefore(String value) throws Exception {
		
		return dao.checkUserWithSessionKey(value);
	}
}
