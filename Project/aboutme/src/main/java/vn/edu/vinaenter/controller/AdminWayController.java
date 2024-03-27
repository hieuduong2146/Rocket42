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
import vn.edu.vinaenter.model.Skill;
import vn.edu.vinaenter.model.Way;
import vn.edu.vinaenter.model.dao.WayDAO;

@Controller
@RequestMapping("admin/way")
public class AdminWayController {
	@Autowired WayDAO wayDAO;
	
	@GetMapping("index")
	public String way(ModelMap modelMap) {
		List<Way> way = wayDAO.getItems();
		modelMap.addAttribute("way",way);
		return "aboutme.admin.way.index";
	}
	
	@GetMapping("add")
	public String add() {
		return"aboutme.admin.way.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("way") Way way,BindingResult rs,RedirectAttributes ra) {	
		if(rs.hasErrors()) {
			
			return"aboutme.admin.way.add";
		}
		
		if(wayDAO.add(way) > 0 ) {
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			
			return "redirect:/admin/way/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/way/index";
		}	
		
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable int id,RedirectAttributes ra) {
		if(wayDAO.delete(id) > 0) {				
				ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
				return "redirect:/admin/way/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/way/index";
		}	
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap ) {
		Way way = wayDAO.getItems(id);
		modelMap.addAttribute("way",way);
		return"aboutme.admin.way.edit";
	}
	
	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("way") Way way,BindingResult rs,RedirectAttributes ra) {
	
	if(rs.hasErrors()) {
		return "aboutme.admin.way.edit";
	}
	if(wayDAO.edit(way)> 0) {			
		ra.addFlashAttribute("msg",Defines.MSG_UPDATE_SUCCESS);
		return "redirect:/admin/way/index";
	}else {			
		ra.addFlashAttribute("msg",Defines.MSG_ERROR);
		return "redirect:/admin/way/index";
	}
}
}
