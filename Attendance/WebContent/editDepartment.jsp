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
		 var number = document.getElementById("number").value;
		 var name = document.getElementById("name").value;
		 if(number==""){
			 alert("部门编码不能为空!");
			 return false;
		 }
		 else if(name==""){
			 alert("部门名称不能为空!");
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

						<li class="sub-menu "><a class="active" href="javascript:;"> <i
								class="fa fa-book"></i> <span>公司架构</span>
						</a>
							<ul class="sub">
								<li><a href="Employees_initialize">员工</a></li>
								<li><a  class="active" href="Department_initialize">部门</a></li>
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
		<!--sidebar end-->
		<!--main content start-->
		<section id="main-content">
			<section class="wrapper">
				<div class="table-agile-info">
					<div class="panel panel-default">

						<h3>部门</h3>
						<h6>—编辑</h6>
						<br>
						<div id="main">
							<s:if test="department.departmentID==0">
								<form name="personalForm" method="post" action="Department_add">
							</s:if>
							<s:else>
								<form name="personalForm" method="post"
									action="Department_update">
							</s:else>
							<s:if test="department.departmentID!=0">
								<div class="kv-item">
									<span class="kv-label"> <label class="tsl" for="ID">部门ID：</label>
									</span> <input readonly="readonly" type="text" name="departmentID"
										class="text-align" id="ID" placeholder="*必填项" autofocus
										size="25" title="Emp_ID"
										value='<s:property value="department.departmentID"/>'>
								</div>
							</s:if>
							<div class="kv-item">
								<span class="kv-label"><span style="color: red">*</span>
									<label class="tsl" for="number">部门编码：</label> </span> <input
									type="text" name="departmentCode" class="text-align"
									id="number" placeholder="请输入部门编码" autofocus size="25"
									title="部门编码"
									value='<s:property value="department.departmentCode"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color: red">*</span>
									<label class="tsl" for="name">部门名称：</label> </span> <input type="text"
									name="departmentName" class="text-align" id="name"
									placeholder="请输入部门名称" size="50" title="部门名称"
									value='<s:property value="department.departmentName"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><label class="tsl"
									for="departmentHead">部门负责人：</label> </span> <select
									name="departmentHead">
									<s:iterator value="employeesList" id="e">
										<option name="departmentHead"
											value='<s:property value="#e.name" />'>
											<s:property value="#e.staffCode"></s:property> -
											<s:property value="#e.name"></s:property></option>
										</option>
									</s:iterator>
								</select>
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl" for="duty">部门职责：</label>
								</span> <input type="text" name="departmentResponsibility"
									class="text-align" id="duty" placeholder="请输入部门职责" size="25"
									title="部门职责"
									value='<s:property value="department.departmentResponsibility"/>'>
							</div>
									<div class="kv-item">
								<span class="kv-label"><label class="tsl"
									for="superiorDepartmentId">上级部门：</label> </span> <select
									name="superiorDepartmentId">
									<s:iterator value="departmentList" id="d">
										<option name="superiorDepartmentId"
											value='<s:property value="#d.departmentID" />'>
											<s:property value="#d.departmentID"></s:property> -
											<s:property value="#d.departmentName"></s:property></option>
										</option>
									</s:iterator>
								</select>
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl"
									for="higher-up">备注：</label>
								</span> <input type="text" name="remark" class="text-align" id="remark"
									placeholder="请输入备注" size="25" style="height: 100px;" title="备注"
									value='<s:property value="department.remark"/>'>
							</div>
							<div class="kv-item">
								<input type="submit" name="submit" id="submit" value="保存"
									onclick="return submit_confirm()">
							</div>
							</form>
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
