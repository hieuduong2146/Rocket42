package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DanhMucBanBe;
import model.bean.ThongTinBanBe;
import model.dao.CatDao;
import model.dao.IFDao;

public class InforPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InforPublicController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		IFDao ifdao = new IFDao();
		CatDao catDao = new CatDao();
		int ifid = Integer.parseInt(request.getParameter("ifid"));
		DanhMucBanBe cat = catDao.getitem(ifid);
		request.setAttribute("ifid", ifdao.getItemByIds(ifid)); 
		request.setAttribute("obj", cat);
		RequestDispatcher rd = request.getRequestDispatcher("/danh-muc.jsp");
		rd.forward(request, response);
	}

}
