package vn.edu.vinaenter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("auth")
public class AuthController {
	
	@Autowired
	private BCryptPasswordEncoder bCript;
	
	@GetMapping("login")
	public String login(HttpServletRequest request) {
		
		return	"auth/login";
	}
	
	@PostMapping("login")
	public String login(ModelMap modelMap) {
		
		return	"auth/login";
	}
	
	@ResponseBody	
	@GetMapping("mahoa")
	public String mahoa() {
		String pass = bCript.encode("123456");
		return pass;
	}
}
