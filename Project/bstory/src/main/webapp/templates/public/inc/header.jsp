<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>BStory | VinaEnter Edu</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<%=request.getContextPath() %>/templates/public/css/style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/public/ứcss/coin-slider.css" />
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/templates/admin/assets/js/jquery.validate.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/script.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/templates/public/js/coin-slider.min.js"></script>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
            <li class="active"><a href="<%=request.getContextPath()%>/index"><span>Trang chủ</span></a></li>
            <li><a href="<%=request.getContextPath()%>/contact"><span>Liên hệ</span></a></li>
        </ul>
      </div>
      <div class="logo">
        <h1><a href="index.php">BStory <small>Dự án khóa PHP tại VinaEnter Edu</small></a></h1>
      </div>
      <div class="clr"></div>
      <div class="slider">
        <div id="coin-slider"> <a href="#"><img src="<%=request.getContextPath() %>/templates/public/images/slide1.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="<%=request.getContextPath() %>/templates/public/images/slide2.jpg" width="940" height="310" alt="" /> </a> <a href="#"><img src="<%=request.getContextPath() %>/templates/public/images/slide3.jpg" width="940" height="310" alt="" /> </a> </div>
        <div class="clr"></div>
      </div>
      <div class="clr"></div>
    </div>
  </div>