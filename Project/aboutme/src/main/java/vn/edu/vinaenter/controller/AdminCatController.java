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
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.dao.CategoryDao;

@Controller
@RequestMapping("admin/cat")
public class AdminCatController {
	@Autowired CategoryDao categoryDao;
	
	@GetMapping("index")
	public String index(ModelMap modelMap) {	
		List<Category> categories = categoryDao.getItems();			
		modelMap.addAttribute("categories",categories);
		return"aboutme.admin.cat.index";
	}
	@GetMapping("add")
	public String add() {
		return"aboutme.admin.cat.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("category") Category category,BindingResult rs,RedirectAttributes ra) {	
		if(rs.hasErrors()) {
			
			return"aboutme.admin.cat.add";
		}
		
		if(categoryDao.add(category) > 0 ) {
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			
			return "redirect:/admin/cat/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}	
		
	}
	@GetMapping("del/{id}")
	public String del(@PathVariable int id,RedirectAttributes ra) {
		if(categoryDao.delete(id) > 0) {
//			if(landDAO.del(id) > 0) {
//				ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
//				return "redirect:/admin/cat/index";
//			}			
				ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
				return "redirect:/admin/cat/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}	
	}
	
	@GetMapping("edit/{cid}")
	public String edit(@PathVariable int cid, ModelMap modelMap ) {
		Category  category = categoryDao.getItems(cid);
		modelMap.addAttribute("category",category);
		return"aboutme.admin.cat.edit";
	}
	
	@PostMapping("edit/{cid}")
		public String edit(@Valid @ModelAttribute("category") Category category,BindingResult rs,RedirectAttributes ra) {
		if(rs.hasErrors()) {
			return "aboutme.admin.cat.edit";
		}
		if(categoryDao.edit(category)> 0) {			
			ra.addFlashAttribute("msg",Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/cat/index";
		}else {			
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/cat/index";
		}
	}
}
