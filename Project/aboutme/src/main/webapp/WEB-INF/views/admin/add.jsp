<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- header -->
<!DOCTYPE html>
<html>
  <head>
    <title>Bootstrap Admin Theme v3</title>
    <link rel="shortcut icon" type="image/ico" href="images/icon-180x180.png" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- styles -->
    <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">
    <link href="css/style1.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<div class="header">
	     <div class="container">
	        <div class="row">
	           <div class="col-md-5">
	              <!-- Logo -->
	              <div class="logo">
	                 <h1><a href="index.html">VNE-Admin</a></h1>
	              </div>
	           </div>
	           <div class="col-md-5">
	              <div class="row">
	                <div class="col-lg-12"></div>
	              </div>
	           </div>
	           <div class="col-md-2">
	              <div class="navbar navbar-inverse" role="banner">
	                  <nav class="collapse navbar-collapse bs-navbar-collapse navbar-right" role="navigation">
	                    <ul class="nav navbar-nav">
	                      <li class="dropdown">
	                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Account <b class="caret"></b></a>
	                        <ul class="dropdown-menu animated fadeInUp">
	                          <li><a href="profile.html">Profile</a></li>
	                          <li><a href="login.html">Logout</a></li>
	                        </ul>
	                      </li>
	                    </ul>
	                  </nav>
	              </div>
	           </div>
	        </div>
	     </div>
	</div>
<!-- /.header -->

    <div class="page-content">
    	<div class="row">
		  <div class="col-md-2">
		  	<div class="sidebar content-box" style="display: block;">
                <!-- Nav-bar -->
				<ul class="nav">
				    <!-- Main menu -->
				    <li class="current"><a href="index.html"><i class="glyphicon glyphicon-home"></i> Trang chá»§</a></li>
				    <li><a href="cat.html"><i class="glyphicon glyphicon-list"></i> Danh má»¥c</a></li>
				    <li><a href="news.html"><i class="glyphicon glyphicon-book"></i> Truyá»n</a></li>
				    <li><a href="add.html"><i class="glyphicon glyphicon-plus"></i> ThÃªm</a></li>
				    <li class="submenu">
				         <a href="#">
				            <i class="glyphicon glyphicon-list"></i> Pages
				            <span class="caret pull-right"></span>
				         </a>
				         <!-- Sub menu -->
				         <ul>
				            <li><a href="login.html">Login</a></li>
				            <li><a href="javascript:void(0)">Signup</a></li>
				        </ul>
				    </li>
				</ul>
				<!-- /.nav-bar -->
             </div>
		  </div>
		  <div class="col-md-10">

	  			<div class="row">
	  				<div class="col-md-12 panel-info">
			  			<div class="content-box-header panel-heading">
		  					<div class="panel-title ">ThÃªm danh má»¥c</div>
			  			</div>
			  			<div class="content-box-large box-with-header">
				  			<div>
								<div class="row mb-10"></div>
								
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label for="name">TÃªn truyá»n</label>
											<input type="text" class="form-control" placeholder="Nháº­p tÃªn truyá»n">
										</div>
										
										<div class="form-group">
											<label>Danh má»¥c truyá»n</label>
											<select class="form-control">
											   <option>Amsterdam</option>
											   <option>Atlanta</option>
											   <option>Baltimore</option>
											   <option>Boston</option>
											</select>
										</div>

										<div class="form-group">
											<label>ThÃªm hÃ¬nh áº£nh</label>
											<input type="file" class="btn btn-default" id="exampleInputFile1">
											<p class="help-block"><em>Äá»nh dáº¡ng: jpg, png, jpeg,...</em></p>
										</div>
										
										<div class="form-group">
										   <label>MÃ´ táº£</label>
										   <textarea class="form-control" rows="3"></textarea>
										</div>

										
									</div>

									<div class="col-sm-6"></div>

									<div class="col-sm-12">
										<div class="form-group">
										   <label>Chi tiáº¿t</label>
										   <textarea class="form-control" rows="7"></textarea>
										</div>
									</div>
								</div>

								<hr>

								<div class="row">
									<div class="col-sm-12">
										<input type="submit" value="ThÃªm" class="btn btn-success" />
										<input type="reset" value="Nháº­p láº¡i" class="btn btn-default" />
									</div>
								</div>

							</div>
						</div>
			  		</div>
	  			</div><!-- /.row col-size -->
	  		
		  </div><!-- /.col-md-10 -->
		</div><!-- /.row -->
    </div><!-- Page content -->

   <!-- footer -->
      <footer>
         <div class="container">
         
            <div class="copy text-center">
               Copyright 2017 &copy; <a href='#'>Vinaenter Edu</a>
            </div>
            
         </div>
      </footer>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/custom.js"></script>
  </body>
</html>