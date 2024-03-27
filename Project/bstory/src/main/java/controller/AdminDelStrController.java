package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Stories;
import model.dao.StrDAO;
import util.AuthUtil;

public class AdminDelStrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private StrDAO strDAO; 
    public AdminDelStrController() {
        super();
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
			response.sendRedirect(request.getContextPath()+"/admin/str?err=1");
			return;
		}
		Stories stories = strDAO.getitem(id);
		if(stories == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str?err=1");
			rd.forward(request, response);
			return;
		}
		if(strDAO.delitem(id) > 0) {
			final String dirPathName = request.getServletContext().getRealPath("/files");
			String picture = stories.getPicture();
			if(!picture.isEmpty()) {
				String filePathName = dirPathName + File.separator + picture;
				 File file = new File(filePathName);
				 if(file.exists()) {
					 file.delete();
				
				 }
			}
			response.sendRedirect(request.getContextPath()+"/admin/str?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/str?err=2");
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
