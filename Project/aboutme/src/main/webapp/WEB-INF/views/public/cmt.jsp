<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ include file="/WEB-INF/templates/taglib.jsp" %>
<c:choose>
	<c:when test="${not empty cc }">
		<c:forEach items="${cc }" var="cc">
			<div class="col-sm-2 text-center">
				<img
					src="${pageContext.request.contextPath}/publicUrl/assets/imgs/111.png"
					style="width: 80px !important;">
			</div>
			<div class="col-sm-10">
				<p>${cc.comment }</p>
				<p>${cc.time}</p>
				<br>
			</div>
		</c:forEach>
	</c:when>
</c:choose>
