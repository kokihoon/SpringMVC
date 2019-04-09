package main.java.com.kokihoon.dao;

import java.util.Date;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;

public interface LoginDao {
	
	// �α��� ó��
	public User login(LoginDto loginDto) throws Exception;
	
	// �α��� ���� ó��
	public void keepLogin(String userId, String sessionId, Date sessionLimit) throws Exception;
	
	// ����Ű ����
	public User checkUserWithSessionKey(String value) throws Exception;
	
}
