package com.ariftravelagency.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ariftravelagency.location.LocationEntity;
import com.ariftravelagency.location.LocationService;
import com.ariftravelagency.statusView.StatusViewEntity;
import com.ariftravelagency.statusView.StatusViewService;

@Controller
public class StatusController {

	@Autowired
	private StatusService statusService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private StatusViewService statusViewService;

	@GetMapping("/status/create")
	public String create(Model model) {
		StatusEntity obj = new StatusEntity();
		List<LocationEntity> locationList = locationService.list();
		model.addAttribute("statusObj", obj);
		model.addAttribute("locationList", locationList);
		return "status/statusCreate";
	}

	@PostMapping("/status/save")
	public String savestatus(StatusEntity statusObj, Model model) {
		statusService.statusSave(statusObj);
		return "redirect:/user/home";
	}

	@GetMapping("/status/view/{id}")
	public String view(@PathVariable("id") long statusId, Model model) {
		StatusViewEntity statusObj = null;
		try {
			statusObj = statusViewService.findById(statusId);
		} catch (Exception ex) {
			model.addAttribute("errorMessage", "status not found");
		}
		model.addAttribute("statusObj", statusObj);
		return "status/statusView";
	}

	@GetMapping("/status/edit/{id}")
	public String eidt(Model model, @PathVariable("id") Long statusId) {
		List<LocationEntity> locationList = locationService.list();
		model.addAttribute("statusObj", statusService.findById(statusId));
		model.addAttribute("locationList", locationList);
		return "status/statusEdit";
	}

	@PostMapping("/status/update")
	public String updatestatus(Model model, StatusEntity statusObj) {
		statusService.statusUpdate(statusObj);
		return "redirect:/user/home";
	}

	@GetMapping("/status/delete/{id}")
	public String statusDelete(Model model, @PathVariable("id") Long id) {
		statusService.delete(id);
		return "redirect:/user/home";
	}

}
