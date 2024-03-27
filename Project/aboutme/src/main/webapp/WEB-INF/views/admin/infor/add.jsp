<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm thông tin</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/infor/add" method="post">
				  			<div>
								<div class="row mb-10"></div>								
								<div class="row">								
									<div class="col-sm-6">								
										<div class="form-group">
											<label for="name">Fullname</label>
											<input name="name" type="text" class="form-control" placeholder="Nhập họ và tên">
											<form:errors path="infor.name"></form:errors><br/>
											
											<label for="name">Birthday</label>
											<input name="birthday" type="text" class="form-control" placeholder="Nhập ngày sinh">
											<form:errors path="infor.birthday"></form:errors><br>
											
											<label for="name">Email</label>
											<input name="email" type="text" class="form-control" placeholder="Nhập  vào email">
											<form:errors path="infor.email"></form:errors><br>
											
											<label for="name">Addrerss</label>
											<input name="address" type="text" class="form-control" placeholder="Nhập  vào địa chỉ">
											<form:errors path="infor.address"></form:errors><br>
											
											<label for="name">Phone</label>
											<input name="phone" type="text" class="form-control" placeholder="Nhập vào phone">
											<form:errors path="infor.phone"></form:errors><br>
											
											<label for="name">Content</label>
											<input name="content" type="text" class="form-control" placeholder="Nhập vào content">
											<form:errors path="infor.content"></form:errors><br>
										
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
	  		
		 