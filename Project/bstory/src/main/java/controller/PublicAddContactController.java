package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDao;


public class PublicAddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private ContactDao contactDao;  
    
    public PublicAddContactController() {
        super();
       contactDao = new ContactDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/public/contact.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String website = request.getParameter("website");
		String message = request.getParameter("message");
		Contact contact = new Contact(0, name, email, website, message);
		if(contactDao.addcontact(contact)> 0) {
			response.sendRedirect(request.getContextPath() + "/public/contact.jsp?msg=1");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/public/contact.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
