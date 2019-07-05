<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<head>
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
<script type="text/javascript">

<%   
          java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm"); 
          java.util.Date currentTime = new java.util.Date();//得到当前系统时间 
          String str_date = formatter.format(currentTime); //将日期时间格式化 
 %> 

if($.trim($("#begintime_id").val())!="")
{
      if($.trim($("#endtime_id").val())=="")
      {
            alert("结束时间不允许为空！");
            return;
      }
}
if($.trim($("#endtime_id").val())!="")
{
      if($.trim($("#begintime_id").val())=="")
      {
            alert("开始时间不允许为空！");
            return;
      }
}

</script>
<title>考勤系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/My97DatePicker/WdatePicker.js"></script>
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

						<li class="sub-menu "><a  href="javascript:;">
								<i class="fa fa-book"></i> <span>公司架构</span>
						</a>
							<ul class="sub">
								<li><a  href="Employees_limit">员工</a></li>
								<li><a href="Department_limit">部门</a></li>
								<li><a href="Station_limit">岗位</a></li>
							</ul></li>

                <li class="sub-menu">
                    <a class="active" href="javascript:;">
                        <i class="fa fa-th"></i>
                        <span>考勤数据</span>
                    </a>
                    <ul class="sub">
                        <li><a class="active" href="PunchCard_limit"> 打卡单</a></li>
                        <li><a href="RepairCard_limit"> 补卡单</a></li>
                        <li><a href="Leave_limit"> 请假单</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>考勤报表</span>
                    </a>
                    <ul class="sub">
                        <li><a href="CheckReport.jsp"> 考勤表</a></li>
                    </ul>
                </li>
						<li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>考勤设置</span>
                    </a>
                    <ul class="sub">
                        <li><a href="Class_limit">班次</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>财务管理</span>
                    </a>
                    <ul class="sub">
                        <li><a href="PaySalary_limit">派薪单</a></li>
                    </ul>
                </li>
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
						<h3>打卡单</h3>
						<h6>—编辑</h6>
						<br>
						<!-- 页面页码 -->
						<div id="main">
								<form name="personalForm" method="post" action="PunchCard_add">
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="punchCardMan">打卡人：</label>
								</span> <input type="text" name="punchCardMan" class="text-align" readonly="readonly"
									id="time" placeholder="请输入打卡人姓名" autofocus size="25" title="打卡人姓名"
									value="${sessionScope.User.username}">
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="punchCardDate">打卡时间：</label>
								</span> <input type="text" name="punchCardDate" class="text-align"
									id="time" placeholder="请输入打卡时间" autofocus size="25" title="打卡时间"  readonly="readonly"
									value="<%=str_date%>" class="Wdate">
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl" for="remark">备注：</label>
								</span> <input type="text" name="remark" class="text-align"
									id="remark" placeholder="请输入备注" autofocus size="25" style="height: 100px;" title="备注"
									value='<s:property value="punchCard.remark"/>'>
							</div>
							<div class="kv-item">
								<input type="submit" name="submit" id="submit" value="保存" >
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
