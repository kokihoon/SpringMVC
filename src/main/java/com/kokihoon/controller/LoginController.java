package main.java.com.kokihoon.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.com.kokihoon.model.User;
import main.java.com.kokihoon.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login", method =RequestMethod.GET)
	public String loginGET(@ModelAttribute("user") User user) {
		return "/user/login";
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(User user, HttpSession session, Model model) throws Exception {
		User vo = service.login(user);
		if(vo == null) {
			return ;
		}
		model.addAttribute("user", vo);
	}
}
