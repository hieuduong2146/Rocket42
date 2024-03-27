package vn.edu.vinaenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminIndexController {
	
	@GetMapping("admincp")
	public String index() {
		return "aboutme.admin.index.index";
	}	
}
