<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
<div class=" sidenav col-sm-3 ">
				<h3 style="margin-left:15px;background-color:#003322;border-radius:4px"><a href="" style="font-size:17px;color:#fff;margin-left: 20px;">Bài viết xem nhiều</a></h3>
					<ul class= "nav nav-pills nav-stacked">	
						<c:choose>
							<c:when test="${not empty count}">
								<c:forEach items="${count}" var="count">
									<li>
										<a><img style ="width :100%;border: 1px solid #ece4e4;" src="${pageContext.request.contextPath }/files/${count.picture}"></a>
																					
										<a href="${pageContext.request.contextPath}/${SlugUtil.makeSlug(count.name)}-${count.id}.html" class ="news" style="width:100%!important;padding:none;font-size:16px;color:#5290C6">${count.name}</a>
									</li>
								</c:forEach>
							</c:when>
						</c:choose>																					
					</ul>
				</div>