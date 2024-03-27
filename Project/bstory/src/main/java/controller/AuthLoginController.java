package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDao;
import util.AuthUtil;
import util.StringUtil;


public class AuthLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDao userDao;  
    public AuthLoginController() {
        super();
        userDao = new UserDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/admin/index");				
			return;
		}	
		
		RequestDispatcher rd = request.getRequestDispatcher("/auth/login.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		User userlogin = (User)session.getAttribute("userlogin");
		
		if(userlogin != null) {
			response.sendRedirect(request.getContextPath() + "/admin");			
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		password = StringUtil.md5(password);
		
		User user = userDao.roleUser(username,password);						
			
		if(user != null) {
			session.setAttribute("userlogin", user);
			response.sendRedirect(request.getContextPath() + "/admin/index");	
			return;
		}else {
			response.sendRedirect(request.getContextPath() + "/login?err=1");
			return;
		}
	}

}
