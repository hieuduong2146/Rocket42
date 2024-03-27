<%@page import="model.bean.User"%>
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
                <h2>Sửa người dùng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
           <%
        	String err = request.getParameter("err");
       	 String msg = request.getParameter("msg");
        	
        	String  role = request.getParameter("role");
        	if(err != null){
        		switch(err){
        		case "1" : 
        			out.print("SỬA THẤT BẠI");	
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
                             	<%
	                            	User user = (User)request.getAttribute("user");
	                            	if(user != null){
                            	
                            	%>
                                <form role="form" method = "post" action = "<%=request.getContextPath()%>/admin/user/edit?id=<%=user.getId() %>">
                                 
                                    <div class="form-group">
                                        <label>Username</label>
                                        <input	value="<%=user.getUsername() %>" type="text" name="username" class="form-control" />
                                    </div>

                                    <div class="form-group">
                                        <label>password</label>
                                        <input type="password" name="password" />
                                    </div>
                                    <div class="form-group">
                                        <label>fullname</label>
                                        <input value="<%=user.getFullname() %>" class="form-control" rows="3" name="fullname"/>
                                    </div>
                                    <div class="form-group">
                                        <label>role</label>
                                        <input value="<%=user.getRole() %>" class="form-control" rows="5" name="role"/>
                                    </div>

									<%} %>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
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
<script>
    document.getElementById("user").classList.add('active-menu');
</script>

<%@ include file="/templates/admin/inc/footer.jsp" %>