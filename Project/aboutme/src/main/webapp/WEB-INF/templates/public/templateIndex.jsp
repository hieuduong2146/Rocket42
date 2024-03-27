<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/WEB-INF/templates/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Start your development with JohnDoe landing page.">
    <meta name="author" content="Devcrud">
    <title>Hiếu Dương page</title>
    <!-- font icons -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/publicUrl/assets/vendors/themify-icons/css/themify-icons.css">
    <!-- Bootstrap + JohnDoe main styles -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/publicUrl/assets/css/johndoe.css">
	 <script type = "text/javascript" src="${pageContext.request.contextPath}/publicUrl/assets/js/jquery-2.1.1.min.js"></script>	
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">
    <a href="components.html" class="btn btn-primary btn-component" data-spy="affix" data-offset-top="600"><i class="ti-shift-left-alt"></i> Components</a>
    <header class="header">
        <div class="container">
            <ul class="social-icons pt-3">
                <li class="social-item"><a class="social-link text-light" href="#"><i class="ti-facebook" aria-hidden="true"></i></a></li>
                <li class="social-item"><a class="social-link text-light" href="#"><i class="ti-twitter" aria-hidden="true"></i></a></li>
                <li class="social-item"><a class="social-link text-light" href="#"><i class="ti-google" aria-hidden="true"></i></a></li>
                <li class="social-item"><a class="social-link text-light" href="#"><i class="ti-instagram" aria-hidden="true"></i></a></li>
                <li class="social-item"><a class="social-link text-light" href="#"><i class="ti-github" aria-hidden="true"></i></a></li>
            </ul>  
            <div class="header-content">
                <h4 class="header-subtitle" >Xin Chào!Tôi là</h4><br>
                <br>
                <h1 class="header-title">Hiếu Dương </h1>
                <h6 class="header-mono" >Backend  Designer | Developer</h6>
                
            </div>
        </div>
    </header>
    <tiles:insertAttribute name="header"/> 
   
        <tiles:insertAttribute name="body"/> 
    
   <tiles:insertAttribute name="footer"/> 

	<!-- core  -->
    <script src="${pageContext.request.contextPath}/publicUrl/assets/vendors/jquery/jquery-3.4.1.js"></script>
    <script src="${pageContext.request.contextPath}/publicUrl/assets/vendors/bootstrap/bootstrap.bundle.js"></script>

    <!-- bootstrap 3 affix -->
    <script src="${pageContext.request.contextPath}/publicUrl/assets/vendors/bootstrap/bootstrap.affix.js"></script>

    <!-- Isotope  -->
    <script src="${pageContext.request.contextPath}/publicUrl/assets/vendors/isotope/isotope.pkgd.js"></script>
    
    <!-- Google mpas -->
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCtme10pzgKSPeJVJrG1O3tjR6lk98o4w8&callback=initMap"></script>

    <!-- JohnDoe js -->
    <script src="${pageContext.request.contextPath}/publicUrl/assets/js/johndoe.js"></script>

</body>
</html>
