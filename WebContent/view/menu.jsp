<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<!-- BEGIN SIDEBAR -->
		<div class="page-sidebar nav-collapse collapse">
			<ul class="page-sidebar-menu">
				<li>
					<div class="sidebar-toggler hidden-phone"></div>
				</li>
		<!-- 		<li>
					<form class="sidebar-search">
						<div class="input-box">
							<a href="javascript:;" class="remove"></a>
							<input type="text" placeholder="Search..." />
							<input type="button" class="submit" value=" " />
						</div>
					</form>
				</li> -->

				<li class="start ">
					<a href="${pageContext.request.contextPath}/view/HomePage.jsp">
					<i class="icon-home"></i> 
					<span class="title">首页</span>
					</a>
				</li>
							
				<li class="">
					<a href="javascript:;">
					<i class="icon-cogs"></i> 
					<span class="title">项目管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="${pageContext.request.contextPath}/view/siteList.jsp">站点管理</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-bookmark-empty"></i> 
					<span class="title">接口管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="${pageContext.request.contextPath}/view/apiList.jsp">接口列表</a>
						</li>
					</ul>
				</li>

				<li class="">
					<a href="javascript:;">
					<i class="icon-gift"></i> 
					<span class="title">用例管理</span>
					<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li >
							<a href="${pageContext.request.contextPath}/view/caseList.jsp">
							用例列表</a>
						</li>
					</ul>
				</li>

				<li class="last ">
					<a href="charts.html">
					<i class="icon-briefcase"></i> 
					<span class="title">测试执行</span>
					</a>
				</li>
				
				<li class="last ">
					<a href="charts.html">
					<i class="icon-sitemap"></i> 
					<span class="title">测试报告</span>
					</a>
				</li>
				
				<li class="last ">
					<a href="charts.html">
					<i class="icon-file-text"></i> 
					<span class="title">环境管理</span>
					</a>
				</li>
				
				<li class="last ">
					<a href="charts.html">
					<i class="icon-bar-chart"></i> 
					<span class="title">文档管理</span>
					</a>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
		<!-- END SIDEBAR -->    