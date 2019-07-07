<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
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
<title>考勤系统</title>
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
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic'
	rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css" />
<link href="css/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/morris.css" type="text/css" />
<!-- calendar -->
<link rel="stylesheet" href="css/monthly.css">
<!-- //calendar -->
<!-- //font-awesome icons -->
<script src="js/jquery2.0.3.min.js"></script>
<script src="js/raphael-min.js"></script>
<script src="js/morris.js"></script>
</head>
<body onload="time()">
	<section id="container">
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
								<li><a href="Employees_initialize">员工</a></li>
								<li><a href="Department_initialize">部门</a></li>
								<li><a href="Station_initialize">岗位</a></li>
							</ul></li>

						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-th"></i> <span>考勤数据</span>
						</a>
							<ul class="sub">
								<li><a href="PunchCard_initialize"> 打卡单</a></li>
								<li><a href="RepairCard_initialize"> 补卡单</a></li>
								<li><a href="Leave_initialize"> 请假单</a></li>
							</ul></li>
						<li class="sub-menu"><a href="javascript:;">
								<i class="fa fa-tasks"></i> <span>考勤报表</span>
						</a>
							<ul class="sub">
								<li><a href="CheckReport_initialize">
										考勤表</a></li>
							</ul></li>
						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-tasks"></i> <span>考勤设置</span>
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
		<section id="main-content">
			<section class="wrapper">
				<!-- //market-->
				<!-- //market-->
				<div onload="time()">
					<div class="panel-body" align="center">
						<div class="headText">
							<h2>欢迎管理员：<font color="red" >${sessionScope.User.username}</font>!</h2>
							<script>
								function time() {
									var time = new Date();
									if (time.getHours() >= 6
											&& time.getHours() < 12) {
										setInterval(
												"document.getElementById('Time').innerHTML = new Date().getFullYear() + '年' +  new Date().getMonth()+1 + '月'+  new Date().getDate() + '日' + ' 上午' + new Date().getHours() + '点' + new Date().getMinutes() + '分' + new Date().getSeconds() + '秒';",
												1000);
										//setInterval：每隔1000毫秒执行一次方法
									} else if (time.getHours() > 12
											&& time.getHours() <= 18) {
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
							<div align="right"<font id="Time" class="time"></font>></div>
						</div>
						<br> <br> <br> <br>
						<br> <br>
						<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
						<div id="main" style="width: 800px; height: 600px;"></div>
					</div>
				</div>

			</section>
		</section>
	</section>
	<script src="js/bootstrap.js"></script>
	<script src="js/jquery.dcjqaccordion.2.7.js"></script>
	<script src="js/scripts.js"></script>
	<script src="js/jquery.slimscroll.js"></script>
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/jquery.scrollTo.js"></script>
	<!-- calendar -->
	<script type="text/javascript" src="js/monthly.js"></script>
	<!-- 引入 echarts.js -->
	<script src="js/echarts.min.js"></script>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		//这个option的json格式是官方提供的，只需要按照这个格式写就行了
		var option = {
			title : {
				text : '考勤报表',
			},
			tooltip : {
				show : true
			},
			legend : {
				data : [ '正常', '早退', '迟到', '旷工' ]
			},
			xAxis : [ {
				type : 'value'

			} ],
			yAxis : [ {
				type : 'category',
			} ],
			series : [ {
				"name" : "正常",
				"type" : "bar",
			}, {
				"name" : "迟到",
				"type" : "bar",
			}, {
				"name" : "早退",
				"type" : "bar",
			}, {
				"name" : "旷工",
				"type" : "bar",
			} ]
		};

		//调用load函数，用于从后台获得数据并且传给option中的xAxis以及series（这两个用于显示柱状图）
		load(option);
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
		//利用ajax技术从后台获取数据并且给option
		function load(option) {
			$.ajax({
				type : "post",
				async : false, //同步执行
				url : "CheckReport_getData", //后台处理的servlet路径
				data : {},
				dataType : "json", //返回数据形式为json
				success : function(result) { //如果ajax成功则后台json返回到result中
					if (result) {
						//初始化option.xAxis[0]中的data，就是给option中的xAxis加入data[]
						option.yAxis[0].data = [];
						for (var i = 0; i < result.length; i++) {
							option.yAxis[0].data.push(result[i].date);
						}
						//初始化option.series[0]中的data
						option.series[0].data = [];
						for (var i = 0; i < result.length; i++) {
							option.series[0].data.push(result[i].normal_num);
						}
						option.series[1].data = [];
						for (var i = 0; i < result.length; i++) {
							option.series[1].data.push(result[i].late_num);
						}
						option.series[2].data = [];
						for (var i = 0; i < result.length; i++) {
							option.series[2].data
									.push(result[i].leaveEarly_num);
						}
						option.series[3].data = [];
						for (var i = 0; i < result.length; i++) {
							option.series[3].data
									.push(result[i].absenteeism_num);
						}
					}
				}
			});
		}
	</script>
</body>
</html>
