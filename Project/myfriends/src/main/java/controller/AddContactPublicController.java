package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.AddContact;
import model.dao.IFDao;

public class AddContactPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddContactPublicController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String email = request.getParameter("email");
		int phone = Integer.parseInt(request.getParameter("Phone"));
		String conten = "abc";
		AddContact addContact = new AddContact(0, name, email, phone, conten);
		IFDao ifDao = new  IFDao();
		if(ifDao.additem(addContact) > 0) {
			request.setAttribute("msg", "Them thanh cong");
			RequestDispatcher rd = request.getRequestDispatcher("/lien-he.jsp");
			rd.forward(request, response);	
		}else {
			request.setAttribute("msg", "Them that bai");
			RequestDispatcher rd = request.getRequestDispatcher("/lien-he.jsp");
			rd.forward(request, response);	
		}
		
	}

}
