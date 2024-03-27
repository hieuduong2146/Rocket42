package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Stories;
import model.dao.CatDAO;
import model.dao.StrDAO;
import util.DefineUtil;


public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CatDAO catDAO; 
    private StrDAO strDAO;
    public PublicCatController() {
        super();
        catDAO = new CatDAO();
        strDAO = new StrDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = 0;
	
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/public/404.jsp");
			return;
		}
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
					
		} catch (Exception e) {
			currentPage = 1;
		}
		
	
		int numberOfItem  = strDAO.getnumberGetItem(id);	//so tin
		
		int numberOfPage = (int)Math.ceil((float)numberOfItem / DefineUtil.NUMBER_PER_PAGE);//so trang
		
		if(currentPage > numberOfPage || currentPage < 1 ) {
			 currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		Category category =  catDAO.getitemByid(id);
		if(category == null  ) {
			response.sendRedirect(request.getContextPath() + "/404");
			return;	
		}
		ArrayList<Stories> str = strDAO.getitemsByCategoryPagenation(offset,id);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("category", category);
		request.setAttribute("str", str);
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/cat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
