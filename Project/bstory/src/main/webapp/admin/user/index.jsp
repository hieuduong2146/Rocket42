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
                <h2>Quản lý danh mục</h2>
            </div>
        </div>
        <%
								 String err = request.getParameter("err");
									 String msg = request.getParameter("msg");
								 	if(request.getParameter("msg") != null ){
                                        	switch (msg){
                                        	case "1" :
                                        		out.print("THÊM THÀNH CÔNG");        
                                        		break;
                                        	case "2":                                        		
                                       		out.print("SỬA THÀNH CÔNG");
                                        		break;
                                        	
                                        	case "5":                                        		
                                           		out.print("XÓA THÀNH CÔNG");
                                            		break;
                                        	case "6":                                        		
                                           		out.print("XÓA THẤT BẠI");
                                            		break;
                                        	case "7":                                        		
                                           		out.print("ID KHÔNG TỒN TẠI");
                                            		break;
                                        	
                                        	}                    
                                        	if(request.getParameter("err") != null ){
                                        		switch (err){
                                            	case "1" :
                                            		out.print("KHÔNG CÓ QUYÊN THÊM");        
                                            		break;
                                            	case "2" :
                                            		out.print("KHÔNG CÓ QUYỀN SỬA");        
                                            		break;
                                            	case "3" :
                                            		out.print("KHÔNG CÓ QUYỀN XÓA");        
                                            		break;
                                        	}   
                                        }
								 	}
                                   %>
        <!-- /. ROW  -->
        <hr />

        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath() %>/admin/user/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" class="form-control input-sm" placeholder="Nhập tên truyện" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Username</th>                                     	
                                        <th>fullname</th>
                                        <th>role</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<%
                                		@SuppressWarnings("unchecked")
                                		ArrayList<User> user = (ArrayList<User>)request.getAttribute("user");
                                		for(User item : user){
                                			if(item != null ){
                                		
                                	%>
                                    <tr class="<?php echo $cl?> gradeX">
                                        <td><%=item.getId() %></td>
                                        <td><%=item.getUsername() %></td>
                                    
                                        <td class="center"><%=item.getFullname()%></td>
                                        <td class="center"><%=item.getRole()%></td>                                                                                  
                                        
                                        <td class="center">
                                            <a href="<%=request.getContextPath() %>/admin/user/edit?id=<%=item.getId() %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            
                                            <a href="<%=request.getContextPath() %>/admin/user/del?id=<%=item.getId() %>" title="" class="btn btn-danger" onclick="return confirm('BẠN CÓ MUỐN XÓA ');"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
                                    <%}} %>
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ 1 đến 5 của 24 truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous disabled" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="#">Trang trước</a></li>
                                            <li class="paginate_button active" aria-controls="dataTables-example" tabindex="0"><a href="#">1</a></li>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">2</a></li>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">3</a></li>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">4</a></li>
                                            <li class="paginate_button " aria-controls="dataTables-example" tabindex="0"><a href="#">5</a></li>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="#">Trang tiếp</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>

</div>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>