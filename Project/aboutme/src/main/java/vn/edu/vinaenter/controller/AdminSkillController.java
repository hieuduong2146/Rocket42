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
import vn.edu.vinaenter.model.dao.SkillDAO;
@RequestMapping("admin/skill")
@Controller
public class AdminSkillController {
	@Autowired 
	SkillDAO skillDAO;
	
	@GetMapping("index")
	public String skill(ModelMap modelMap) {
		List<Skill>skill = skillDAO.getitems();
		modelMap.addAttribute("skill",skill);
		
		return "aboutme.admin.skill.index";
	}
	
	@GetMapping("add")
	public String add() {
		return"aboutme.admin.skill.add";
	}
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("skill") Skill skill,BindingResult rs,RedirectAttributes ra) {	
		if(rs.hasErrors()) {
			
			return"aboutme.admin.skill.add";
		}
		
		if(skillDAO.add(skill) > 0 ) {
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			
			return "redirect:/admin/skill/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/skill/index";
		}	
		
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable int id,RedirectAttributes ra) {
		if(skillDAO.delete(id) > 0) {				
				ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
				return "redirect:/admin/skill/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/skill/index";
		}	
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id, ModelMap modelMap ) {
		Skill skill = skillDAO.getItems(id);
		modelMap.addAttribute("skill",skill);
		return"aboutme.admin.skill.edit";
	}
	
	@PostMapping("edit/{id}")
		public String edit(@Valid @ModelAttribute("skill") Skill skill,BindingResult rs,RedirectAttributes ra) {
		System.out.println(skill.getValue());
		if(rs.hasErrors()) {
			return "aboutme.admin.skill.edit";
		}
		if(skillDAO.edit(skill)> 0) {			
			ra.addFlashAttribute("msg",Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/skill/index";
		}else {			
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/skill/index";
		}
	}
}
