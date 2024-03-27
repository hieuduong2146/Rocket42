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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Stories;
import model.bean.User;
import model.dao.CatDAO;
import model.dao.StrDAO;
import util.AuthUtil;
import util.FileUtil;

@MultipartConfig
public class AdminAddStrController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CatDAO catDAO;  
    private StrDAO strDAO;
    public AdminAddStrController() {
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
		
		ArrayList<Category> list = catDAO.getitems();
		request.setAttribute("categories", list);

		RequestDispatcher rd = request.getRequestDispatcher("/admin/str/add.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath() + "/login");				
			return;
		}
		request.setCharacterEncoding("UTF-8");	
		HttpSession session = request.getSession();
		User userlogin = (User)session.getAttribute("userlogin");
		
		int catID = 0;
		try {
			catID = Integer.parseInt(request.getParameter("category"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/add.jsp?err=1");
			rd.forward(request, response);
		}
		String name = request.getParameter("tentruyen");
		String priviewText = request.getParameter("mota");
		String detailText = request.getParameter("chitiet");
		Timestamp dateCreate = new Timestamp(new Date().getTime());
		
		Part filePart = request.getPart("hinhanh");		
		final String dirPathName = request.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()) {
			dirFile.mkdirs();
		}		
		String fileName = FileUtil.getName(filePart);
		String picture = FileUtil.rename(fileName);
		String filePathName = dirPathName+File.separator+picture;
		Category category = new Category(catID, null);
		Stories item = new Stories(0, name, priviewText,detailText, dateCreate, picture, 0, category,userlogin.getId());
		if(strDAO.addItem(item) > 0 ) {
			
			
			if(!fileName.isEmpty()) {
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath() + "/admin/str?msg=1");
			return;
		}else {
			ArrayList<Category> list = catDAO.getitems();
			request.setAttribute("categories", list);
			
			RequestDispatcher rd = request.getRequestDispatcher("/admin/str/add.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
