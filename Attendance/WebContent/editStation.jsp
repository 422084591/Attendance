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
<title>考勤系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
	 function submit_confirm(){
		 var stationCode = document.getElementById("stationCode").value;
		 var stationName = document.getElementById("stationName").value;
		 if(stationCode==""){
			 alert("岗位编码不能为空!");
			 return false;
		 }
		 else if(stationName==""){
			 alert("岗位名称不能为空!");
			 return false;
		 }
		 else{
			 submit();
		 }
	 }

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
		<header class="header fixed-top clearfix">
			<!--logo start-->
			<div class="brand">
				<a href="index.jsp" class="logo"> 考勤系统V1.0 </a>
				<div class="sidebar-toggle-box">
					<div class="fa fa-bars"></div>
				</div>
			</div>
			<!--logo end-->
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
							<li><a href="editPassword.jsp"><i class=" fa fa-suitcase"></i>修改密码</a></li>
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

						<li class="sub-menu "><a class="active" href="javascript:;"> <i
								class="fa fa-book"></i> <span>公司架构</span>
						</a>
							<ul class="sub">
								<li><a  href="Employees_initialize">员工</a></li>
								<li><a  href="Department_initialize">部门</a></li>
								<li><a  class="active" href="Station_initialize">岗位</a></li>
							</ul></li>

						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-th"></i> <span>考勤数据</span>
						</a>
							<ul class="sub">
								<li><a href="PunchCard_initialize"> 打卡单</a></li>
								<li><a href="RepairCard_initialize"> 补卡单</a></li>
								<li><a href="Leave_initialize"> 请假单</a></li>
							</ul></li>
						<li class="sub-menu"><a href="javascript:;"> <i
								class="fa fa-tasks"></i> <span>考勤报表</span>
						</a>
							<ul class="sub">
								<li><a href="CheckReport_initialize"> 考勤表</a></li>
							</ul></li>
						<li class="sub-menu"><a  href="javascript:;">
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
		<section id="main-content">
			<section class="wrapper">
				<div class="table-agile-info">
					<div class="panel panel-default">

						<h3>岗位</h3>
						<h6>—编辑</h6>
						<br>
						<div id="main">
							<s:if test="station.stationId==0">
								<form name="personalForm" method="post" action="Station_add">
							</s:if>
							<s:else>
								<form name="personalForm" method="post" action="Station_update">
							</s:else>
							<s:if test="station.stationId!=0">
								<div class="kv-item">
									<span class="kv-label"> <label class="tsl" for="ID">岗位ID：</label>
									</span> 
									<input readonly="readonly" type="text" name="stationId" class="text-align" id="Id" placeholder="*必填项" autofocus size="25" title="Id" value='<s:property value="station.stationId"/>'>
								</div>
							</s:if>
							<div class="kv-item">
								<span class="kv-label"><span style="color: red">*</span>
									<label class="tsl" for="number">岗位编码：</label> </span> 
									<input type="text" name="stationCode" class="text-align" id="stationCode" placeholder="请输入岗位编码" autofocus size="25" title="岗位编码" value='<s:property value="station.stationCode"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color: red">*</span>
									<label class="tsl" for="name">岗位名称：</label> </span> 
									<input type="text" name="stationName" class="text-align" id="stationName" placeholder="请输入岗位名称" size="25" title="岗位名称" value='<s:property value="station.stationName"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><label class="tsl"
									for="department">所在部门：</label> </span> 
									<select name="department">
									<s:iterator value="departmentList" id="s">
										<option value='<s:property value="#s.departmentCode" />'>
											<s:property value="#s.departmentCode"></s:property> -
											<s:property value="#s.departmentName"></s:property></option>
									</s:iterator>
								</select>
							</div>
							<div class="kv-item">
								<span class="kv-label"><label class="tsl"
									for="immediateSuperior">直接上级：</label> </span> 
									<select name="immediateSuperior">
									<s:iterator value="stationList" id="s">
										<option value='<s:property value="#s.stationId" />'>
											<s:property value="#s.stationCode"></s:property> -
											<s:property value="#s.stationName"></s:property></option>
									</s:iterator>
								</select>
							</div>
							<div class="kv-item">
								<span class="kv-label"><label class="tsl"
									for="stationCategory">岗位类别：</label> </span> 
									<select name="stationCategory">
									<option value="管理类" selected="selected">管理类</option>
									<option value="技术类">技术类</option>
									<option value="文职类">文职类</option>
								</select>
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl"
									for="higher-up">岗位职责：</label>
								</span> 
								<input type="text" name="stationDescription" class="text-align" id="stationResponsibility" placeholder="请输入岗位职责" size="25" style="height: 100px;" title="岗位职责" value='<s:property value="station.stationDescription"/>'>
							</div>
							<div class="kv-item">
								<input type="submit" name="submit" id="submit" value="保存" onclick="return submit_confirm()">
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
