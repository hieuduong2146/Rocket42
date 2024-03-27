<%@page import="model.bean.DanhMucBanBe"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.CatDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
				 <div class="search">
						 <h3>TÌM BẠN TÔI</h3>
						<form>
							<input type="text" value="" onfocus="this.value=''" onblur="this.value=''">
							<input type="submit" value="">
						</form>
				 </div>
 <div class="categories">
					 <h3>DANH MỤC BẠN BÈ</h3>
					 <%
					 p

					 			 p

					 			 			 	CategoryDao catDao = new CategoryDao();
					 			 			 	ArrayList<DanhMucBanBe> listFr = catDao.getItems();
					 			 			 	for(DanhMucBanBe obj : listFr){
					 %>
					 	<li class="active"><a href="<%=request.getContextPath()%>/thong-tin?ifid=<%=obj.getIdFR() %>"><%=obj.getDanhmucFR() %></a></li>
					<%} %>
					
				 </div>
				
				 <div class="archives">
					 <h3>Liên kết VinaEnter</h3>
					 <li class="active"><a href="http://vinaenter.edu.vn/lap-trinh-php-tu-az.jsp" target="_blank"><img width="100%" src="images/php.png" alt="" /></a></li>
					 <li><a href="http://vinaenter.edu.vn/lap-trinh-java-tu-az.jsp" target="_blank"><img width="100%" src="images/java.png" alt="" /></a></li>
					 <li><a href="http://vinaenter.edu.vn/lap-trinh-android-tu-az.jsp" target="_blank"><img width="100%" src="images/android.png" alt="" /></a></li>
				 </div>
			 </div>
			 <div class="clearfix"></div>
		 </div>
	 </div>
