package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Stories;
import model.dao.StrDAO;

public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private StrDAO strDAO ;   
   
    public PublicDetailController() {
        super();
        strDAO = new StrDAO();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/404");
			return;
		}
		
		
		Stories str  = strDAO.getitem(id);
		if(str == null) {
			response.sendRedirect(request.getContextPath() + "/404");
			return;
		}
		HttpSession session = request.getSession();
		String hasVisited = (String)session.getAttribute("hasVisited" + id);
		if(hasVisited == null) {
		session.setAttribute("hasVisited" + id, "yes");
		session.setMaxInactiveInterval(3600);
		strDAO.increaseview(id);
		}
		
		ArrayList<Stories> relatedStr = strDAO.relatedItem(str,2);
		
		request.setAttribute("str", str);
		request.setAttribute("relatedStr", relatedStr);
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/detail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
