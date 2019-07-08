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
<script type="text/javascript">
var code ; //在全局 定义验证码
function createCode(){  
code = "";
var codeLength = 4;//验证码的长度
var checkCode = document.getElementById("checkCode");
checkCode.value = "";
var selectChar = new Array(1,2,3,4,5,6,7,8,9,'a','b','c','d','e','f','g','h','j','k','l','m','n','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','J','K','L','M','N','P','Q','R','S','T','U','V','W','X','Y','Z');
for(var i=0;i<codeLength;i++) {
var charIndex = Math.floor(Math.random()*60);
code +=selectChar[charIndex];
}
if(code.length != codeLength){
createCode();
}
checkCode.value = code;
}
function validate () {
var inputCode = document.getElementById("input1").value.toUpperCase();
var codeToUp=code.toUpperCase();
if(inputCode.length <=0) {
alert("请输入验证码！");
return false;
}
else if(inputCode != codeToUp ){
alert("验证码输入错误！");
createCode();
return false;
}
else {
return true;
}
}
</script>
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
<body onload="createCode();">
	<div class="log-w3">
		<div class="w3layouts-main">
			<h2>Sign In Now</h2>
			<form name="login" action="Attendance_login" method="post"
				accept-charset="utf-8">
				<div id="msg" class="">${requestScope.error}</div>
				<input type="text" class="ggg" name="username" placeholder="Username"> 
					<input type="password" class="ggg" name="password" placeholder="Password">
					<a>验证码：</a><input type="text" id="checkCode" class="code" style="width: 55px" /> <a href="#" onclick="createCode()" >换一张</a>
					<input type="text" id="input1" class="ggg" /><br>
					 <input type="submit" value="Sign In" name="login" onclick="return validate();">
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
