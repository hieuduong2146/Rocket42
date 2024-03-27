package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CatDAO;
import model.dao.StrDAO;
import util.AuthUtil;

public class AdminDelCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private 	CatDAO catDAO;  
  	private 	StrDAO strDAO;
    public AdminDelCatController() {
        super();
        catDAO = new CatDAO();
        strDAO = new StrDAO();
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
		
		
		if(catDAO.delitems(id) > 0  ) {		
			if(strDAO.delitem(id) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/cats?msg=7");
				return;		
			}else {
				response.sendRedirect(request.getContextPath() + "/admin/cats?msg=7");
				return;		
			}
							
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=9");		
		}
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
