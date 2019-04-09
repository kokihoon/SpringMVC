package main.java.com.kokihoon.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginAfterInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(LoginAfterInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		// �α��� ó���� �α��������� or ȸ������ �������� �̵��� ���
		HttpSession session = request.getSession();
		if(session.getAttribute("login") != null) {
			response.sendRedirect(request.getContextPath()+"/main");
			return false;
		}
		
		return true;
	}

}
