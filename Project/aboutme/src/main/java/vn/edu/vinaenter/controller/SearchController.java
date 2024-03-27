package vn.edu.vinaenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.edu.vinaenter.model.News;
import vn.edu.vinaenter.model.dao.NewsDAO;

@Controller
public class SearchController {
	@Autowired NewsDAO newsDAO;
		@GetMapping("admin/news/search")
		public String search(@RequestParam String search,ModelMap modelMap) {
			System.out.println(search);
			List<News> searchNews = newsDAO.getitems(search);
			modelMap.addAttribute("searchNews",searchNews);
			return "aboutme.admin.news.search";
		}
}
