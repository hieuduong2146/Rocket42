<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">Thêm tin tức </div>
			  			</div>
			  			<div class="content-box-large box-with-header">
			  				<form action="${pageContext.request.contextPath}/admin/news/add" method="post" enctype="multipart/form-data">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="name">Tên tin tức </label>
											<input name="name" type="text" class="form-control" placeholder="Nhập tên tin">
											<form:errors path="news.name"></form:errors>
										</div>
										<div class="form-group">
											<label>Thêm hình ảnh</label>
											<input name = "image" type="file" class="btn btn-default" id="exampleInputFile1">
											<p class="help-block"><em>Định dạng: jpg, png, jpeg,...</em></p>
										</div>
										<div class="form-group">
											<label>Danh mục </label>
											<select name = "cid" class="form-control">
												<c:choose>
													<c:when test="${not empty cat }">
														<c:forEach items="${cat}" var="cat" >
															<option value="${cat.cid }">${cat.cname }</option>
														</c:forEach>
													</c:when> 
													<c:otherwise>
														<option> Không có danh mục nào</option>
													</c:otherwise>
												</c:choose>
											   											  
											</select>
										</div>									
										<div class="form-group">
										   <label for ="description">Mô tả</label>
										   <textarea id ="description" name = "detail" class="form-control" rows="3"></textarea>
										<form:errors path="news.detail"></form:errors>
										</div>										
									</div>
									<script type="text/javascript">
									var editor  = 	CKEDITOR.replace('detail');
									CKFinder.setupCKEditor(editor,'${pageContext.request.contextPath}/libraries/ckfinder/')
									</script>
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
	  		
		 