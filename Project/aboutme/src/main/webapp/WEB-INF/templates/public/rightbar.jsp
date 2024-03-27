<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/templates/taglib.jsp" %>
<div class=" col-sm-3 sidenav">
					<h3 style="background-color:#003322;border-radius:4px;width: 100% !important"><a href="#section1" style=";font-size:17px;margin-left:15px;">Danh mục bài viết</a></h3>
					<ul class="nav nav-pills nav-stacked">
					<c:choose>
						<c:when test="${not empty categories }">
							<c:forEach items="${categories}" var="cat">
								<li>
							<a class=" menu active" style="color:#5290C6;background-color:#FAFAFA;"href="${pageContext.request.contextPath}/danh-muc/${SlugUtil.makeSlug(cat.cname)}-${cat.cid}">${cat.cname}</a><br/>
													
						</li>
							</c:forEach>
						</c:when>
					</c:choose>
						
											
					</ul>
					<div class ="clear"></div>
				</div>