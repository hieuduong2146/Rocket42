<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ include file="/WEB-INF/templates/taglib.jsp" %>
		
				
				<div class="col-sm-6">
					<br>
					<h2 style="color:#003322">${newone.category.cname }</h2>
					<hr>
					<h2 id="view">${newone.name}</h2>
					<span class="glyphicon glyphicon-pencil">
						Lượt đọc:${newone.count_views}
					</span>	
					<h5>			
					
					<br/>
								
					<p>${newone.detail}</p>
					<img href="" style="width: 70%; height:300px;border: 2px solid #ece4e4;" src="${pageContext.request.contextPath }/files/${newone.picture}"><br>							
					
				</h5>				
				<br>
				
				<div class="hidden-form">
				      <h2 style="color:#003322">Tham gia bình luận:</h2><br>
				          <i  class="er" style="color:red">				
				            </i>
				      <form action="javascript:void(0)"  method="post">				       
				        <div class="form-group">
				        <textarea class="form-control" name="comment" id="comment" placeholder="nhập bình luận" rows="3"  ></textarea>				      				       
				        </div>
				        <button onclick="return getCmt(${newone.id})" type="submit" class="btn btn-success">Gửi bình luận</button>
				      </form>
				      
				      
				       <br><br>
					     <div class="show-cmt">
					      <h2 style="color:#003322">Comment</h2><br>
					      <div class ="views-${newone.id}">
							  <div class="row ">
							  <c:choose>
							  	<c:when test="${not empty cc }">
							  		<c:forEach items="${cc }" var="cc">
							  			 <div class="col-sm-2 text-center">
								          <img src="${pageContext.request.contextPath}/publicUrl/assets/imgs/111.png" style="width: 80px !important; ">					 					           
								        </div>	
								        <div class="col-sm-10">        
									          <p>${cc.comment }</p>
									          <p>${cc.time}</p>
									          <br>
									     </div>	
							  		</c:forEach>
							  	</c:when>
							  </c:choose>					         	      				      
						   	 </div>
					   	 </div>
				    	</div>
				   </div>
				    
					<h2 style="color:#003322;font-size:20px;">BÀI VIẾT CÙNG CHUYÊN MỤC</h2>
					<div class="row">
					<c:choose>
						<c:when test="${not empty news}">
							<c:forEach items="${news }" var="news">
								<div class="col-sm-4">
									<a href=""></a>
									<img href="" style="width: 100%; height:180px;border: 2px solid #ece4e4;" src="${pageContext.request.contextPath }/files/${news.picture}"><br>							
									<h3><a style="font-size:15px;line-height: 1.1;font-weight: 500;color:#5290C6;" href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(news.name)}-${news.id}.html">${news.name}</a></h3>
									<br>
									<br>
								</div>
							</c:forEach>
						</c:when>
					</c:choose>		
															
					</div>
					<div class ="clear"></div>
					<div class ="clear"></div>
					<script type = "text/javascript">
							function getCmt(id){
								var comment = $("#comment").val();
								$.ajax({
									url:'<%=request.getContextPath()%>/xuly-comment',
									type:'POST',
									cache:false,
									data:{
										idnews:id,
										cmt:comment
									},
									success:function(data){
										$(".views-"+id).html(data);
									},
									error:function(data){
										alert("có lỗi trong quá trình xử lý")
									},
								});
								return false;
							}
						</script>
				</div>
				
				
		