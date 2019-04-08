package main.java.com.kokihoon.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import main.java.com.kokihoon.model.User;
import main.java.com.kokihoon.service.LoginService;
import main.java.com.kokihoon.service.RegisterService;

@Controller
@RequestMapping("/user")
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	// 회원가입 페이지
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String registerGET() throws Exception{
		return "/user/register";
	}
	
	// 회원가입 처리
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(User user, RedirectAttributes redirectAttributes) throws Exception {
		String hashedPw = BCrypt.hashpw(user.getUserPw(), BCrypt.gensalt());
		user.setUserPw(hashedPw);
		registerService.register(user);
		redirectAttributes.addFlashAttribute("msg", "REGISTERED");
		
		return "redirect:/user/login";
	}
}
