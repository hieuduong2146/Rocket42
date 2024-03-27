package vn.edu.vinaenter.controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.Cmt;
import vn.edu.vinaenter.model.Contact;
import vn.edu.vinaenter.model.News;
import vn.edu.vinaenter.model.dao.CategoryDao;
import vn.edu.vinaenter.model.dao.CommentDAO;
import vn.edu.vinaenter.model.dao.ContactDao;
import vn.edu.vinaenter.model.dao.InforDAO;
import vn.edu.vinaenter.model.dao.NewsDAO;
import vn.edu.vinaenter.model.dao.ProjectDAO;
import vn.edu.vinaenter.model.dao.SkillDAO;
import vn.edu.vinaenter.model.dao.WayDAO;

@Controller

public class PublicController {
	@Autowired InforDAO inforDAO;
	@Autowired WayDAO wayDAO;
	@Autowired SkillDAO skillDAO;
	@Autowired ProjectDAO projectDAO;
	@Autowired NewsDAO newsDAO;
	@Autowired ContactDao contactDao;
	@Autowired CategoryDao categoryDao;
	@Autowired CommentDAO commentDAO;
	
	@Autowired
	ServletContext servletContext;
	@ModelAttribute
	void commonObject(ModelMap modelMap) {		
		modelMap.addAttribute("categories",categoryDao.getItems());
		modelMap.addAttribute("count",newsDAO.coutview());
	}
	@GetMapping("index")
	public String index(@RequestParam(required = false,name = "page") Integer page,ModelMap modelMap) {
		
		int numberOffitems = newsDAO.countItems();
		int numberOffpages =(int) Math.ceil(numberOffitems * 1.0 / Defines.ROW_COUNT);
		if(page == null) {
			page = 1;
		}else if(page < 0) {
			return "redirect:/index";
		}else if(page > numberOffpages ){
			return "redirect/index?page=2";
		}
		int offset = (page - 1) * Defines.ROW_COUNT ;
		List<News> news = newsDAO.getItemsPagination(offset);	
		modelMap.addAttribute("news",news);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("numberOffpages",numberOffpages);				
		modelMap.addAttribute("infor",inforDAO.getItems());
		modelMap.addAttribute("way",wayDAO.getItems());
		modelMap.addAttribute("skill",skillDAO.getitems());
		modelMap.addAttribute("project",projectDAO.getitems());
		return "aboutme.public.index";
	}
	
	@PostMapping("index")
	public String index(@Valid @ModelAttribute("contact") Contact contact,BindingResult rs,RedirectAttributes ra) {	
		if(rs.hasErrors()) {			
			return"aboutme.admin.cat.add";
		}		
		if(contactDao.add(contact) > 0 ) {
			System.out.println(contact.getName());
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			
			return "redirect:/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/index";
		}	
		
	}	
	
	@GetMapping("{newsname}-{id}.html")
	public String single(ModelMap modelMap,@PathVariable int id) {	
		if(newsDAO.countviews(id) > 0) {
			News newone = newsDAO.getItem(id);
			List<Cmt> cc = commentDAO.getItems(id);	
			List<News> news = newsDAO.getRelatedTiem(newone,3);		
			modelMap.addAttribute("newone",newone);
			modelMap.addAttribute("cc",cc);
			modelMap.addAttribute("news",news);
		
		}
		return "aboutme.public.single";
	}
	
	@GetMapping("danh-muc/{cname}-{id}")
	public String cat(ModelMap modelMap,@PathVariable int id) {		
		List<News> listCat = newsDAO.getitems(id);		
		modelMap.addAttribute("listCat",listCat);
		modelMap.addAttribute("catid",categoryDao.getItems(id));
		
		return "aboutme.public.cat";
	}	
	
	
	@PostMapping("xuly-comment")
	public String cmt(ModelMap modelMap,HttpServletRequest request,@RequestParam int idnews,@RequestParam String cmt) {		
	
		commentDAO.add(cmt,idnews);
		List<Cmt> cmtAll = commentDAO.getItems(idnews);
		modelMap.addAttribute("cc",cmtAll);
		return "public/cmt";
	}	
}
