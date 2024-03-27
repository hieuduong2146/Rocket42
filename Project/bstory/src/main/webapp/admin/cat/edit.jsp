<%@page import="model.bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa danh mục</h2>
            </div>
        </div>
        <!-- /. ROW  --> 		
					 <%                                             	
                     	String err = request.getParameter("err");
                     		if(err != null && !"".equals("msg")){
                     			switch(err){
                     			case "1": 
                     				out.print("them that bai");
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
                                        	Category item = (Category)request.getAttribute("item");
                                        	if(item != null){
                                        %>
                            
                                <form role="form" action ="<%=request.getContextPath()%>/admin/cat/edit?id=<%=item.getId() %>" role="form" method="post">
                              
                                    <div class="form-group">
                                        <label>Tên Danh mục</label>
                                        <input type="text"  value ="<%=item.getName() %>" class="form-control" name="namecat" />
                                    </div>
									                                
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                    <%} %>   
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
</div>
<%@ include file="/templates/admin/inc/footer.jsp" %>