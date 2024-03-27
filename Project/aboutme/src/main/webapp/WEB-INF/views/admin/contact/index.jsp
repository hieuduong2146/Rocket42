<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý liên hệ</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
                	<div class="col-md-4">
                 	 <div class="input-group form">
                       <input type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="button">Search</button>
                       </span>
                  	 </div>
                  	</div>
				</div>

				<div class="row">
  				<div class="panel-body">
  					<p >${msg}</p>
  					<table cellpadding="0" cellspacing="0" border="0" class="table table-striped table-bordered" id="example">
						<thead>
							<tr>
								<th>ID</th>
								<th>Fullname</th>											
								<th>Email</th>
								<th>Phone</th>
								<th>Address</th>
								<th>Message</th>
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty contact}">
									<c:forEach items="${contact}" var="contact">
									 <c:set value="${pageContext.request.contextPath}/admin/contact/del/${contact.id}" var ="urlDel"/>
										<tr class="odd gradeX">
											<td>${contact.id}</td>
											<td>${contact.name}</td>
											<td>${contact.email}</td>
											<td>+84 ${contact.phone}</td>
											<td>${contact.address}</td>
											
											<td>${contact.content}</td>
																			 
											<td class="center text-center">
												
			                                    <a onclick=" return confirm('Bạn có muốn xóa ${contact.name}')" href="${urlDel }" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3" style="text-align:center">Không có liên hệ</td>
									</tr>
								</c:otherwise>
							</c:choose>
						
							
						</tbody>
					</table>

					<!-- Pagination -->
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					      <li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					      <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					      <li><a href="#">2</a></li>
					      <li><a href="#">3</a></li>
					      <li><a href="#">4</a></li>
					      <li><a href="#">5</a></li>
					      <li><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li>
					   </ul>
					</nav>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->
  			</div><!-- /.content-box-large -->



		 