<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.lwjnicole.domain.User"%>

<!--导航条-->
	<div class="header navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<!-- BEGIN LOGO -->
				<a class="brand" href="${pageContext.request.contextPath}/view/HomePage.jsp">
				<img src="${pageContext.request.contextPath}/media/image/logo.png" alt="logo" />
				</a>
			<%-- 	<a href="javascript:;" class="btn-navbar collapsed" data-toggle="collapse" data-target=".nav-collapse">
				<img src="${pageContext.request.contextPath}/media/image/menu-toggler.png" alt="" />
				</a>    --%>                 

				<ul class="nav pull-right">
					<!-- BEGIN USER LOGIN DROPDOWN -->
					<li class="dropdown user">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
						<img alt="" src="${pageContext.request.contextPath}/media/image/avatar1_small.jpg" />						
						<span class="username">${sessionScope.user.username}</span>
						<i class="icon-angle-down"></i>
						</a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/UserServlet?method=lockUI"><i class="icon-lock"></i> Lock Screen</a></li>
							<li><a href="${pageContext.request.contextPath}/UserServlet?method=logOut"><i class="icon-key"></i> Log Out</a></li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
	</div>