package main.java.com.kokihoon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import main.java.com.kokihoon.dao.RegisterDao;
import main.java.com.kokihoon.model.User;
import main.java.com.kokihoon.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	RegisterDao registerDao;
	
	
	@Override
	public void register(User user) throws Exception {
		registerDao.register(user);
	}
}
