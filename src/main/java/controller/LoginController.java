package main.java.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.model.User;
import main.java.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginForm() {
		return "/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginCheck(HttpSession session, User user) throws Exception {
		
		String returnURL ="";
		
		if(session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		
		User vo = service.getUser(user);
		
		if(vo != null) {
			session.setAttribute("login", vo);
			returnURL = "redirect:/main";
		} else {
			returnURL = "redirect:/login";
		}
		
		return returnURL;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/login";
	}
}
