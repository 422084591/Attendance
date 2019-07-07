<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<head>
<title>登录</title>
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
<script src="js/jquery2.0.3.min.js"></script>
</head>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("input[name='username']").blur(verifyUsername);
	});
	function verifyUsername() {
		$.ajax({
			url : encodeURI("Attendance_ajax"),
			type : "post",
			data : {
				username : $("input[name='username']").val()
			},
			dataType : "json",
			cache : false,
			success : function(msg) {
				if (msg.isSuccess) {
					$("#msg").html("<font color='green'>用户名正确</font>");
				} else {
					$("#msg").html("<font color='red'>用户名错误</font>");
				}
			}
		});
	}
</script>
<body>
	<div class="log-w3">
		<div class="w3layouts-main">
			<h2>Sign In Now</h2>
			<form name="login" action="Attendance_login" method="post"
				accept-charset="utf-8">
				<div id="msg" class="">${requestScope.error}</div>
				<input type="text" class="ggg" name="username"
					placeholder="Username"> <input type="password" class="ggg"
					name="password" placeholder="Password"> <input
					type="submit" value="Sign In" name="login">
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
