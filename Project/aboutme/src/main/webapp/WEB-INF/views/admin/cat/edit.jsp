<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sủa danh mục</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/cat/edit/${category.cid}" method="post">
				  			<div>
								<div class="row mb-10"></div>								
								<div class="row">								
									<div class="col-sm-6">								
										<div class="form-group">
											<label for="name">Tên Danh Mục</label>
											<input value="${category.cname}" name="cname" type="text" class="form-control" placeholder="Nhập tên Danh mục">
											<form:errors path="category.cname"></form:errors>
										</div>									
									</div>			
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Thêm" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>								
							</div>
							</form>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		 