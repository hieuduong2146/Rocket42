package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Stories;
import model.dao.StrDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexStrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private StrDAO  strDAO;
    
    public AdminIndexStrController() {
        super();
        strDAO = new StrDAO();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");				
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		int numberOfitems = strDAO.numberOfitems();
		int numberOfPages = (int)Math.ceil((float)numberOfitems / DefineUtil.NUMBER_PER_PAGE);
		
		int currentPages = 1;
				try {
					currentPages = Integer.parseInt(request.getParameter("page"));   
				} catch (NumberFormatException e) {
				}
				if(currentPages > numberOfPages || currentPages < 0 ) {
					currentPages = 1;
				}
				
				int offset = (currentPages - 1 ) * DefineUtil.NUMBER_PER_PAGE;
				
				
		ArrayList<Stories> str = strDAO.getitems(offset);
		
	
		request.setAttribute("str", str);
		
		request.setAttribute("numberOfPages", numberOfPages);				
		request.setAttribute("currentPages", currentPages);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/str/index.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
