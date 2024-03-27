package vn.edu.vinaenter.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.vinaenter.constant.Defines;
import vn.edu.vinaenter.model.Category;
import vn.edu.vinaenter.model.Land;
import vn.edu.vinaenter.model.Project;
import vn.edu.vinaenter.model.dao.ProjectDAO;
import vn.edu.vinaenter.util.FileNameUtil;

@Controller
@RequestMapping("admin/project")
public class AdminProjectController {
	@Autowired ProjectDAO projectDAO;
	@Autowired
	private  ServletContext servletContext;
	@GetMapping("index")	
	public String project(ModelMap modelMap) {
		List<Project> project = projectDAO.getitems();
		modelMap.addAttribute("project",project);
		return "aboutme.admin.project.index";
	}
	
	@GetMapping("add")	
	public String add(ModelMap modelMap) {
		
		return "aboutme.admin.project.add";
	}
	
	@PostMapping("add")
	public String add(@Valid @ModelAttribute("project") Project project,BindingResult rs,ModelMap modelMap,
			@RequestParam("image") CommonsMultipartFile cmf,RedirectAttributes ra) {		
		if(rs.hasErrors()) {			
			return"aboutme.admin.project.add";
		}
		
		String fileName = FileNameUtil.rename(cmf.getOriginalFilename());
		project.setPicture(fileName);
		
		if(projectDAO.add(project) > 0) {
			String dirPath = servletContext.getRealPath("")+ "WEB-INF" + java.io.File.separator + Defines.DIR_UPLOAD;
	
			java.io.File dir = new java.io.File(dirPath);
			if(!dir.exists()) {
				dir.mkdir();
			}
			String filePath = dirPath + java.io.File.separator + fileName ; 
			System.out.println(filePath);
			try {
				cmf.transferTo(new java.io.File(filePath));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			ra.addFlashAttribute("msg",Defines.MSG_ADD_SUCCESS);
			return "redirect:/admin/project/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/project/index";
		}									
	}
	
	@GetMapping("del/{id}")	
	public String del(@PathVariable int id,RedirectAttributes ra) {
		Project project = projectDAO.getItem(id);
		if(projectDAO.del(id) > 0 ) {
			
			java.io.File  file = new java.io.File(servletContext.getRealPath("")+ "WEB-INF" + 
			java.io.File.separator + Defines.DIR_UPLOAD + java.io.File.separator + project.getPicture());
			file.delete();
			ra.addFlashAttribute("msg",Defines.MSG_DELETE_SUCCES);			
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);			
		}
		return "redirect:/admin/project/index";
	}
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable int id,ModelMap modelMap) {
		Project project = projectDAO.getItem(id);
		modelMap.addAttribute("project", project);
		return "aboutme.admin.project.edit";
	}

	@PostMapping("edit/{id}")
	public String edit(@Valid @ModelAttribute("project") Project project ,BindingResult rs,ModelMap modelMap,
			@RequestParam("image") CommonsMultipartFile cmf ,RedirectAttributes ra) {	
			
		Project oldProject = projectDAO.getItem(project.getId());
		String filename= "";
		if("".equals(cmf.getOriginalFilename())) {
			project.setPicture(oldProject.getPicture());
		}else {
			filename = FileNameUtil.rename(cmf.getOriginalFilename());
			project.setPicture(filename);
		}
		
		if(rs.hasErrors()) {			
			project.setPicture(oldProject.getPicture());
			return "aboutme.admin.project.edit";
		}
		
		if(projectDAO.edit(project) > 0) {
			if(!"".equals(filename)) {
				String dirPath = servletContext.getRealPath("")+ "WEB-INF" + java.io.File.separator + Defines.DIR_UPLOAD;
				
				java.io.File dir = new java.io.File(dirPath);
				if(!dir.exists()) {
					dir.mkdir();
				}
				//xoa anh cu
				File oldFile = new File(dirPath + File.separator + oldProject.getPicture()); 
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
			return "redirect:/admin/project/index";
		}else {
			ra.addFlashAttribute("msg",Defines.MSG_ERROR);
			return "redirect:/admin/project/index";
		}	
	}
}
