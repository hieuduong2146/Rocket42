<%@page import="model.bean.ThongTinBanBe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<div class="content">
	 <div class="container">
		 <div class="content-grids">
			 <div class="col-md-8 content-main">
				 <div class="content-grid">
					 <div class="content-grid-head">
						 <h3>BẠN QUEN THỜI PHỔ THÔNG</h3>
						 <h4>Đăng ngày: 12/08/2016 - Lượt xem: 30</h4>
						 <div class="clearfix"></div>
					 </div>
					 <div class="content-grid-single">
					 <%

					 			 	ThongTinBanBe banBe =(ThongTinBanBe)request.getAttribute("objDT");
					 %>
						 <h3><%=banBe.getFname%></h3>
						 <div class="detail_text">
							 <span><%=banBe.getPreview%></span>
							 <img class="single-pic" src="images/anh1.jpg" alt="">
							 <p><%=t(banBe.getPreview(%></p>
						 </div>
						 
					  </div>
					 
				 </div>	
				 <div>
				 	<div>
				 		 <h1>các bạn thân khác</h1>	
				 	</div>
				 		<%


				 				 			ArrayList<ThongTinBanBe> listcbtk = (ArrayList<ThongTinBanBe>)request.getAttribute("listfr");
				 				 			if(listcbtk.size() > 0){
				 				 				for(ThongTinBanBe obj :listcbtk ){
				 		%>
				 		<div style="float: left; margin-right: 10px">
				 			<img class="single-pic" src="images/anh1.jpg" alt="" style="width: 100px ;height : 150px" >
				 			<p> <%=t(obj.getFname(%></p>
				 		</div>
				 		
				 	  	<%
				 						 	  	
				 						 	  	}
				 						 	  	%>
					</div>
					 			 
			 </div>
			 
			 
			 <div class="col-md-4 content-main-right">
			 <%@include file="inc/right_bar.jsp" %>
			 </div>
<%@include file="inc/footer.jsp" %>