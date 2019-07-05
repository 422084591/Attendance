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
							src="images/2.png"> <span class="username">${sessionScope.User.username}</span> <b
							class="caret"></b>
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

						<li class="sub-menu "><a class="active" href="javascript:;">
								<i class="fa fa-book"></i> <span>公司架构</span>
						</a>
							<ul class="sub">
								<li><a class="active" href="Employees_limit">员工</a></li>
								<li><a href="Department_limit">部门</a></li>
								<li><a href="Station_limit">岗位</a></li>
							</ul></li>

                <li class="sub-menu">
                    <a  href="javascript:;">
                        <i class="fa fa-th"></i>
                        <span>考勤数据</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="PunchCard_limit"> 打卡单</a></li>
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
						<h3>员工</h3>
						<h6>—编辑</h6>
						<br>
						<!-- 页面页码 -->
						<div id="main">
							<s:if test="employee.emp_id==0">
								<form name="personalForm" method="post" action="Employees_add">
							</s:if>
							<s:else>
								<form name="personalForm" method="post"
									action="Employees_update">
							</s:else>
							<s:if test="employee.emp_id!=0">
								<div class="kv-item">
									<span class="kv-label"> <label class="tsl" for="ID">Emp_ID：</label>
									</span> <input readonly="readonly" type="text" name="emp_id"
										class="text-align" id="ID" placeholder="*必填项" autofocus
										size="25" title="Emp_ID"
										value='<s:property value="employee.emp_id"/>'>
								</div>
							</s:if>

							<div class="kv-item">
								<span class="kv-label"> <span style="color:red">*</span> <label class="tsl" for="number">员工编码：</label>
								</span> <input type="text" name="staffCode" class="text-align"
									id="number" placeholder="请输入员工编码" autofocus size="25" title="员工编码"
									value='<s:property value="employee.staffCode"/>'><span style="color:red">*</span> 
									<label style=" color:#CC3300" class="tsl" for="number">将会成为您唯一的登录名</label>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="name">姓名：</label>
								</span> <input type="text" name="name" class="text-align" id="name"
									placeholder="请输入姓名" size="25" title="姓名"
									value='<s:property value="employee.name"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="sex_boy">性别：</label>
								</span> <input type="radio" name="sex" id="sex_boy" value="男" checked>
								男 <input type="radio" name="sex" id="sex_girl" value="女">女
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="age">年龄：</label>
								</span> <input type="text" name="age" class="text-align" id="age"
									placeholder="请输入年龄" size="25" title="年龄"
									value='<s:property value="employee.age"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="national">民族：</label>
								</span> <input type="text" name="nation" class="text-align"
									id="national" placeholder="请输入民族" size="25" title="民族"
									value='<s:property value="employee.nation"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="IDcard">身份证：</label>
								</span> <input type="text" name="idNumber" class="text-align"
									id="IDcard" placeholder="请输入身份证" size="25" title="身份证"
									value='<s:property value="employee.idNumber"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><label class="tsl" for="salary">薪水：</label>
								</span> <input type="text" name="salary" class="text-align" id="salary"
									placeholder="请输入薪水" size="25" title="薪水"
									value='<s:property value="employee.salary"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="emergencyContact">联系电话：</label>
								</span> <input type="text" name="phone" class="text-align"
									id="emergencyContact" placeholder="请输入联系电话" size="25" title="联系电话"
									value='<s:property value="employee.phone"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><span style="color:red">*</span> <label class="tsl" for="emergencyContactNumber">紧急联系人：</label>
								</span> <input type="text" name="emergencyContact" class="text-align"
									id="emergencyContactNumber" placeholder="请输入紧急联系人" size="25" title="紧急联系人"
									value='<s:property value="employee.emergencyContact"/>'>
							</div>
							<div class="kv-item">
								<span class="kv-label"><label class="tsl" for="stationId">岗位：</label>
								</span> <select name="stationId">
								<s:iterator value="stationList" id="s">
									<option value='<s:property value="#s.stationId" />'  selected="selected">
									<s:property value="#s.stationCode"></s:property>
									-
									<s:property value="#s.stationName"></s:property></option>
									</s:iterator>
								</select>
							</div>
							<div class="kv-item">
								<span class="kv-label"> <label class="tsl" for="individualDescription">个人描述：</label>
								</span> <input type="text" name="individualDescription" class="text-align"
									id="individualDescription" placeholder="请输入个人描述" autofocus size="25" style="height: 100px;" title="备注"
									value='<s:property value="employee.individualDescription"/>'>
							</div>
							<div class="kv-item">
								<input type="submit" name="submit" id="submit" value="保存">
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
