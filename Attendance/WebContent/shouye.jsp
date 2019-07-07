<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
.headText {
	color: black;
	font-size: 15px;
	font-weight: 900;
}

.text {
	color: red;
	font-size: 10px;
}

.time {
	color: green;
	font-size: 15px;
}
</style>
<title>Insert title here</title>
</head>
<body onload="time()">
	<div class="headText">
		欢迎管理员：<font color="red" size="2px">${sessionScope.User.username}</font>!
		当前时间:
		<script>
			function time() {
				var time = new Date();
				if (time.getHours() >= 6 && time.getHours() < 12) {
					setInterval(
							"document.getElementById('Time').innerHTML = new Date().getFullYear() + '年' +  new Date().getMonth()+1 + '月'+  new Date().getDate() + '日' + ' 上午' + new Date().getHours() + '点' + new Date().getMinutes() + '分' + new Date().getSeconds() + '秒';",
							1000);
					//setInterval：每隔1000毫秒执行一次方法
				} else if (time.getHours() > 12 && time.getHours() <= 18) {
					setInterval(
							"document.getElementById('Time').innerHTML = new Date().getFullYear() + '年' +  new Date().getMonth()+1 + '月'+  new Date().getDate() + '日' + ' 下午' + new Date().getHours() + '点' + new Date().getMinutes() + '分' + new Date().getSeconds() + '秒';",
							1000);
				} else if (time.getHours() > 18) {
					setInterval(
							"document.getElementById('Time').innerHTML = new Date().getFullYear() + '年' +  new Date().getMonth()+1 + '月'+  new Date().getDate() + '日' + ' 晚上' + new Date().getHours() + '点' + new Date().getMinutes() + '分' + new Date().getSeconds() + '秒';",
							1000);
				} else if (time.getHours() < 6) {
					setInterval(
							"document.getElementById('Time').innerHTML = new Date().getFullYear() + '年' +  new Date().getMonth()+1 + '月'+  new Date().getDate() + '日' + ' 凌晨' + new Date().getHours() + '点' + new Date().getMinutes() + '分' + new Date().getSeconds() + '秒';",
							1000);
				}
			}
		</script>
		<font id="Time" class="time"></font>
	</div>




	<h2>开发团队</h2>
	<table border="1">
		<tr>
			<th align="left" width="400px">版权所有：</th>
			<th align="left" width="400px">4299999999999</th>
		</tr>
		<tr>
			<th align="left" width="400px">开发者：</th>
			<th align="left" width="400px">42999999999999999</th>
		</tr>
	</table>
	<table border="1">
		<tr>
			<th width="800px">感谢林湖钦！</th>
		</tr>
	</table>
</body>
</html>