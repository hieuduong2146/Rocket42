package vn.edu.vinaenter.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.News;
import vn.edu.vinaenter.model.dao.CategoryDao;
import vn.edu.vinaenter.model.dao.NewsDAO;
import vn.edu.vinaenter.util.FileNameUtil;

@Controller
@RequestMapping("admin/news")
public class AdminNewsController {
	@Autowired NewsDAO newsDAO;
	@Autowired CategoryDao categoryDao;
	@Autowired
	private  ServletContext servletContext;
	@GetMapping("index")	
	public String news(@RequestParam(required = false,name = "page") Integer page,ModelMap modelMap) {
		
		int numberOffitems = newsDAO.countItems();
		int numberOffpages =(int) Math.ceil(numberOffitems * 1.0 / Defines.ROW_COUNT)
				;
		if(page == null) {
			page = 1;
		}else if(page < 0) {
			return "redirect:/admin/index";
		}else if(page > numberOffpages ){
			return "redirect:/admin/index?page=2";
		}
		int offset = (page - 1) * Defines.ROW_COUNT ;
		List<News> news = newsDAO.getItemsPagination(offset);		
		modelMap.addAttribute("news",news);
		modelMap.addAttribute("page",page);
		modelMap.addAttribute("numberOffpages",numberOffpages);
		return "aboutme.admin.news.index";
	}
	
	@GetMapping("add")	
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("cat",categoryDao.getItems());
		return "aboutme.admin.news.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("news") News news ,BindingResult rs,ModelMap modelMap,@RequestParam("cid") int cid,
			@RequestParam("image") CommonsMultipartFile cmf ,RedirectAttributes ra) {			
		news.setCategory(new Category(cid,null));			
		if(rs.hasErrors()) {
			modelMap.addAttribute("cat",categoryDao.getItems());
			return "aboutme.admin.news.add";
		}
		String fileName = FileNameUtil.rename(cmf.getOriginalFilename());
		news.setPicture(fileName);
		
		if(newsDAO.add(news) > 0) {
			String dirPath = servletContext.getRealPath("")+ "WEB-INF" + java.io.File.separator + Defines.DIR_UPLOAD;
			System.out.println();
			java.io.File dir = new java.io.File(dirPath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			String filePath = dirPath + java.io.File.separator + fileName ; 
			try {
				cmf.transferTo(new java.io.File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/news/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/news/index";
		}						
	}
	
	@GetMapping("del/{id}")	
	public String del(@PathVariable int id,RedirectAttributes ra) {
		News news = newsDAO.getItem(id);
		if(newsDAO.del(id) > 0 ) {			
			java.io.File  file = new java.io.File(servletContext.getRealPath("")+ "WEB-INF" + 
			java.io.File.separator + Defines.DIR_UPLOAD + java.io.File.separator + news.getPicture());
			file.delete();
			ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);			
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);			
		}
		return "redirect:/admin/news/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id,ModelMap modelMap) {
		News news = newsDAO.getItem(id);
		modelMap.addAttribute("news", news);
		modelMap.addAttribute("cat",categoryDao.getItems());
		return "aboutme.admin.news.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("news") News news ,BindingResult rs,ModelMap modelMap,@RequestParam("cid") int id,
			@RequestParam("image") CommonsMultipartFile cmf ,RedirectAttributes ra) {	
		news.setCategory(new Category(id,null));	
		News oldNews = newsDAO.getItem(news.getId());
		String filename= "";
		if("".equals(cmf.getOriginalFilename())) {
			news.setPicture(oldNews.getPicture());
		}else {
			filename = FileNameUtil.rename(cmf.getOriginalFilename());
			news.setPicture(filename);
		}
		
		if(rs.hasErrors()) {			
			news.setPicture(oldNews.getPicture());
			return "aboutme.admin.news.edit";
		}
		
		if(newsDAO.edit(news) > 0) {
			if(!"".equals(filename)) {
				String dirPath = servletContext.getRealPath("")+ "WEB-INF" + java.io.File.separator + Defines.DIR_UPLOAD;
				
				java.io.File dir = new java.io.File(dirPath);
				if(!dir.exists()) {
					dir.mkdir();
				}
				//xoa anh cu
				File oldFile = new File(dirPath + File.separator + oldNews.getPicture()); 
				oldFile.delete();
				try {
					cmf.transferTo(new File(dirPath + File.separator+filename));
				} catch (IllegalStateException e) {					
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			ra.addFlashAttribute("msg",Defines.MSG_UPDATE_SUCCESS);
			return "redirect:/admin/news/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/news/index";
		}	
				
	}
	@ResponseBody
	@PostMapping("xulystt")
	public String stt(ModelMap modelMap,@RequestParam int aid,@RequestParam int stt, HttpServletRequest request) {
	
		if (stt == 0) {
			newsDAO.editstt1(1,aid);
		}else {
			newsDAO.editstt0(0,aid);
		}
		
		int stt1 = newsDAO.getstt(aid);
		
		if(stt1 == 1) {
			return "<a href = \"javascript:void(0)\" onclick=\"return getStatus(" + aid + ","+stt1+")\"><img src=\""+request.getContextPath()+"/adminUrl/images/xanh.png\"></a>";
		}else {
			return "<a href = \"javascript:void(0)\" onclick=\"return getStatus("+aid+","+stt1+")\"><img src=\""+request.getContextPath()+"/adminUrl/images/do.png\"></a>";

		}
	}
}
