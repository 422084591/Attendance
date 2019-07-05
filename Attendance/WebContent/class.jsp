<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<head>
<title>考勤系统</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<script type="text/javascript">
	function delete_confirm() {
		if (confirm("是否确认删除？")) {
			submit();
		} else {
			return false;
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

						<li class="sub-menu "><a  href="javascript:;">
								<i class="fa fa-book"></i> <span>公司架构</span>
						</a>
							<ul class="sub">
								<li><a  href="Employees_initialize">员工</a></li>
								<li><a href="Department_initialize">部门</a></li>
								<li><a href="Station_initialize">岗位</a></li>
							</ul></li>

                <li class="sub-menu">
                    <a  href="javascript:;">
                        <i class="fa fa-th"></i>
                        <span>考勤数据</span>
                    </a>
                    <ul class="sub">
                        <li><a  href="PunchCard_initialize"> 打卡单</a></li>
                        <li><a href="RepairCard_initialize"> 补卡单</a></li>
                        <li><a href="Leave_initialize"> 请假单</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>考勤报表</span>
                    </a>
                    <ul class="sub">
                        <li><a href="CheckReport_initialize"> 考勤表</a></li>
                    </ul>
                </li>
                 <li class="sub-menu">
                    <a class="active" href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>考勤设置</span>
                    </a>
                    <ul class="sub">
                        <li><a class="active" href="Classes_initialize">班次</a></li>
                    </ul>
                </li>
                <li class="sub-menu">
                    <a href="javascript:;">
                        <i class="fa fa-tasks"></i>
                        <span>财务管理</span>
                    </a>
                    <ul class="sub">
                        <li><a href="PaySalary_initialize">派薪单</a></li>
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

						<h3>班次</h3>
						<h6>—清单</h6>
						<div >
								<form action="Classes_search">
								<input type="text"  name="searchName" placeholder="请输入班次名称"  value='<s:property value="searchName"/>'' >
									 <input type="submit" data-tooltip value="" style="width:24px; height:24px;  border:0;  background:url(images/search.png) no-repeat left top "
									  title="点击搜索班次信息" />
									  </form>
							<form action="Classes_remove">
							<input type="submit"  data-tooltip value="" style="  width:32px; height:32px;  border:0;  background:url(images/plsc.png) no-repeat left top "
									name="jump"  title="点击删除勾选的记录"
									onclick="return delete_confirm()" />
							<input type="button" data-tooltip value="" style="  width:32px; height:32px;  border:0;  background:url(images/add.png) no-repeat left top "
									name="jump"  title="点击添加班次信息"
									onclick="location.href='<s:url action="Classes_edit"></s:url>'" />
						</div>
						<div>
							<table class="table">
        <thead>
          <tr>
           <th>选择</th>
            <th>ID</th>
            <th>班次编码</th>
            <th>班次名称</th>
            <th>早上上班时间</th>
            <th>下午下班时间</th>
            <th>操作</th>
          </tr>
        </thead>
								<tbody>
									<tr data-expanded="true">
										<s:iterator value="classesList" id="c">
											<tr>
												<td><input type="checkbox" name="ids"
													value='<s:property value="#c.id"/>' /></td>
													<td><s:property value="#c.id" /></td>
												<td><s:property value="#c.code" /></td>
												<td><s:property value="#c.name" /></td>
												<td><s:property value="#c.morningBusinessHours" /></td>
												<td><s:property value="#c.afternoonBusinessHours" /></td>
												<td><s:property value="#c.remark" /></td>
												<td>
												<input type="button" value="" style=" width:24px; height:24px;  border:0;  background:url(images/edit.png) no-repeat left top "
									name="jump" 
									onclick="location.href='<s:url action="Classes_edit"><s:param name="id" value="#c.id" /></s:url>'" />
									<input type="button" value="" style=" width:24px; height:24px;  border:0;  background:url(images/delete.png) no-repeat left top "
									name="jump" 
									onclick="location.href='<s:url action="Classes_delete"><s:param name="id" value="#c.id" /></s:url>'" />
												</td>
											</tr>
										</s:iterator>
									</tr>
								</tbody>
							</table>
						</div>
						</form>
							<div align="center">
							<!-- 页面页码 -->
							<s:if test="pageCount.currentPage>pageCount.minPage">
							<input type="button" value="" style=" width:16px; height:16px;  border:0;  background:url(images/first.png) no-repeat left top "
									name="jump" title="点击跳转至第一页"
									onclick="location.href='<s:url action="CheckReport_limit"><s:param name="currentPage" value="pageCount.minPage" /></s:url>'" />
							<input type="button" value="" style=" width:16px; height:16px;  border:0;  background:url(images/up.png) no-repeat left top "
									name="jump" title="点击跳转至上一页"
									onclick="location.href='<s:url action="CheckReport_limit"><s:param name="currentPage" value="pageCount.currentPage-1" /></s:url>'" />
							</s:if>
							当前页:
							<s:property value="pageCount.currentPage+1" />
							/
							<s:property value="pageCount.maxPage+1" />
							<s:if test="pageCount.currentPage<pageCount.maxPage-1">
							<input type="button" value="" style=" width:16px; height:16px;  border:0;  background:url(images/down.png) no-repeat left top "
									name="jump" title="点击跳转至下一页"
									onclick="location.href='<s:url action="CheckReport_limit"><s:param name="currentPage" value="pageCount.currentPage+1" /></s:url>'" />
							<input type="button" value="" style=" width:16px; height:16px;  border:0;  background:url(images/last.png) no-repeat left top "
									name="jump" title="点击跳转至最后一页"
									onclick="location.href='<s:url action="CheckReport_limit"><s:param name="currentPage" value="pageCount.maxPage" /></s:url>'" />
							</s:if>
						</div>
					</div>
						<a href="javascript:save();">导出到Excel</a>
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
	<script type="text/javascript">
	function save() {
		$.ajax({
			type : "post",
			async : false, //同步执行
			url : "Classes_ExportToExcel", //后台处理的servlet路径
			data : {},
			dataType : "json", //返回数据形式为json
			success:function(msg){
				if(msg.isSuccess){
					alert("导出成功");
				}else{
					alert("导出失败")
				}
					}
		});
	}
	</script>
</body>
</html>
