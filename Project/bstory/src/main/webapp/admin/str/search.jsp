<%@page import="model.bean.User"%>
<%@page import="model.bean.Stories"%>
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
        <!-- /. ROW  -->
        <%
        	String err = request.getParameter("err");
        	String msg = request.getParameter("msg");
        	if(err != null){
        		switch(msg){
        		case "1" : 
        			out.print("Tìm kiếm thất bại");
        			break;
        		case "2" : 
        			out.print("XÓA THẤT BẠI");
        			break;
        		case "3" : 
        			out.print("KHÔNG CÓ QUYỀN THÊM");
        			break;
        		}
        	}
        		
        	
        %>
        <hr />

        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath() %>/admin/str/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="<%=request.getContextPath()%>/admin/search">
                                        <input type="submit"  value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input name="search" type="search" class="form-control input-sm" placeholder="Nhập tên truyện" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                               
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên Truyện</th>
                                        <th> Tên Danh mục</th>
                                        <th>Nội dung</th>
                                        <th>Lượt đọc</th>
                                        <th>Hình ảnh</th>
                                        <th width="100px">Chức năng</th> 	
                                    </tr>
                                    
                                </thead>
                                <tbody>
                                    <%
                                    	@SuppressWarnings("unchecked")
	                                	ArrayList<Stories> str =(ArrayList<Stories>)request.getAttribute("search");
	                                	for(Stories items : str){
	                                		if(str != null){
                             	   %>
                                    <tr class="<?php echo $cl?> gradeX">
                                        <td><%=items.getId() %></td>
                                        <td><%=items.getName() %></td>
                                        <td><%=items.getCategory().getName() %></td>                                      
                                        <td><%=items.getPreview_text() %></td>                                        
                                        <td class="center"><%=items.getCounter() %></td>
                                        <td>
                                       <%if(items.getPicture().isEmpty()){ %>
                                      	  chua co hinh anh
                                        <%}else{ %>
											<img width="200px" height="200px" src="<%=request.getContextPath() %>/files/<%=items.getPicture() %>" alt=""/>
											<%} %>
											</td>
											 <%
		                                      	 User role = (User)session.getAttribute("userlogin");	
											 out.print(items.getUid());
		                                       		if("ADMIN".equals(role.getRole())){                                       		
                                     	  	%>
                                        <td class="center">
                                            <a href="<%=request.getContextPath() %>/admin/str/edit?id=<%=items.getId() %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath() %>/admin/str/del?id=<%=items.getId() %>" title="" class="btn btn-danger"><i class="fa fa-pencil" onclick="return confirm('BẠN CÓ MUỐN XÓA ');"></i> Xóa</a>
                                        </td>
                                     <%}else{ %>
                                       <%if(role.getId() == items.getUid()){ %>
                                       
                                        <td class="center">
                                            <a href="<%=request.getContextPath() %>/admin/str/edit?id=<%=items.getId() %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath() %>/admin/str/del?id=<%=items.getId() %>" title="" class="btn btn-danger"><i class="fa fa-pencil" onclick="return confirm('BẠN CÓ MUỐN XÓA ');"></i> Xóa</a>
                                        </td>
                                       <%} %>
                                       <%} %>
                                    </tr>
                                 <%}}	 %>
                                 	
                                </tbody>
                            </table>
                           
                            <div class="row">
                      
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
    document.getElementById("story").classList.add('active-menu');
</script>
<%@ include file="/templates/admin/inc/footer.jsp" %>