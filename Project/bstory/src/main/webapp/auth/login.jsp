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
                <h2>Đăng Nhâp</h2>
            </div>
        </div>
        <!-- /. ROW  -->
         <%              
          	String err = request.getParameter("err");
          		if(err != null && !"".equals("msg")){
          			switch(err){
          			case "1": 
          				out.print("Đăng nhập không thành công");
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
                                <form role="form" method="post" >
                                    <div class="form-group">
                                        <label>Tên đăng nhâp</label>
                                        <input id="username" type="text" name="username" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label>Mật khẩu</label>
                                        <input id="password" type="password" class="form-control"  name="password"/>
                                    </div>
                                    <input value= "Đăng nhập" type="submit" name="submit" class="btn btn-success btn-md"/>
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
    document.getElementById("index").classList.add('active-menu');
</script>

<%@ include file="/templates/admin/inc/footer.jsp" %>