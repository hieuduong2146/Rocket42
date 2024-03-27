package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DanhMucTin;
import model.bean.TinTuc;
import model.dao.CatDAO;
import model.dao.NewsDAO;


public class IndexCatPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexCatPublicController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatDAO catDAO = new CatDAO();
		NewsDAO newsDAO = new NewsDAO();
		int idDMT = Integer.parseInt(request.getParameter("cid"));		
		ArrayList<TinTuc> listTTByID = newsDAO.getItemsByID(idDMT);
		request.setAttribute("listTTByID", listTTByID);
		DanhMucTin objDMT = catDAO.getItem(idDMT); 
		request.setAttribute("objDMT", objDMT);
		RequestDispatcher rd = request.getRequestDispatcher("/cat.jsp");
		rd.forward(request, response);
	}

}
