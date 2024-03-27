package vn.edu.vinaenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Cmt;
import vn.edu.vinaenter.model.dao.CommentDAO;

@Controller
@RequestMapping("admin/cmt")
public class AdminCmtController {
	@Autowired CommentDAO commentDAO;
	@GetMapping("index")
	public String index(@RequestParam(required = false,name = "page") Integer page,ModelMap modelMap ) {
		
		int numberOffitems = commentDAO.countItems();
		int numberOffpages =(int) Math.ceil(numberOffitems * 1.0 / Defines.ROW_COUNT_CMT);
		if(page == null) {
			page = 1;
		}else if(page < 0) {
			return "redirect:/admin/index";
		}else if(page > numberOffpages ){
			return "redirect:/admin/index?page=2";
		}
		
		int offset = (page - 1) * Defines.ROW_COUNT_CMT ;
		List<Cmt> cmt = commentDAO. getItemsPagination(offset);	
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("numberOffpages",numberOffpages);
		modelMap.addAttribute("cmt",cmt);
		return "aboutme.admin.comment.index" ;
	}
	
	@GetMapping("del/{id}")
	public String del(@PathVariable int id,RedirectAttributes ra) {
		if(commentDAO.edit(id) > 0){
			ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);
			return "redirect:/admin/cmt/index";
		}
		ra.addFlashAttribute("msg",Defines.MSG_ERROR);
		return "redirect:/admin/cmt/index";
		
	}
}
