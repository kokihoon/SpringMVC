package main.java.com.kokihoon.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import main.java.com.kokihoon.dao.RegisterDao;
import main.java.com.kokihoon.model.User;


@Repository
public class RegisterDaoImpl implements RegisterDao{
	
	@Autowired
	SqlSession session;
	
	private static String namespace = "main.java.com.kokihoon.mapper.userMapper";
	
	@Override
	public void register(User user) throws Exception {
		session.insert(namespace + ".register", user);
	}

}
