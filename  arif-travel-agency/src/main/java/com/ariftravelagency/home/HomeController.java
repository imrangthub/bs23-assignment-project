package com.ariftravelagency.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ariftravelagency.statusView.StatusViewService;

@Controller
public class HomeController {

	@Autowired
	private StatusViewService statusViewService;

	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("statusList", statusViewService.getPublicStatusList());
		return "home";
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("statusList", statusViewService.getPublicStatusList());
		return "home";
	}

}
