<%@page import="model.bean.TinTuc"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
			<div class="content-left fl">
				<%@include file="inc/left_bar.jsp" %>
			</div>
			<div class="content-right fr">
				<%

				TinTuc objTT = (TinTuc)request.getAttribute("objTT");
							if(objTT != null){
				%>
				<h3><%=objTT.getName() %></h3>
				<div class="main-content">
					
					<p><%=objTT.getDetail_text() %></p>
				</div>
				<%} %>
			</div>
<%@include file="inc/footer.jsp" %>