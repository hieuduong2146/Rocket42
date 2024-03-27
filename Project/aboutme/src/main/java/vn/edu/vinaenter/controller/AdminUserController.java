package vn.edu.vinaenter.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Role;
import vn.edu.vinaenter.model.User;
import vn.edu.vinaenter.model.dao.RoleDao;
import vn.edu.vinaenter.model.dao.UserDao;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {
	@Autowired
	private UserDao userDao;
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder bcipt;

	@GetMapping("index")
	public String index(ModelMap modelMap) {
		List<User> user = userDao.getItems();
		modelMap.addAttribute("user", user);
		return "aboutme.admin.user.index";
	}

	@GetMapping("add")
	public String add(ModelMap modelMap) {
		List<vn.edu.vinaenter.model.Role> roles = roleDao.getItems();
		modelMap.addAttribute("roles", roles);

		return "aboutme.admin.user.add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("user") User user, BindingResult rs, @RequestParam("roleid") int roleid,
			RedirectAttributes rd, ModelMap modelMap) {
		
		user.setRole(new vn.edu.vinaenter.model.Role(roleid, null));
		
		if (userDao.hasUser(user.getUsername()) > 0 ) {
			rd.addFlashAttribute("msg",Defines.MSG_USERNAME_ERROR);
			return "redirect:/admin/user/add";
		}
		
		user.setPassword(bcipt.encode(user.getPassword()));
		if (rs.hasErrors()) {
			modelMap.addAttribute("roles", roleDao.getItems());
			return "aboutme.admin.user.add";
		}
		
		if (userDao.add(user) > 0) {
			rd.addFlashAttribute("msg", Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/user/index";
		} else {
			rd.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/user/index";

		}
	}

	@GetMapping("del/{id}")
	public String del(@PathVariable int id,RedirectAttributes rd,Principal principal) {
		
		User user = userDao.getItem(id);
		if(user.getRole().getName().equals("ADMIN") && user.getUsername().equals(principal.getName())) {
			rd.addAttribute("msg", "Không Được Xóa!!");
			return "redirect:/admin/user/index";
		}
		
		if(userDao.delete(id) > 0) {
			rd.addAttribute("msg", Defines.MSG_DELETE_SUCCES);
			return "redirect:/admin/user/index";	
		}else {
			rd.addAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/user/index";
		}
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id,ModelMap modelMap) {
		User user = userDao.getItem(id);
		modelMap.addAttribute("user",user);
		modelMap.addAttribute("roles", roleDao.getItems());
		return "aboutme.admin.user.edit";
	}
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("user") User user,BindingResult rs,@RequestParam("roleid") int roleid,
			RedirectAttributes rd, ModelMap modelMap) {
		user.setRole(new Role(roleid, null));
		User oldUser = userDao.getItem(user.getId());
		
		if("".equals(user.getPassword())) {
			user.setPassword(oldUser.getPassword());
		}
		if (rs.hasErrors()) {
			modelMap.addAttribute("roles", roleDao.getItems());
			return "aboutme.admin.user.edit";
		}
		user.setPassword(bcipt.encode(user.getPassword()));
		if (userDao.edit(user) > 0) {
			rd.addFlashAttribute("msg", Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/user/index";
		} else {
			rd.addFlashAttribute("msg", Defines.MSG_ERROR);
			return "redirect:/admin/user/index";

		}
	}
	
	@GetMapping("profile")
	public String profile(ModelMap modelMap,Principal principal) {
		String username = principal.getName();
		User user = userDao.getItemByUsername(username);
		modelMap.addAttribute("user",user);
		modelMap.addAttribute("roles", roleDao.getItems());
		return "aboutme.admin.user.profile";
	}
			
	@PostMapping("profile/{id}")
	public String profile(@Valid @ModelAttribute("user") User user,BindingResult rs,@RequestParam("roleid") int roleid,
			RedirectAttributes rd, ModelMap modelMap) {
		user.setRole(new Role(roleid, null));
		User oldUser = userDao.getItem(user.getId());
	
		if("".equals(user.getPassword())) {
			user.setPassword(oldUser.getPassword());
		}
		if (rs.hasErrors()) {
			modelMap.addAttribute("roles", roleDao.getItems());
			return "cland.admin.user.profile";
		}
		user.setPassword(bcipt.encode(user.getPassword()));
		if (userDao.edit(user) > 0) {
			rd.addFlashAttribute("msg", "Thay đổi thông tin thành công");
			return "redirect:/admincp";
		} else {
			rd.addFlashAttribute("msg", "Thay đổi thông tin thất bại !!");
			return "redirect:/admincp";

		}
	}
}
