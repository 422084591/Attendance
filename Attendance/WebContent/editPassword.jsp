<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<style>
.code{
background-image:url(images/bg.jpg);
font-family:Arial;
font-style:italic;
color:Red;
border:0;
padding:2px 3px;
letter-spacing:3px;
</style>
<title>修改密码</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet" />
<!-- font CSS -->
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
</head>
<body>
<div class="log-w3">
		<div class="w3layouts-main">
			<h2>Change Password</h2>
			<form name="login" action="Attendance_changePassword" method="post"
				accept-charset="utf-8">
				<a>用户名</a><input type="text" class="ggg" name="username" placeholder="Username" value="${sessionScope.User.username}" readonly="readonly"> 				
				<a>新的密码</a>${requestScope.error }
				<input type="password" class="ggg"name="password" placeholder="New Password"> 					
				<a>确认密码</a><input type="password" class="ggg"name="password2" placeholder="Confirm Password"> 
				<input type="submit" value="Submit" name="login">
			</form>
		</div>
	</div>
	<script src="js/bootstrap.js"></script>
	<script src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/jquery.slimscroll.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
