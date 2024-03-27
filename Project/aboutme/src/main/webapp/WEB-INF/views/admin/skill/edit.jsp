<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa kỹ năng</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/skill/edit/${skill.id}" method="post">
				  			<div>
								<div class="row mb-10"></div>								
								<div class="row">								
									<div class="col-sm-6">								
										<div class="form-group">
											<label for="name">Tên kỹ năng</label>
											<input value ="${skill.name}" name="name" type="text" class="form-control" placeholder="Nhập tên Danh mục">																					
											<form:errors path="skill.name"></form:errors><br>
											<label for="name">Giá trị</label>
					 						<input value ="${skill.value}" name="value" type="text" class="form-control" placeholder="Nhập giá trị">
											<form:errors path="skill.value"></form:errors>
										</div>									
									</div>			
								</div>
								<hr>
								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="Sửa" class="btn btn-success" />
										<input type="reset" value="Nhập lại" class="btn btn-default" />
									</div>
								</div>								
							</div>
							</form>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		 