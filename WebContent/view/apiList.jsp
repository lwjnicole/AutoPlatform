<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<title>自动化测试平台</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${pageContext.request.contextPath}/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>

	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/media/css/DT_bootstrap.css" />
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/media/image/favicon.ico" />
	
</head>

<body class="page-header-fixed">
	<!--导航条  -->	
	<%@ include  file="/view/navbar.jsp"%>

	<div class="page-container row-fluid">
	<!-- 菜单栏 -->
		<%@ include  file="/view/menu.jsp"%> 

		<!-- BEGIN PAGE -->
		<div class="page-content">
			<!-- BEGIN PAGE CONTAINER-->        
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->
				<div class="row-fluid">
					<div class="span12">
						
						<!-- BEGIN PAGE TITLE & BREADCRUMB-->
						<h3 class="page-title">
							自动化测试平台
						</h3>

						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="${pageContext.request.contextPath}/view/HomePage.jsp">首页</a> 
								<i class="icon-angle-right"></i>
							</li>
							<li>
								<a href="#">接口管理</a>
								<i class="icon-angle-right"></i>
							</li>
							<li><a href="#">接口列表</a></li>
						</ul>
						<!-- END PAGE TITLE & BREADCRUMB-->
					</div>
				</div>
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN EXAMPLE TABLE PORTLET-->
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-globe"></i>接口列表</div>
								<div class="actions">
									<div class="btn-group">
										<a class="btn" href="#" data-toggle="dropdown">
										列名
										<i class="icon-angle-down"></i>
										</a>
										<div id="sample_2_column_toggler" class="dropdown-menu hold-on-click dropdown-checkboxes pull-right">
											<!-- <label><input type="checkbox" checked data-column="-1">全选</label> -->
											<label><input type="checkbox" checked data-column="0">序号</label>
											<label><input type="checkbox" checked data-column="1">所属站点</label>
											<label><input type="checkbox" checked data-column="2">业务模块</label>
											<label><input type="checkbox" checked data-column="3">接口名称</label>
											<label><input type="checkbox" checked data-column="4">URL</label>
											<label><input type="checkbox" checked data-column="5">请求方法</label>
											<label><input type="checkbox" checked data-column="6">创建时间</label>
											<label><input type="checkbox" checked data-column="7">操作</label>
										
										</div>
									</div>
								</div>
							</div>
							<div class="portlet-body">
								<div class="clearfix">
									<div class="btn-group">
										<a id="sample_editable_1_new" class="btn green" role="button" href="${pageContext.request.contextPath}/ApiServlet?method=addApiUI">
										新增&nbsp;&nbsp;<i class="icon-plus"></i>
										</a>
									</div>
								</div>
							</div>
								
									
							<div class="portlet-body">
								<table class="table table-striped table-bordered table-hover table-full-width" id="sample_2">
									<thead>
										<tr>
											<th>序号</th>
											<th>所属站点</th>
											<th>业务模块</th>
											<th class="hidden-480">接口名称</th>
											<th class="hidden-480">URL</th>
											<th class="hidden-480">请求方法</th>
											<th class="hidden-480">创建时间</th>
											<th class="hidden-480">操作</th>
										</tr>
									</thead>

									<tbody>
									<c:forEach var="a" items="${apiListVo}" varStatus="Status">
										<tr>
											<td>${Status.count}</td>
											<td>${a.sid}</td>
											<td>${a.business }</td>
											<td class="hidden-480">${a.aname }</td>
											<td class="hidden-480">${a.aurl }</td>
											<td class="hidden-480">${a.method }</td>
											<td class="hidden-480">${a.create_time }</td>
											<td class="hidden-480"><a href="${pageContext.request.contextPath}/view/editApi.jsp">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>
									</c:forEach>
									<!-- 	<tr >
											<td>2</td>
											<td>S60</td>
											<td>aaa</td>
											<td class="hidden-480">S60</td>
											<td class="hidden-480">413</td>
											<td class="hidden-480">A</td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>

										<tr >
											<td>3</td>
											<td>aaa</td>
											<td>Opera 7.0</td>
											<td class="hidden-480">Win 95+ / OSX.1+</td>
											<td class="hidden-480">-</td>
											<td class="hidden-480">A</td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>

										<tr >
											<td>4</td>
											<td>aaa</td>
											<td>Opera 7.5</td>
											<td class="hidden-480">Win 95+ / OSX.2+</td>
											<td class="hidden-480">-</td>
											<td class="hidden-480">A</td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>

										<tr >
											<td>5</td>
											<td>aaa</td>
											<td>Opera 8.0</td>
											<td class="hidden-480">Win 95+ / OSX.2+</td>
											<td class="hidden-480">-</td>
											<td class="hidden-480">A</td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>

										<tr >
											<td>6</td>
											<td>aaa</td>
											<td>Opera for Wii</td>
											<td class="hidden-480">Wii</td>
											<td class="hidden-480">-</td>
											<td class="hidden-480">A</td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>

										<tr >
											<td>7</td>
											<td>aaa</td>
											<td>Nokia N800</td>
											<td class="hidden-480">N800</td>
											<td class="hidden-480">-</td>
											<td class="hidden-480">A</td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>
										<tr >
											<td>8</td>
											<td>aaa</td>
											<td>Nintendo DS browser</td>
											<td class="hidden-480">Nintendo DS</td>
											<td class="hidden-480">8.5</td>
											<td class="hidden-480">C/A<sup>1</sup></td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>
										
										<tr >
											<td>9</td>
											<td>aaa</td>
											<td>Nintendo DS browser</td>
											<td class="hidden-480">Nintendo DS</td>
											<td class="hidden-480">8.5</td>
											<td class="hidden-480">C/A<sup>1</sup></td>
											<td class="hidden-480"><a href="#">编辑</a>&nbsp;&nbsp;<a href="#">删除</a></td>
										</tr>									 -->
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/view/footer.jsp" %>

	<!-- BEGIN CORE PLUGINS -->
	<script src="${pageContext.request.contextPath}/media/js/jquery-1.10.1.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/media/js/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>

	<!-- IMPORTANT! Load jquery-ui-1.10.1.custom.min.js before bootstrap.min.js to fix bootstrap tooltip conflict with jquery ui tooltip -->
	<script src="${pageContext.request.contextPath}/media/js/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>      
	<script src="${pageContext.request.contextPath}/media/js/bootstrap.min.js" type="text/javascript"></script>                
	<script src="${pageContext.request.contextPath}/media/js/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/media/js/jquery.blockui.min.js" type="text/javascript"></script>  
	<script src="${pageContext.request.contextPath}/media/js/jquery.cookie.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/media/js/jquery.uniform.min.js" type="text/javascript" ></script>

	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/select2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/DT_bootstrap.js"></script>
	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->

	<script src="${pageContext.request.contextPath}/media/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/media/js/table-advanced.js"></script>     
	<script>
		jQuery(document).ready(function() {       
		   App.init();
		   TableAdvanced.init();
		});
	</script>

<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script></body>
<!-- END BODY -->
</html>