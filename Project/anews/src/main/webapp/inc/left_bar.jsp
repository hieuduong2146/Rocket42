<%@page import="model.dao.CatDAO"%>
<%@page import="model.bean.DanhMucTin"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>Danh mục tin</h3>
<ul>
	<%
		CatDAO catDAO = new CatDAO();
		ArrayList<DanhMucTin> listDMT = catDAO.getItems();
		for(DanhMucTin obj : listDMT){
	%>
	<li><a href="<%=request.getContextPath() %>/danh-muc?cid=<%=obj.getIdDMT() %>" title=""><%=obj.getTenDMT() %></a></li>
	<%} %>
</ul>