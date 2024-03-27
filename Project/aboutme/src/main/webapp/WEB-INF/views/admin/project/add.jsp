<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm Project</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/project/add" method="post" enctype="multipart/form-data">
				  			<div>
								<div class="row mb-10"></div>								
								<div class="row">								
									<div class="col-sm-6">								
										<div class="form-group">
											<label for="name">Tên</label>
											<input name="name" type="text" class="form-control" placeholder="Nhập tên dự án">
											<form:errors path="project.name"></form:errors><br/>
											
											<label for="name">Link</label>
											<input name="link" type="text" class="form-control" placeholder="Nhập link">
											<form:errors path="project.link"></form:errors><br/>
											
											<label for="name">Hình ảnh</label>
											<input name="image" type="file" class="form-control">
											<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
											
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
	  		
		 