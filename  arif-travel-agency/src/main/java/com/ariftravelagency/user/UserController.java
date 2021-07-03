package com.ariftravelagency.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/user/home")
	public String index(Model model) {
		model.addAttribute("userStatusList", userService.statusListByUserId());
		return "user/home";
	}

	@GetMapping("/user/status/create")
	public String userStatus(Model model) {
		UserEntity obj = new UserEntity();
		model.addAttribute("userObj", obj);
		return "user/userCreate";
	}

	@GetMapping("/user/create")
	public String create(Model model) {
		UserEntity obj = new UserEntity();
		model.addAttribute("userObj", obj);
		return "user/userCreate";
	}

	@PostMapping("/user/save")
	public String saveuser(UserEntity userObj, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/userCreate";
		}
		userService.userSave(userObj);
		return "redirect:/user/home";
	}


	@GetMapping("/user/edit/{id}")
	public String eidt(Model model, @PathVariable("id") Long userId) {
		model.addAttribute("userObj", userService.findById(userId));
		return "user/userEdit";
	}

	@PostMapping("/user/update")
	public String updateuser(Model model, UserEntity userObj, BindingResult result) {
		if (!result.hasErrors()) {
			userService.userUpdate(userObj);
		}
		return "redirect:/user/home";
	}



}
