<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>

  			<div class="content-box-large">
  				<div class="row">
	  				<div class="panel-heading">
	  					<div class="panel-title ">Quản lý tin tức</div>
		  			</div>
				</div>
				<hr>	
				<div class="row">
					<div class="col-md-8">
						<a href="${pageContext.request.contextPath}/admin/news/add" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Thêm</a>

					</div>
                	<div class="col-md-4">
                	
                 	 <div class="input-group form">
                 	 <form action="${pageContext.request.contextPath}/admin/news/search"  method ="get">
                       <input name ="search" type="text" class="form-control" placeholder="Search...">
                       <span class="input-group-btn">
                         <button class="btn btn-primary" type="submit">Search</button>
                       </span>
                       </form>
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
								<th>Tên Tin</th>	
								<th>Picture</th>
								<th>Danh mục</th>
								<th>Detai</th>
								<th>Count_views</th>
								<th>Ngày đăng</th>								
								<th>Status</th>																		
								<th>Chức năng</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${not empty news}">
									<c:forEach items="${news}" var="news">
									<c:set value="${pageContext.request.contextPath}/admin/news/del/${news.id}" var ="urlDel"/>
									<c:set value="${pageContext.request.contextPath}/admin/news/edit/${news.id}" var ="urlEdit"/>
										<tr class="odd gradeX">
											<td>${news.id}</td>
											<td>${news.name}</td>
											<td>
												<img style= "width: 100px" alt="" src="${pageContext.request.contextPath}/files/${news.picture}">
											</td>
											<td>${news.category.cname}</td>											
											<td>${news.detail}</td>
											<td>${news.count_views}</td>
											<td>${news.date_create}</td>
											<td class ="stt-${news.id}">
											<c:choose>
												<c:when test="${news.status == 0 }">												
													<a  href = "javascript:void(0)" onclick="return getStatus(${news.id},${news.status})" ><img  src="${pageContext.request.contextPath}/adminUrl/images/do.png"></a>
												</c:when>
												<c:otherwise>
													<a href = "javascript:void(0)" onclick="return getStatus(${news.id},${news.status})"><img src="${pageContext.request.contextPath}/adminUrl/images/xanh.png"></a>
												</c:otherwise>
											</c:choose>
											</td>	
																		 
											<td class="center text-center">
												<a href="${urlEdit} " title="" class="btn btn-primary"><span class="glyphicon glyphicon-pencil "></span> Sửa</a>
			                                    <a onclick=" return confirm('Bạn có muốn xóa ${news.name}')" href="${urlDel }" title="" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Xóa</a>
											</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="3" style="text-align:center">Không có tin tức nào</td>
									</tr>
								</c:otherwise>
							</c:choose>
						
							
						</tbody>
					</table>

					<!-- Pagination -->
					<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					   
					   	<c:choose>
					   		<c:when test="${page == 1 }">
					   			<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					   		</c:when>
					   		<c:otherwise>
					   			<li class=""><a href="${pageContext.request.contextPath }/admin/news/index?page=${page - 1 }" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					   		</c:otherwise>
					   		
					   	</c:choose>
					      
					      
					      	<c:forEach begin="1" end="${numberOffpages }" step ="1" varStatus="item">
					      		<c:choose>
					      			<c:when test="${item.count==page }">
					      				 <li class="active"><a href="${pageContext.request.contextPath }/admin/newsindex?page=${item.count}">${item.count} <span class="sr-only">(current)</span></a></li>
					      			</c:when>
					      			<c:otherwise>
					      				 <li><a href="${pageContext.request.contextPath }/admin/news/index?page=${item.count}">${item.count }</a></li>
					      			</c:otherwise>
					      		</c:choose>
					      		
					      	</c:forEach>
					     <!--   <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					      <li><a href="#">2</a></li>
					      <li><a href="#">3</a></li>
					      <li><a href="#">4</a></li>
					      <li><a href="#">5</a></li> -->
					      
					       	<c:choose>
					   		<c:when test="${page == numberOffpages}">
					   			<li class = "disabled" ><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li> 
					   		</c:when>
					   		<c:otherwise>
					   			<li ><a href="${pageContext.request.contextPath }/admin/news/index?page=${page + 1}" aria-label="Next"><span aria-hidden="true">»</span></a></li> 
					   		</c:otherwise>
					   		
					   	</c:choose>
					      	
					   </ul>
					</nav>
					<!-- /.pagination -->
					
  				</div>
  				</div><!-- /.row -->  				
  					<script type = "text/javascript">  					
							function  getStatus(id,status){								
								$.ajax({
									url:'${pageContext.request.contextPath}/admin/news/xulystt',
									type:'POST',
									cache:false,
									data:{
										aid:id,
										stt:status
									},
									success:function(data){
										$(".stt-"+id).html(data);
									},
									error:function(data){
										alert("có lỗi trong quá trình xử lý")
									},
								});
								return false;
							}
						</script>
  			</div><!-- /.content-box-large -->



		 