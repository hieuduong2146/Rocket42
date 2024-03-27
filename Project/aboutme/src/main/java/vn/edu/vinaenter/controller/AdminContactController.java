package vn.edu.vinaenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Contact;
import vn.edu.vinaenter.model.dao.ContactDao;

@Controller
public class AdminContactController {
	@Autowired ContactDao contactDao;
	
	
	@GetMapping("admin/contact/index")	
	public String contact(ModelMap modelMap){
		List<Contact> contact = contactDao.Find_ALL();
		modelMap.addAttribute("contact",contact);
		
		return "aboutme.admin.contact.index";
	}
	
	
	
	@GetMapping("admin/contact/del/{id}")
	public String del(@PathVariable int id,RedirectAttributes ra) {
		
		if(contactDao.del(id) > 0) {
			ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
			return "redirect:/admin/contact/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/contact/index";
		}
		
	}
}
