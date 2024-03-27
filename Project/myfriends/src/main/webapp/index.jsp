<%@page import="model.bean.ThongTinBanBe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">				 
				 <h1 class="title">Những người bạn</h1>
				 <div class="content-grid-sec">
					 <div class="content-sec-info">
					 <%
					 p

					 			 	ArrayList<ThongTinBanBe> listFR = (ArrayList<ThongTinBanBe>)request.getAttribute("Ifdao");
					 			 	if(listFR.size() > 0){
					 			 		for(ThongTinBanBe obj :listFR){
					 %>
							 <h3><a href="<%=t(request.getContextPath(%>/mo-ta?did=<%=t(obj.getFid%>"><%=t(obj.getFname(%></a></h3>
							 <h4><%=t(obj.getDate_create(%></h4>
							 <p><%=t(obj.getPreview(%> </p>
							 <img src="images/anh1.jpg" alt=""/>
							 <a class="bttn" href="chi-tiet.jsp">Chi tiết bạn tôi</a>
						<%
						p
						}
						%>	 
					 </div>
				 </div>
				
			 </div>
			 
			 
			
			 <div class="col-md-4 content-main-right">
			 <%@include file="inc/right_bar.jsp" %>
			 </div>
				 
				
<%@include file="inc/footer.jsp" %>
