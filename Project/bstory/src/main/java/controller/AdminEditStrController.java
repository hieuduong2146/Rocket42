package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Stories;
import model.dao.CatDAO;
import model.dao.StrDAO;
import util.AuthUtil;
import util.FileUtil;

@MultipartConfig
public class AdminEditStrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CatDAO catDAO;  
    private StrDAO strDAO;
    public AdminEditStrController() {
        super();
        catDAO = new CatDAO();
        strDAO = new StrDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");				
			return;
		}
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/edit.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		Stories stories = strDAO.getitem(id);
		if(stories == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/edit.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		
		
		ArrayList<Category> list = catDAO.getitems();
		request.setAttribute("categories", list);
		request.setAttribute("str", stories);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/str/edit.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");				
			return;
		}
		request.setCharacterEncoding("UTF-8");	
		
		
		int catID = 0;
		int id = 0;
		try {
			
			catID = Integer.parseInt(request.getParameter("category"));
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/add.jsp?err=1");
			rd.forward(request, response);
		}
		String name = request.getParameter("tentruyen");
		String priviewText = request.getParameter("mota");
		String detailText = request.getParameter("chitiet");
		Timestamp dateCreate = new Timestamp(new Date().getTime());
		
		Stories stories = strDAO.getitem(id);
		if(stories == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/edit.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		
		
		Part filePart = request.getPart("hinhanh");		
		final String dirPathName = request.getServletContext().getRealPath("/files");
		
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}	
		
		String fileName = FileUtil.getName(filePart);
		String picture = "";
		if(fileName.isEmpty()) {
			picture = stories.getPicture();
		}else{
			 picture = FileUtil.rename(fileName);
		}
		String filePathName = dirPathName+File.separator+picture;
				
		Category category = new Category(1, null);
		Stories item = new Stories(id, name, priviewText,detailText, null, picture, 0, category);
		
		
		if(strDAO.edit(item) > 0 ) {						
			if(!fileName.isEmpty()) {
				String oldFileNPathame = dirPathName + File.separator+stories.getPicture();
				File oldFile = new File(oldFileNPathame);				
				if(oldFile.exists()){
					oldFile.delete();
				}
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath() + "/admin/str?msg=2");
			return;
		}else {
			ArrayList<Category> list = catDAO.getitems();
			request.setAttribute("categories", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/edit.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
