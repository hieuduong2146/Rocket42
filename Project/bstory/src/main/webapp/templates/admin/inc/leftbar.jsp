<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="text-center">
                <img src="<%=request.getContextPath() %>/templates/admin/assets/img/find_user.png" class="user-image img-responsive" />
            </li>


            <li>
                <a id="index" href="<%=request.getContextPath()%>/admin/index"><i class="fa fa-dashboard fa-3x"></i> Trang chủ</a>
            </li>
            <li>
                <a id="category" href="<%=request.getContextPath()%>/admin/cats"><i class="fa fa-bar-chart-o fa-3x"></i> Quản lý danh mục</a>
            </li>
            <li>
                <a id="story" href="<%=request.getContextPath()%>/admin/str"><i class="fa fa-qrcode fa-3x"></i> Quản lý truyện</a>
            </li>
            <li>
                <a id="user" href="<%=request.getContextPath()%>/admin/user"><i class="fa fa-sitemap fa-3x"></i> Quản lý người dùng</a>
            </li>
             <li>
                <a id="contact" href="<%=request.getContextPath()%>/admin/contact"><i class="fa fa-sitemap fa-3x"></i> Quản lý liên hệ</a>
            </li>

        </ul>

    </div>

</nav>
<!-- /. NAV SIDE  -->