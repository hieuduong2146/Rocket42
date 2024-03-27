<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form  class= "form" role="form" action = "<%=request.getContextPath()%>/admin/cat/add" method="post">
                                <%
                                        	String name = request.getParameter("tendanhmuc");	
                                        	String err = request.getParameter("err");
                                        		if(err != null && !"".equals("msg")){
                                        			switch(err){
                                        			case "1": 
                                        				out.print("them that bai");
                                        				break;
                                        			}
                                        		}
                                  	 %>
                                    <div class="form-group">
                                        <label>Tên Danh mục</label>
                                        <input type="text"  value ="<%if(name != null)out.print("name"); %>" class="form-control" name="tendanhmuc"  />
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
    <!-- /. PAGE INNER  -->
    <script type="text/javascript">
		$(document).ready(function(){
			$(".form").validate({
				rules:{
					tendanhmuc:{
						required:true,						
					},					
				},
				messages:{
					tendanhmuc:{
						required:"vui lòng nhập vào tên danh mục",
					
					},																	
				},
			});
		});
	</script>
</div>
<%@ include file="/templates/admin/inc/footer.jsp" %>