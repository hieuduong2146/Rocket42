<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
<div class="contact">
	 <div class="container">
		 <div class="contact-head">
			 <h3>Liên hệ</h3>
			 <%String msg =(String) request.getAttribute("msg");
			 if(msg != null){
			 out.print(msg);}
			 %>
			  <form action="<%=request.getContextPath()%>/them-thong-tin" method = "post">
				  <div class="col-md-6 contact-left">
						<input type="text" placeholder="Name" required="" name = "Name">
						<input type="text" placeholder="E-mail" required="" name = "email">
						<input type="text" placeholder="Phone" required="" name = "Phone">
				 </div>
				 <div class="col-md-6 contact-right">
						 <textarea placeholder="Message"></textarea>
						 <input type="submit" value="SEND">
				 </div>
				 <div class="clearfix"></div>
			 </form>
		 </div>
	 </div>
</div>

<div class="copywrite">
	 <div class="container">
	 <p>Copyrights &copy; 2016 <a href="http://vinaenter.edu.vn">VinaEnter Edu</a>. All rights reserved</p>
</div>
</div>
<%@include file="inc/footer.jsp" %>