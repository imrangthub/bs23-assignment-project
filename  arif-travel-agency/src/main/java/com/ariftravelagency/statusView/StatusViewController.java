package com.ariftravelagency.statusView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StatusViewController {

	@Autowired
	private StatusViewService statusViewService;
	
	@GetMapping("/status-view")
	public String index(Model model) {
		model.addAttribute("statusList", statusViewService.getPublicStatusList());
		return "book/home";
	}

	@GetMapping("/status-view/list")
	public String list(Model model) {
		model.addAttribute("statusList", statusViewService.getPublicStatusList());
		return "book/home";
	}


	@GetMapping("/status-view/view/{id}")
	public String view(@PathVariable("id") long userId, Model model) {
		StatusViewEntity statusObj = null;
		try {
			statusObj = statusViewService.findById(userId);
		} catch (Exception ex) {
			model.addAttribute("errorMessage", "Status not found");
		}
		model.addAttribute("statusObj", statusObj);
		return "statusView/showStatus";
	}

	

}
