<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
		  <div class="col-md-2">
		  	<div class="sidebar content-box" style="display: block;">
                <!-- Nav-bar -->
				<ul class="nav">
				    <!-- Main menu -->
				    <li class="current"><a href="${pageContext.request.contextPath }/admincp"><i class="glyphicon glyphicon-home"></i> Trang chủ</a></li>
				    <li class="submenu">
				         <a href="#">
				            <i class="glyphicon glyphicon-list"></i> Quản lý bài viết	
				            <span class="caret pull-right"></span>
				         </a>
				         <!-- Sub menu -->
				         <ul>
				            <li><a href="${pageContext.request.contextPath }/admin/news/index">Tin Tức</a></li>				            
				            <li><a href="${pageContext.request.contextPath }/admin/cat/index">Danh mục</a></li>
				            <li><a href="${pageContext.request.contextPath }/admin/cmt/index">Bình Luận</a></li>
				        </ul>
				    </li>				    				   
				   	 <li><a href="${pageContext.request.contextPath }/admin/contact/index"><i class="glyphicon glyphicon-book"></i> Quản lý liên hệ</a></li>				    				    			   	  					 
				    <li><a href="${pageContext.request.contextPath }/admin/user/index"><i class="glyphicon glyphicon-book"></i> Quản lý người dùng</a></li>
				     <li class="submenu">
				         <a href="#">
				            <i class="glyphicon glyphicon-list"></i> Quản lý thông tin
				            <span class="caret pull-right"></span>
				         </a>
				         <!-- Sub menu -->
				         <ul>
				            <li><a href="${pageContext.request.contextPath }/admin/infor/index">Thông tin</a></li>
				            <li><a href="${pageContext.request.contextPath }/admin/skill/index">Kỹ năng</a></li>
				             <li><a href="${pageContext.request.contextPath }/admin/project/index">Dự án</a></li>
				              <li><a href="${pageContext.request.contextPath }/admin/way/index">Chặng đường</a></li>
				        </ul>
				    </li>			
				    
				</ul>
				<!-- /.nav-bar -->
             </div>
		  </div>
		 