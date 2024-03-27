<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Sửa chặng đường</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/way/edit/${way.id}" method="post">
				  			<div>
								<div class="row mb-10"></div>								
								<div class="row">								
									<div class="col-sm-6">								
										<div class="form-group">
											<label for="name">Tên</label>
											<input value="${way.name}" name="name" type="text" class="form-control" placewholder="Nhập tên chặng đường">
											<form:errors path="way.name"></form:errors><br/>
											
											<label for="name">Time</label>
											<input value="${way.time}" name="time" type="text" class="form-control" placeholder="Nhập thời gian">
											<form:errors path="way.time"></form:errors><br/>
											
											<label for="name">Classify</label>
											<input value="${way.classify}" name="classify" type="text" class="form-control" placeholder="Nhập phân lọai">
											<form:errors path="way.classify"></form:errors>
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
	  		
		 