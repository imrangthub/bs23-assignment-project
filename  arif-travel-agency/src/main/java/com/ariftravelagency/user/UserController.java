package com.ariftravelagency.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user")
	public String index(Model model) {
		return "user/home";
	}
	
	@GetMapping("/user/create")
	public String registration(Model model) {
		return "user/userCreate";
	}

}
