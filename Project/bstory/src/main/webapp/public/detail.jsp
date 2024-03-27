<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
  <div class="content">

<div class="content_resize">
  <div class="mainbar">
   <%
  	Stories str = (Stories)request.getAttribute("str");
  	if( str != null){
  	
  %>
    <div class="article">
      <h1><%=str.getName() %></h1>
      <div class="clr"></div>
      <p><%=str.getDate_create() %> Luot Xem : <%=str.getCounter() %></p>
      <div class="vnecontent">
          <p><%=str.getPreview_text() %></p>
          
    </div>
    </div>
    <%} %>
    <div class="article">
      <h2><span></span> Truyện liên quan</h2>
      <div class="clr"></div>
       <%
      	@SuppressWarnings("unchecked")
      	ArrayList<Stories> relatedStr =(ArrayList<Stories>) request.getAttribute("relatedStr");
      	if(relatedStr != null && relatedStr.size() > 0){
      		for(Stories item :relatedStr ){
      			out.print(item.getName());
      %>
      <div class="comment"> <a href="<%=request.getContextPath() %>/detail?id=<%=item.getId()%>"><img src="<%=request.getContextPath() %>/files/<%=item.getPicture() %>" width="40" height="40" alt="" class="userpic" /></a>
        <h3><a href="<%=request.getContextPath() %>/detail?id=<%=item.getId()%>" title=""><%=item.getName() %></a></h3>
        <p><%=item.getPreview_text() %></p>
      </div>
	<%}}else{%>
	<h2>Không Có Truyện Liên Quan!!!</h2>
	<%} %>
    </div>
  </div>
  <div class="sidebar">
     <%@ include file="/templates/public/inc/leftbar.jsp" %>
</div>

<%@ include file="/templates/public/inc/footer.jsp" %>
  
