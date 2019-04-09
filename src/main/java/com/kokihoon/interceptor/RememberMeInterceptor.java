package main.java.com.kokihoon.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import main.java.com.kokihoon.model.User;
import main.java.com.kokihoon.service.LoginService;

public class RememberMeInterceptor extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(RememberMeInterceptor.class);
	
	@Inject
	private LoginService loginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession httpSession = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			User user = loginService.checkLoginBefore(loginCookie.getValue());
			if(user != null) {
				httpSession.setAttribute("login", user);
			}
		}
		
		return true;
	}
}
