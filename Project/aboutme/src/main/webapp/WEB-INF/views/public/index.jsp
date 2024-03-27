<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/templates/taglib.jsp" %>

    <div class="container-fluid">
       <div id="about" class="row about-section">
       	<c:choose>
       		<c:when test="${not empty infor}">
       			<c:forEach items="${infor }" var="infor">
            <div class="col-lg-6 about-card">
                <h3 class="font-weight-light">Tôi là ai?</h3>
                <span class="line mb-5"></span>
                <h5 class="mb-3">Mục tiêu nghề nghiệp</h5>
                <p class="mt-20">Tôi từng theo học ngành sư phạm tại Đại học sư phạm Đà Nẵng . Cơ duyên đến với
                 IT khi vô tình biết đến trung tâm đào tạo lập trình viên VinaENTER. 
                 Mong muốn trở thành một Web Developer.Hãy cùng tìm hiểu con đường đến với IT của tôi nhé!
            </div>
            
            <div class="col-lg-6 about-card">
                <h3 class="font-weight-light">Thông tin cá nhân</h3>
                <span class="line mb-5"></span>
                <ul class="mt40 info list-unstyled">
                    <li><span>Birthdate</span> :${infor.birthday }</li>
                    <li><span>Email</span> : ${infor.email }
                    <li><span>Phone</span> : +84 ${infor.phone}</li>
                    <li><span>Skype</span> : ${infor.name} </li>
                    <li><span>Address</span> :  ${infor.address}</li>
                </ul>
                <ul class="social-icons pt-3">
                    <li class="social-item"><a class="social-link" href="#"><i class="ti-facebook" aria-hidden="true"></i></a></li>
                    <li class="social-item"><a class="social-link" href="#"><i class="ti-twitter" aria-hidden="true"></i></a></li>
                    <li class="social-item"><a class="social-link" href="#"><i class="ti-google" aria-hidden="true"></i></a></li>
                    <li class="social-item"><a class="social-link" href="#"><i class="ti-instagram" aria-hidden="true"></i></a></li>
                    <li class="social-item"><a class="social-link" href="#"><i class="ti-github" aria-hidden="true"></i></a></li>
                </ul>  
            </div>
            	 </c:forEach>	
            </c:when>
        </c:choose> 
        </div>
    </div>

    <!--Resume Section-->
    <section class="section" id="resume">
        <div class="container">
            <h2 class="mb-5" id="changduong"><span class="text-danger">Chặng </span> đường</h2>
            <div class="row">
                <div class="col-md-6 col-lg-6">
                    <div class="card">
                       <div class="card-header">
                            <div class="mt-2">
                                <h4>Chuyên môn</h4>
                                <span class="line"></span>  
                            </div>
                        </div>
                        <div class="card-body">
                        	<c:choose>
                        		<c:when test="${not empty way }">
                        		<c:forEach items="${way}" var="way">
                            <h6 class="title text-danger">${way.time }</h6>
                            <P>${way.name }</P>
                            <P class="subtitle">${way.classify}</P>
                            <hr>	
                            		</c:forEach>
                            	</c:when>
                           	</c:choose>
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-6">
                    <div class="card">
                       <div class="card-header">
                            <div class="pull-left">
                                <h4 class="mt-2">Kỹ năng</h4>
                                <span class="line"></span>  
                            </div>
                        </div>
                        <div class="card-body pb-2">
                          
                          <c:choose>
                          	<c:when test="${not empty skill}">
                          		<c:forEach items="${skill}" var="skill">
                          			 <h6>${skill.name }</h6>
		                            <div class="progress mb-3">
		                                <div class="progress-bar bg-danger" role="progressbar" style="width: ${skill.value}%" aria-valuenow="25" aria-valuemin="0" aria-valuemax="100"></div>
		                            </div>
                          		</c:forEach>
                          	</c:when>
                          </c:choose>                          
                        </div>
                    </div>                   
                </div>
            </div>
        </div>
    </section>   
    <!-- Portfolio Section -->
    <div class="section bg-custom-gray" id="portfolio">
        <div class="container">
            <h1 class="mb-5"><span class="text-danger"></span> Dự án</h1>
            <div class="portfolio">               	              
                <c:choose>
                	<c:when test="${not empty project}">              		
                			 <div class="portfolio-container" style="position: relative; height: 816.887px;"> 
			                    <c:forEach items="${project}" var="pro">
				                    <div class="col-md-6 col-lg-4 web new" style="position: absolute; left: 0px; top: 0px;">
				                        <div class="portfolio-item">
				                            <img src="${pageContext.request.contextPath}/files/${pro.picture}" class="img-fluid" alt="Download free bootstrap 4 admin dashboard, free boootstrap 4 templates">
				                            <div class="content-holder">
				                                <a class="img-popup" href="${pageContext.request.contextPath}/publicUrl/assets/imgs/web-1.jpg"></a>
				                                <div class="text-holder">
				                                    <h6 class="title">${pro.name }</h6>
				                                    <p class="subtitle">${pro.link}</p>
				                                </div>
				                            </div>   
				                        </div>             
				                    </div>  
			                    </c:forEach>                
                			</div>
                	</c:when>
                </c:choose>
            </div>  
        </div>    
                
    </div>
    <!-- End of portfolio section -->

    <section class="section" id="blog">
        <div class="container">
            <h2 class="mb-5">Bài <span class="text-danger">viết</span></h2>
            <div class="row">
              
                <c:choose>
                	<c:when test="${ not empty news }">
                		<c:forEach items="${news}" var ="news">
                			  <div class="blog-card">
				                    <div class="img-holder">
				                        <img src="${pageContext.request.contextPath }/files/${news.picture}" alt="">
				                    </div>
				                    <div class="content-holder">
				                        <h6 class="title">${news.name}</h6>				
				                        <p class="post-details">				                          
				                            <a href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(news.name)}-${news.id}.html"><i class="ti-heart text-danger"></i> ${news.count_views }</a>
				                            <a href="#"><i class="ti-comment"></i> 123</a>
				                        </p>                       
				                        <p>${news.detail }</p>                       				
				                        <a href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(news.name)}-${news.id}.html" class="read-more">Xem thêm <i class="ti-angle-double-right"></i></a>
				                    </div>
				                </div>
                		</c:forEach>
                	</c:when>
                </c:choose>           
            </div>
            	<nav class="text-center" aria-label="...">
					   <ul class="pagination">
					      	<c:choose>
					   		<c:when test="${page == 1 }">
					   			<li class="disabled"><a href="#" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					   		</c:when>
					   		<c:otherwise>
					   			<li class=""><a href="${pageContext.request.contextPath }/index?page=${page - 1 }" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
					   		</c:otherwise>
					   		
					   	</c:choose>
					      	<c:forEach begin="1" end="${numberOffpages }" step ="1" varStatus="item">
					      		<c:choose>
					      			<c:when test="${item.count==page }">
					      				 <li class="active"><a href="${pageContext.request.contextPath }/newsindex?page=${item.count}">${item.count} <span class="sr-only">(current)</span></a></li>
					      			</c:when>
					      			<c:otherwise>
					      				 <li><a href="${pageContext.request.contextPath }/index?page=${item.count}">${item.count }</a></li>
					      			</c:otherwise>
					      		</c:choose>
					      		
					      	</c:forEach>
					     <!--  <li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>
					      <li><a href="#">2</a></li>
					      <li><a href="#">3</a></li>
					      <li><a href="#">4</a></li>
					      <li><a href="#">5</a></li> -->
					     <c:choose>
					   		<c:when test="${page == numberOffpages}">
					   			<li class = "disabled" ><a href="#" aria-label="Next"><span aria-hidden="true">»</span></a></li> 
					   		</c:when>	
					   		<c:otherwise>
					   			<li ><a href="${pageContext.request.contextPath }/index?page=${page + 1}" aria-label="Next"><span aria-hidden="true">»</span></a></li> 
					   		</c:otherwise>					   		
					   	</c:choose>
					   </ul>
				</nav>	   
        </div>
        
    </section>

    <div class="section contact" id="contact">
        <div id="map" class="map"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8">
                    <div class="contact-form-card">
                        <h4 class="contact-title">Send a message</h4>
                        <p><a style="color:red">${msg }</a></p>
                        <form action="${pageContext.request.contextPath}/index " method = "post">
                            <div class="form-group">
                                <input  name="name" class="form-control" type="text" placeholder="Name *" required>
                            </div>
                            <div class="form-group">
                                <input name ="email" class="form-control" type="email" placeholder="Email *" required>
                            </div>
                            <div class="form-group">
                                <input  name = "phone" class="form-control" type="text" placeholder="Phone *" required>
                            </div>
                            <div class="form-group">
                                <input name="address"  class="form-control" type="text" placeholder="Address *" required>
                            </div>
                            <div class="form-group">
                                <textarea name ="content" class="form-control" id=" " placeholder="Message *" rows="7" required></textarea>
                            </div>
                            
                            <div class="form-group ">
                                <button type="submit" class="form-control btn btn-primary" >Send Message</button>
                            </div>
                        </form>
                    </div>
                </div>
              
            </div>

        </div>
    </div>
   
