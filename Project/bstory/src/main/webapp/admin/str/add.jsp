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
                <h2>Thêm Truyện</h2>
            </div>
        </div>
         <%
        	@SuppressWarnings("unchecked")
        	ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
        String name = request.getParameter("tentruyen");
        String catID = request.getParameter("category");
        String priviewText = request.getParameter("mota");
		String detailText = request.getParameter("chitiet");
        String err = request.getParameter("err");   
    	if(err != null){
    		switch(err){
    		case "1" : 
    			out.print("CÓ LỖI KHI THÊM");
    			break;
    		case "2" : 
    			out.print("KHÔNG CÓ QUYỀN THÊM");
    			break;
    		}
    		
    	}
        	
        %>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form class="form" role="form" enctype="multipart/form-data" method="post">
                                    <div class="form-group">
                                        <label>Tên truyện</label>
                                        <input  value = "<%if(name!= null)out.print(name); %>" type="text" name="tentruyen" class="form-control" />
                                    </div>

                                    <div class="form-group">
                                        <label>Danh mục truyện</label>
                                        <select name="category" class="form-control">
                                         <%
                                        	if(categories != null && categories.size() > 0){
                                        		for(Category item : categories){
                                        	
                                        %>                                        	
                                              <option <%if(catID != null && catID.equals(String.valueOf(item.getId()))) out.print(" selected ");%> value = "<%=item.getId()%>"><%=item.getName() %></option>
                                           <%}} %>   
                                            </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Hình ảnh</label>
                                        <input type="file" name="hinhanh" />
                                    </div>
                                    <div class="form-group">
                                        <label>Mô tả</label>
                                        <textarea class="form-control" rows="3" name="mota"> <%if(detailText!= null)out.print(detailText); %></textarea>
                                    	<label for="mota" class ="error"></label>
                                    </div>
                                    <div class="form-group">
                                        <label>Chi tiết</label>
                                        <textarea class="form-control" rows="5" name="chitiet"><%if(priviewText!= null)out.print(priviewText);%></textarea>
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
				ignore:[],
				debug: false,
				rules:{
					tentruyen:{
						required:true,						
					},	
					category:{
						required:true,						
					},			
					mota:{
						required:true,						
					},			
					chitiet:{
						required:true,						
					},			
				},
				messages:{
					tentruyen:{
						required:"vui lòng nhập vào tên truyện",
					
					},	
					category:{
						required:"vui lòng chọn danh mục",
					
					},			
					mota:{
						required:"vui lòng nhập vào mô tả",
					
					},			
					chitiet:{
						required:"vui lòng nhập vào chi tiết",
					
					},			
				},
			});
		});
	</script>
		<script>
	var editor = CKEDITOR.replace('mota');
</script>
<script>
    document.getElementById("category").classList.add('active-menu');
</script>

<%@ include file="/templates/admin/inc/footer.jsp" %>