<%@page import="vn.edu.vinaenter.util.SlugUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/templates/taglib.jsp" %>
		
			
				<div class="col-sm-6">
					<br>
					<h2 style="color:#003322"> ${catid.cname}</h2>
					<hr>				
					<br>
					<div class="row">
						<c:choose>
							<c:when test="${not empty listCat }">
								<c:forEach items="${listCat}" var="listCat">
															
										<div class="col-sm-6">
											
												<a href=""></a>
												<img href="" style="width: 100%; height:180px;border: 2px solid #ece4e4;" src="${pageContext.request.contextPath }/files/${listCat.picture}"><br>							
												<h3><a href ="${pageContext.request.contextPath}/${SlugUtil.makeSlug(listCat.name)}-${listCat.id}.html" style="font-size:15px;line-height: 1.1;font-weight: 500;margin-top: 
												15px;margin-bottom: 15px;color:#5290C6">${listCat.name }</a></h3>
												<br>										
										</div>										
								</c:forEach>
							</c:when>
						</c:choose>	
					</div>
					<div class ="clear"></div>
					<div class ="clear"></div>																											
				</div>
				
				
		
					