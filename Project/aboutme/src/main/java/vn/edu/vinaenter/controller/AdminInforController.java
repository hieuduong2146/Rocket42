package vn.edu.vinaenter.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Infor;
import vn.edu.vinaenter.model.Skill;
import vn.edu.vinaenter.model.dao.InforDAO;

@Controller
@RequestMapping("admin/infor")
public class AdminInforController {
	
	
	@Autowired InforDAO inforDAO ;
	@GetMapping("index")
	public String infor(ModelMap modelMap) {
		List<Infor> infor = inforDAO.getItems();
		modelMap.addAttribute("infor",infor);
		return "aboutme.admin.infor.index";
	}
	
	@GetMapping("add")
	public String add() {
		return"aboutme.admin.infor.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("infor") Infor infor,BindingResult rs,RedirectAttributes ra) {	
		if(rs.hasErrors()) {
			
			return"aboutme.admin.infor.add";
		}
		
		if(inforDAO.add(infor) > 0 ) {
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			
			return "redirect:/admin/infor/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/infor/index";
		}	
		
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable int id,RedirectAttributes ra) {
		if(inforDAO.delete(id) > 0) {				
				ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
				return "redirect:/admin/infor/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/infor/index";
		}	
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap ) {
		Infor infor = inforDAO.getItem(id);		
		modelMap.addAttribute("infor",infor);
		return"aboutme.admin.infor.edit";
	}
	
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("skill") Infor infor,BindingResult rs,RedirectAttributes ra) {
	
	if(rs.hasErrors()) {
		return "aboutme.admin.infor.edit";
	}
	if(inforDAO.edit(infor)> 0) {			
		ra.addFlashAttribute("msg",Defines.MSG_UPDATE_SUCCESS);
		return "redirect:/admin/infor/index";
	}else {			
		ra.addFlashAttribute("msg",Defines.MSG_ERROR);
		return "redirect:/admin/infor/index";
	}
}
}
