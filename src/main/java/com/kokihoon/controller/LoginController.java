package main.java.com.kokihoon.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import main.java.com.kokihoon.model.LoginDto;
import main.java.com.kokihoon.model.User;
import main.java.com.kokihoon.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method =RequestMethod.GET)
	public String loginGET(@ModelAttribute("loginDto") LoginDto loginDto) {
		return "/user/login";
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDto loginDto, HttpSession session, Model model) throws Exception {
		User user = service.login(loginDto);
		
		if(user == null) {
			return ;
		}
		
		model.addAttribute("user", user);
		
		// 로그인 유지를 선택할 경우
		if(loginDto.isUseCookie()) {
			int amount = 60*60*24*7; // 7일
			Date sessionLimit = new Date(System.currentTimeMillis() + (1000*amount));
			service.keepLogin(user.getUserId(), session.getId(), sessionLimit);
		}		
	}
	
	@RequestMapping(value="/logout", method= RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception{
		Object object = httpSession.getAttribute("login");

		if(object != null) {
			User user = (User)object;
			httpSession.removeAttribute("login");
			httpSession.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				loginCookie.setPath("/user/login");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(user.getUserId(), "none", new Date());
			}
		}
		
		return "/user/logout";
	}
}
