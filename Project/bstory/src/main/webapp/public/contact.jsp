<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/templates/public/inc/header.jsp" %>
  <div class="content">

<div class="content_resize">
  <div class="mainbar">
    <div class="article">
      <h2><span>Liên hệ</span></h2>
      <div class="clr"></div>
      <p>Nếu có thắc mắc hoặc góp ý, vui lòng liên hệ với chúng tôi theo thông tin dưới đây.</p>
    </div>
     <%
                       	String msg = request.getParameter("msg");
   						 String err = request.getParameter("err");
     
                       		if(msg != null && !"".equals("msg")){
                       			switch(msg){
                       			case "1": 
                       				out.print("Thêm Liên Hệ Thành Công");
                       				break;
                       		
                       			}
                       		}
                       			if(err != null && !"".equals("err")){
                           			switch(err){
                           			case "1": 
                           				out.print("Thêm Liên Hệ Thất Bại");
                           				break;
                           		
                           			}
                       		}
                                 %>
    <div class="article">
      <h2>Form liên hệ</h2>
      <div class="clr"></div>
      
      <form class="form" action="<%=request.getContextPath() %>/public/add/contact" method="post" id="sendemail">
        <ol>
          <li>
            <label for="name">Họ tên (required)</label>
            <input id="name" name="name" class="text" />
          </li>
          <li>
            <label for="email">Email (required)</label>
            <input id="email" name="email" class="text" />
          </li>
          <li>
            <label for="website">Website</label>
            <input id="website" name="website" class="text" />
          </li>
          <li>
            <label for="message">Nội dung</label>
            <textarea id="message" name="message" rows="8" cols="50"></textarea>
          </li>
          <li>
            <input type="image" name="imageField" id="imageField" src="images/submit.gif" class="send" />
            <div class="clr"></div>
          </li>
        </ol>
      </form>
    </div>
  </div>
  <div class="sidebar">
  <script type="text/javascript">
		$(document).ready(function(){
			$(".form").validate({
				rules:{
					name:{
						required:true,						
					},	
					email:{
						required:true,						
					},			
					website:{
						required:true,						
					},			
					message:{
						required:true,						
					},			
				},
				messages:{
					name:{
						required:"vui lòng nhập vào tên liên hệ",
					
					},	
					email:{
						required:"vui lòng nhập vào email",
					
					},			
					website:{
						required:"vui lòng nhập vào website",
					
					},			
					message:{
						required:"vui lòng nhập vào massage",
					
					},			
				},
			});
		});
	</script>
  <%@ include file="/templates/public/inc/leftbar.jsp" %>
</div>

<%@ include file="/templates/public/inc/footer.jsp" %>
