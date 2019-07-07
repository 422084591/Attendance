<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
<script>
	function submit_confirm() {
		var pleaseDummyMan = document.getElementById("pleaseDummyMan").value;
		if (pleaseDummyMan == "") {
			alert("请假人不能为空!");
			return false;
		} else {
			submit();
		}
	}
	function leave() {
		var startTime = document.getElementById("startTime").value;
		var minute = startTime.substring(14, 16);
		var hour = startTime.substring(11, 13);
		var day = startTime.substring(8, 10);
		var month = startTime.substring(5, 7);
		var year = startTime.substring(0, 4);
		var addminute = document.getElementById("minute").value;
		var addhour = document.getElementById("hour").value;
		var addday = document.getElementById("day").value;
		var minuteNumber = Number(minute);
		var hourNumber = Number(hour);
		var dayNumber = Number(day);
		var monthNumber = Number(month);
		var yearNumber = Number(year);
		var addminuteNumber = Number(addminute);
		var addhourNumber = Number(addhour);
		var adddayNumber = Number(addday);
		var newMinute = minuteNumber + addminuteNumber;
		var newHour = hourNumber + addhourNumber;
		var newDay = dayNumber + adddayNumber;
		if (newMinute >= 60) {
			newMinute -= 60;
			newHour += 1;
		}
		if (newHour >= 24) {
			newHour -= 24;
			newDay += 1;

		}
		if ((yearNumber % 4 == 0 && yearNumber % 100 != 0)
				|| yearNumber % 1000 == 0) {
			if (monthNumber == 2) {
				if (newDay > 29) {
					newDay -= 29;
					monthNumber += 1;
				}
			} else {
				if (newDay > 28) {
					newDa -= 28;
					monthNumber += 1;
				}
			}
		}
		if (monthNumber == 4 || monthNumber == 6 || monthNumber == 9
				|| monthNumber == 11) {
			if (newDay > 30) {
				newDay -= 30;
				monthNumber += 1;
			}
		}
		if (monthNumber == 1 || monthNumber == 3 || monthNumber == 5
				|| monthNumber == 7 || monthNumber == 8 || monthNumber == 10) {
			if (newDay > 31) {
				newDay -= 31;
				monthNumber + 1;
			}
		}
		if (monthNumber == 12) {
			if (newDay > 31) {
				newDay -= 31;
				monthNumber = 1;
				yearNumber += 1;
			}
		}
		var y = String(yearNumber);
		if (monthNumber < 10) {
			var mo = '0' + String(monthNumber);
		} else {
			var mo = String(monthNumber);
		}
		if (newDay < 10) {
			var d = '0' + String(newDay);
		} else {
			var d = String(newDay);
		}
		if (newHour < 10) {
			var h = '0' + String(newHour);
		} else {
			var h = String(newHour);
		}
		if (newMinute < 10) {
			var mi = '0' + String(newMinute);
		} else {
			var mi = String(newMinute);
		}
		var newTime = y + '-' + mo + '-' + d + ' ' + h + ':' + mi;
		document.getElementById("endTime").value = newTime;
	}
</script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	list-style: none;
}

body {
	background-color: #95788A;
	font-family: sans-serif, Verdana, Helvetica, Arial;
}

#main {
	padding-left: 350px;
}

.kv-item {
	padding-left: 100px;
	padding-bottom: 20px;
}

.kv-label {
	display: inline;
	height: 28px;
	line-height: 28px;
	margin-left: -100px;
	float: left;
	text-align: right;
	width: 150px;
}

.text-align {
	border: 1px solid #474E63;
	color: #0A1844;
	height: 26px;
	line-height: 26px;
	padding: 0 2px;
	width: 177px;
	text-align: left;
}

#submit {
	margin-left: 80px;
	border: 1px solid #474E63;
	height: 26px;
	font-weight: bold;
}

#reset {
	border: 1px solid #474E63;
	height: 26px;
	font-weight: bold;
}
</style>
<title>考勤系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 



</script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<link href="css/style-responsive.css" rel="stylesheet" />
<!-- font CSS -->
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
</head>

<body>
	<section id="container">
		<!--header start-->
		<!--header start-->
		<header class="header fixed-top clearfix">
			<!--logo start-->
			<div class="brand">
				<a href="index.jsp" class="logo"> 考勤系统V1.0 </a>
				<div class="sidebar-toggle-box">
					<div class="fa fa-bars"></div>
				</div>
			</div>
			<!--logo end-->
			<div class="nav notify-row" id="top_menu">
				<!--  notification start -->
				<ul class="nav top-menu">
					<!-- settings start -->
					<!-- settings end -->
					<!-- inbox dropdown start-->
					<!-- notification dropdown end -->
				</ul>
				<!--  notification end -->
			</div>
			<div class="top-nav clearfix">
				<!--search & user info start-->
				<ul class="nav pull-right top-menu">
					<!-- user login dropdown start-->
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <img alt=""
							src="images/2.png"> <span class="username">${sessionScope.User.username}</span>
							<b class="caret"></b>
					</a>
						<ul class="dropdown-menu extended logout">
							<li><a href="#"><i class=" fa fa-suitcase"></i>个人信息</a></li>
							<li><a href="Login.jsp"><i class="fa fa-key"></i> 退出</a></li>
						</ul></li>
					<!-- user login dropdown end -->

				</ul>
				<!--search & user info end-->
			</div>

		</header>
		<!--header end-->
		<!--sidebar start-->
		<aside>
					<div id="sidebar" class="nav-collapse">
				<!-- sidebar menu start-->
				<div class="leftside-navigation">
					<ul class="sidebar-menu" id="nav-accordion">

						<li class="sub-menu "><a href="javascript:;"> <i
								class="fa fa-book"></i> <span>公司架构</span>
						</a>
							<ul class="sub">
								<li><a  href="Employees_initialize">员工</a></li>
								<li><a  href="Department_initialize">部门</a></li>
								<li><a href="Station_initialize">岗位</a></li>
							</ul></li>

						<li class="sub-menu"><a class="active"  href="javascript:;"> <i
								class="fa fa-th"></i> <span>考勤数据</span>
						</a>
							<ul class="sub">
								<li><a  href="PunchCard_initialize"> 打卡单</a></li>
								<li><a href="RepairCard_initialize"> 补卡单</a></li>
								<li><a class="active" href="Leave_initialize"> 请假单</a></li>
							</ul></li>
						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-tasks"></i> <span>考勤报表</span>
						</a>
							<ul class="sub">
								<li><a href="CheckReport_initialize"> 考勤表</a></li>
							</ul></li>
						<li class="sub-menu"><a href="javascript:;">
								<i class="fa fa-tasks"></i> <span>考勤设置</span>
						</a>
							<ul class="sub">
								<li><a href="Classes_initialize">班次</a></li>
							</ul></li>
						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-tasks"></i> <span>财务管理</span>
						</a>
							<ul class="sub">
								<li><a href="PaySalary_initialize">派薪单</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- sidebar menu end-->
			</div>
		</aside>
		<!--sidebar end-->
		<!--main content start-->
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="table-agile-info">
					<div class="panel panel-default">
						<h3>请假单</h3>
						<h6>—编辑</h6>
						<br>
						<!-- 页面页码 -->
						<div id="main">
							<s:if test="leave.id==0">
								<form name="personalForm" method="post" action="Leave_add">
							</s:if>
							<s:else>
								<form name="personalForm" method="post" action="Leave_update">
									<div class="kv-item">
										<span class="kv-label"> <label class="tsl" for="ID">ID：</label>
										</span> <input readonly="readonly" type="text" name="id"
											class="text-align" id="ID" placeholder="*必填项" autofocus
											size="25" title="ID" value='<s:property value="leave.id"/>'>
									</div>
							</s:else>
							<div class="kv-item">
								<span class="kv-label"><span style="color: red">*</span>
									<label class="tsl" for="pleaseDummyMan">请假人：</label> </span> <input
									type="text" name="pleaseDummyMan" class="text-align"
									id="pleaseDummyMan" placeholder="请输入请假人" autofocus size="25"
									title="请假人" value="${sessionScope.User.username}">
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl" for="time">请假时间：</label>
								</span> <input type="text" name="startTime" class="text-align"
									id="startTime" placeholder="请输入开始日期" autofocus size="25"
									title="开始日"
									onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm',maxDate:'#F{$dp.$D(\'endTime\',{m:-30})}'})">
								<br> <label>↓请在下方选择请假时长↓</label> <br> <label>分钟:</label>
								<select id="minute" name="minute">
									<option value="00">00</option>
									<option value="30">30</option>
								</select> <label>小时:</label> <select id="hour" name="hour">
									<option value="00">00</option>
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
								</select> <label>天数:</label> <select id="day" name="day">
									<option value="00">00</option>
									<option value="01">01</option>
									<option value="02">02</option>
									<option value="03">03</option>
									<option value="04">04</option>
									<option value="05">05</option>
									<option value="06">06</option>
									<option value="07">07</option>
									<option value="08">08</option>
									<option value="09">09</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="13">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
								</select><br>
								<br> <input type="text" name="endTime" id="endTime"
									readonly="readonly" placeholder="请选择请假时长" autofocus size="25"
									title="截止日" onClick="leave()">
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl"
									for="leaveReason">请假原因：</label>
								</span> <input type="text" name="leaveReason" class="text-align"
									id="leaveReason" placeholder="请输入请假原因" autofocus size="25"
									style="height: 100px;" title="备注"
									value='<s:property value="leave.leaveReason"/>'>
							</div>
							<div class="kv-item">
								<input type="submit" name="submit" id="submit" value="保存"
									onclick="return submit_confirm()">
							</div>
						</div>
					</div>

				</div>
			</section>
			<!-- footer -->
			<div class="footer">
				<div class="wthree-copyright"></div>
			</div>
			<!-- / footer -->
		</section>

		<!--main content end-->
	</section>
	<script src="js/bootstrap.js"></script>
	<script src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/jquery.slimscroll.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<!--[if lte IE 8]><script language="javascript" type="text/javascript" src="js/flot-chart/excanvas.min.js"></script><![endif]-->
	<script src="js/jquery.scrollTo.js"></script>
</body>
</html>
