<%@page import="util.StringUtil"%>
<%@page import="model.bean.Stories"%>
<%@page import="model.dao.StrDAO"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CatDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="gadget">
  <h2 class="star">Danh mục truyện</h2>
  <%
  	CatDAO catDAO = new CatDAO();
  	ArrayList<Category> categories = catDAO.getitems();
  	if(categories.size() > 0  ){
  		for(Category item : categories){
  %>
  <div class="clr"></div>
  <ul class="sb_menu">
    <li><a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(item.getName())%>-<%=item.getId()%>"><%=item.getName() %></a></li>
 
  </ul>
   <%}} %>
</div>

<div class="gadget">
  <h2 class="star"><span>Truyện mới</span></h2>
  <div class="clr"></div>
  <%
  	StrDAO strDAO = new StrDAO();
  	ArrayList<Stories> recentStr = strDAO.getItems(6);
  	if(recentStr.size() > 0  ){
  		for(Stories item : recentStr){
  %>
  <ul class="ex_menu">
    <li><a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(item.getCategory().getName())%>/<%=StringUtil.makeSlug(item.getName())%>-<%=item.getId() %>.html"><%=item.getName() %></a><br />
      <%if(item.getPreview_text().length() > 50)out.print(item.getPreview_text().substring(0, 50)+ "...");else out.print(item.getPreview_text()); %></li>
    <%}} %>
  </ul>
</div>


  </div>
  <div class="clr"></div>
</div>