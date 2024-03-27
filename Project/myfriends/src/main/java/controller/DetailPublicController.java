package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ThongTinBanBe;
import model.dao.IFDao;

public class DetailPublicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DetailPublicController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		IFDao  ifDao = new IFDao();
		int did = Integer.parseInt(request.getParameter("did"));
		
		ArrayList<ThongTinBanBe> listCacnguoibankhac = ifDao.getlistCacnguoibankhac(ifDao.getDetails(did));
		request.setAttribute("objDT",  ifDao.getDetails(did));
		request.setAttribute("listfr", listCacnguoibankhac);
		RequestDispatcher rd = request.getRequestDispatcher("/chi-tiet.jsp");
		rd.forward(request, response);
	}
}