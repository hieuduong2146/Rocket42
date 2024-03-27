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
        <hr />
				 <%
                       	String msg = request.getParameter("msg");
                       		if(msg != null && !"".equals("msg")){
                       			switch(msg){
                       			case "1": 
                       				out.print("them thanh cong");
                       				break;
                       			case "3": 
                       				out.print("xoa thanh cong");
                       				break;
                       			case "8": 
                       				out.print("id không tồn tại");
                       				break;
                       			case "5": 
                       				out.print("SỬA THÀNH CÔNG");
                       			
                       				break;
                       			case "6": 
                       				out.print("SỬA THẤT BẠI");
                       			
                       				break;
                       			case "7": 
                       				out.print("XÓA THÀNH CÔNG");
                       			
                       				break;
                       			case "9": 
                       				out.print("XÓA THẤT BẠI");
                       			
                       				break;
                       			}
                       		}
                                 %>
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath() %>/admin/cat/add" class="btn btn-success btn-md">Thêm</a>
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
                                      
                                        <th>Tên Danh mục</th>
                                        
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <?php for($i = 1; $i <= 5; $i++) {
                                        if ($i % 2 == 0) { $cl = "even"; } else { $cl = "odd"; }
                                    ?>
                                    <%
                                    	ArrayList<Category> cat = (ArrayList<Category>)request.getAttribute("categories");
                                    	for(Category item :cat){
                                    	if(item != null){
                                    %>
                                    <tr class="<?php echo $cl?> gradeX">
                                        <td><%=item.getId() %></td>
                                       
                                     
                                       <td><%=item.getName() %></td>
                                        <td class="center">
                                            <a href="<%=request.getContextPath() %>/admin/cat/edit?id=<%=item.getId() %>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath() %>/admin/cat/del?id=<%=item.getId() %>" title="" class="btn btn-danger" onclick="return confirm('BẠN CÓ MUỐN XÓA ');"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
                                    <%} }%>
                                    <?php } ?>
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
    document.getElementById("category").classList.add('active-menu');
</script>

<%@ include file="/templates/admin/inc/footer.jsp" %>