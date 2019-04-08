package main.java.com.kokihoon.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
		User vo = service.login(loginDto);

		if(vo == null || !BCrypt.checkpw(loginDto.getUserPw(), vo.getUserPw())) {
			System.out.println("tlqkf");
			return ;
		}
		
		model.addAttribute("user", vo);
		
	}
}
