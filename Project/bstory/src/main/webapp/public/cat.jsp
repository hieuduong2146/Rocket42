<%@page import="util.StringUtil"%>
<%@page import="model.bean.Stories"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
  <div class="content">

<div class="content_resize">
  <div class="mainbar">
     <%
  	Category category = (Category)request.getAttribute("category");
  	if(category != null){
  %>
    <div class="article">
	  <h1><%=category.getName() %></h1>
	  </div>
	  <%} %>
	   <%
    	@SuppressWarnings("unchecked")
    	ArrayList<Stories> str = (ArrayList<Stories>)request.getAttribute("str");
    	if(str != null && str.size() > 0){
    		int i = 0;
    		for(Stories item : str){
    			i++;
    	
    %>
       <div class="article">
      <h2><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(item.getCategory().getName())%>/<%=StringUtil.makeSlug(item.getName())%>-<%=item.getId()%>.html"><%=item.getName() %></a></h2>
      <p class="infopost"><%=item.getDate_create() %> . Lượt xem: <%=item.getCounter()%></p>
      <div class="clr"></div>
      <div class="img"><img src="<%=request.getContextPath() %>/files/<%=item.getPicture() %>" width="161" height="192" alt="<%=item.getName() %>" class="fl" /></div>
      <div class="post_content">
      <p><%=item.getPreview_text() %></p>
        <p class="spec"><a href="<%=request.getContextPath() %>/<%=StringUtil.makeSlug(item.getCategory().getName())%>/<%=StringUtil.makeSlug(item.getName())%>-<%=item.getId()%>.html" class="rm">Chi tiết </a></p>
      </div>
      <div class="clr"></div>
    </div>
    <%}} %>
     <%
    	int numberOfPage = (Integer)request.getAttribute("numberOfPage");
   		 int currentPage = (Integer)request.getAttribute("currentPage");
   		 if(str != null && str.size() > 0){
    %>  
    <p class="pages"><small>Trang 1 / 2</small> 
     <%
    	for(int i = 1 ;i < numberOfPage ;i++){
    %>
     <%if(currentPage == i){ %>
    <span><%=i %></span> 
    <%}else{ %>
    <a href="<%=request.getContextPath()%>/public/cats?page=<%=i%>"><%=i %></a>
	<%}} %>
	<a href="#">&raquo;</a></p>
  
  </div>
  <%} %>
  <div class="sidebar">
  
  <%@ include file="/templates/public/inc/leftbar.jsp" %>

</div>
<%@ include file="/templates/public/inc/footer.jsp" %>
