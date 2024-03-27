<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>

<%@ include file="/templates/admin/inc/leftbar.jsp" %>

<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm người dùng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
           <%
        	String err = request.getParameter("err");
        String msg = request.getParameter("msg");
        	String  username = request.getParameter("username");
        	String  fullname = request.getParameter("fullname");
        	String  role = request.getParameter("role");
        	if(err != null){
        		switch(err){
        		case "1" : 
        			out.print("THÊM THẤT BẠI");	
        			break;
        		case "2" : 
        			out.print("TÊN ĐĂNG NHẬP ĐÃ TỒN TẠI");
        			break;
        		}
        	}
        	
        %>
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form" role="form" method = "post" action = "<%=request.getContextPath()%>/admin/user/add">
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input	value="<%if(username != null)out.print(username); %>" type="text" name="username" class="form-control" />
                                    </div>

                                    <div class="form-group">
                                        <label>password</label>
                                        <input type="password" name="password" />
                                    </div>
                                    <div class="form-group">
                                        <label>fullname</label>
                                        <input value="<%if(fullname != null)out.print(fullname); %>" class="form-control" rows="3" name="fullname"/>
                                    </div>
                                    <div class="form-group">
                                        <label>role</label>
                                        <input value="<%if(role != null)out.print(role); %>" class="form-control" rows="5" name="role"/>
                                    </div>


                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
                                </form>



                            </div>

                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <script type="text/javascript">
		$(document).ready(function(){
			$(".form").validate({
				rules:{
					username:{
						required:true,
						maxlength:12,	
						minlength:5,
					},	
					password:{						
						required:true,	
																						
					},			
					fullname:{
						required:true,						
					},	
					role:{
						required:true,						
					},	
					
				},
				messages:{
					username:{
						required:"vui lòng nhập vào tên người dùng",
						maxlength: "nhập vào nhiều nhất 12 kí tự",
						minlength: "nhập vào ít nhất 5 kí tự",
					},
					password:{
						required:"bạn phải nhập vào mật khẩu",
						maxlength: "nhập vào nhiều nhất 12 kí tự",
					
					},		
					fullname:{
						required:"vui lòng nhập vào họ tên",
					
					},	
					role:{
						required:"vui lòng nhập vào role",
					
					},	
					
				},
			});
		});
	</script>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>

<%@ include file="/templates/admin/inc/footer.jsp" %>