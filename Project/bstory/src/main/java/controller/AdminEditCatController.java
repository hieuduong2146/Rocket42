package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CatDAO;
import util.AuthUtil;

public class AdminEditCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private CatDAO   catDAO;
    public AdminEditCatController() {
        super();
        catDAO = new CatDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");				
			return;
		}
		
		int id = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/cats?msg=8");
			return;
		}		
		
		Category item = catDAO.getitemByid(id);
		if(item != null) {
			request.setAttribute("item", item);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/edit.jsp");			
			rd.forward(request, response);
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cats?msg=8");
			return;
		}
		
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");				
			return;
		}
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		
		int id = 0;
		
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/cats?msg=8");
			return;
		}		
		
		
		String name = request.getParameter("namecat");
		Category items = new Category(id, name);
		if(catDAO.editCat(items) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=5");
		
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cat/edit?err=6");
		}
	}

}
