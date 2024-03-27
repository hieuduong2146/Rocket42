package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserDao;
import util.AuthUtil;
import util.StringUtil;

public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDao userDao;
    public AdminEditUserController() {
        super();
        userDao = new UserDao();
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
			response.sendRedirect(request.getContextPath()+"/admin/user?msg=7");
			return;
		}
		User user = userDao.editByid(id);
		if(user != null ) {
			request.setAttribute("user", user);	
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/user?msg=7");
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
			response.sendRedirect(request.getContextPath()+"/admin/user?msg=7");
			return;
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		User user = userDao.editByid(id);
		if("".equals(password)) {
			password = user.getPassword();
		}else {
			password = StringUtil.md5(password);
		}
		String fullname = request.getParameter("fullname");
		
		User objus = new User(id, username, password, fullname,role);
	
		if (userDao.editus(objus) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/user?msg=2");
			return;
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
