package com.ariftravelagency.userStatus;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {

	@GetMapping("/user-status")
	public String index() {
		return "userStatus/home";
	}
	
	@GetMapping("/user-status/create")
	public String createStatus() {
		return "userStatus/statusCreate";
	}

}

