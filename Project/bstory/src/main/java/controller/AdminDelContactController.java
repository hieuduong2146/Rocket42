package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ContactDao;


public class AdminDelContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDao   contactDao;
    
   
    public AdminDelContactController() {
        super();
      contactDao = new ContactDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0 ;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			response.sendRedirect(request.getContextPath() + "/admin/contact?msg=7");
		}
		if ( contactDao.delcontact(id) > 0) {
			response.sendRedirect(request.getContextPath() + "/admin/contact?msg=5");
		}else {
			response.sendRedirect(request.getContextPath() + "/admin/contact?msg=6");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
