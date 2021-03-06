<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<!-- BEGIN HEAD -->
<head>
	<meta charset="utf-8" />
	<title>自动化测试平台</title>
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />

	<!-- BEGIN GLOBAL MANDATORY STYLES -->
	<link href="${pageContext.request.contextPath}/media/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/style-metro.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/style.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/style-responsive.css" rel="stylesheet" type="text/css"/>
	<link href="${pageContext.request.contextPath}/media/css/default.css" rel="stylesheet" type="text/css" id="style_color"/>
	<link href="${pageContext.request.contextPath}/media/css/uniform.default.css" rel="stylesheet" type="text/css"/>
	<!-- END GLOBAL MANDATORY STYLES -->

	<!-- BEGIN PAGE LEVEL STYLES -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/bootstrap-fileupload.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/jquery.gritter.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/chosen.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/select2_metro.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/jquery.tagsinput.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/clockface.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/bootstrap-wysihtml5.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/datepicker.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/timepicker.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/colorpicker.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/bootstrap-toggle-buttons.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/daterangepicker.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/datetimepicker.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/media/css/multi-select-metro.css" />
	<link href="${pageContext.request.contextPath}/media/css/bootstrap-modal.css" rel="stylesheet" type="text/css"/>

	<!-- END PAGE LEVEL STYLES -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/media/image/favicon.ico" />
</head>
<!-- END HEAD -->

<!-- BEGIN BODY -->
<body class="page-header-fixed">
	<!-- BEGIN HEADER -->
	<%@ include file="/view/navbar.jsp" %>
	<!-- END HEADER -->

	<!-- BEGIN CONTAINER -->
	<div class="page-container row-fluid">
		<!-- BEGIN SIDEBAR -->
		<%@ include  file="/view/menu.jsp"%> 
		<!-- END SIDEBAR -->

		<!-- BEGIN PAGE -->  
		<div class="page-content">
			<!-- BEGIN PAGE CONTAINER-->
			<div class="container-fluid">
				<!-- BEGIN PAGE HEADER-->   
				<div class="row-fluid">
					<div class="span12">
						<h3 class="page-title">
							自动化测试平台
						</h3>
						<ul class="breadcrumb">
							<li>
								<i class="icon-home"></i>
								<a href="${pageContext.request.contextPath}/view/HomePage.jsp">首页</a> 
								<span class="icon-angle-right"></span>
							</li>
							<li>
								<a href="#">用例管理</a>
								<span class="icon-angle-right"></span>
							</li>
							<li><a href="${pageContext.request.contextPath}/view/siteList.jsp">用例列表</a></li>
						</ul>
					</div>
				</div>
				<!-- END PAGE HEADER-->

				<!-- BEGIN PAGE CONTENT-->
				<div class="row-fluid">
					<div class="span12">
						<!-- BEGIN SAMPLE FORM PORTLET-->   
						<div class="portlet box blue">
							<div class="portlet-title">
								<div class="caption"><i class="icon-reorder"></i>编辑用例</div>
								<div class="tools">
									<a href="javascript:;" class="collapse"></a>
									<a href="javascript:;" class="reload"></a>
								</div>
							</div>

							<div class="portlet-body form">
								<!-- BEGIN FORM-->
								<form action="${pageContext.request.contextPath }/CaseServlet" class="form-horizontal" method="post">
								<input type="hidden" name="method" value="updateCase"/>
								<input type="hidden" name="cid" value="${caseVo.cid }"/>
									<div class="control-group">
										<label class="control-label">所属站点</label>
										<div class="controls">
											<select class="large m-wrap" tabindex="1" name="sname">												 
												  <c:forEach var="s" items="${siteList }">
												  <option value="${s.sid }" <c:if test="${s.sid == caseVo.sid }">selected="selected"</c:if>>${s.sname }</option>
												  </c:forEach>
											</select>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">业务模块</label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="cbusiness" value="${caseVo.cbusiness}"/>
											<span class="help-inline"></span>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">接口地址</label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="curl" value="${caseVo.curl }"/>
											<span class="help-inline"></span>
										</div>
									</div>
									<!-- <div class="control-group">
										<label class="control-label">用例ID</label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" />
											<span class="help-inline"></span>
										</div>
									</div> -->
									
									<div class="control-group">
										<label class="control-label">用例名称</label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="cname" value="${caseVo.cname }"/>
											<span class="help-inline"></span>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">请求方法</label>
										<div class="controls">
											<select class="large m-wrap" tabindex="1" name="cmethod">
												  <option value ="POST" <c:if test="${caseVo.cmethod eq 'POST' }">selected="selected"</c:if>>POST</option>
												  <option value="GET" <c:if test="${caseVo.cmethod eq 'GET' }">selected="selected"</c:if>>GET</option>
											</select>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">请求头部</label>
										<div class="controls">
											<input type="text" class="span6 m-wrap" name="cheader" id="cheaderid" value="<c:out value="${caseVo.cheader }"></c:out>"/>
											<span class="help-inline" id="cheaderSpan"></span>
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">参数类型</label>
										<div class="controls">
											<select class="large m-wrap" tabindex="1" name="cparamtype" id="cparamtypeid">												 
												  <option value ="FORM" <c:if test="${caseVo.cparamtype eq 'FORM'}">selected="selected"</c:if>>Form表单</option>
												  <option value="JSON" <c:if test="${caseVo.cparamtype eq 'JSON'}">selected="selected"</c:if>>JSON</option>
												  <option value="PATH" <c:if test="${caseVo.cparamtype eq 'PATH'}">selected="selected"</c:if>>路径参数</option>
											</select>
											
										</div>
									</div>
									
									<div class="control-group">
										<label class="control-label">请求参数</label>
										<div class="controls">
											<textarea class="span6 m-wrap" rows="3" name="cparam">${caseVo.cparam }</textarea>
										</div>
									</div>
									<div class="control-group">
										<label class="control-label">检查点</label>
										<div class="controls">
											<textarea class="span6 m-wrap" rows="3" name="cresult">${caseVo.cresult }</textarea>
										</div>
									</div>
									
									<div class="form-actions">
										<button type="submit" class="btn blue">保存</button>
										&nbsp;&nbsp;
										<button type="button" class="btn" onclick="cancel()">取消</button>                            
									</div>
								</form>
								<!-- END FORM-->       
							</div>
						</div>
						<!-- END SAMPLE FORM PORTLET-->
					</div>
				</div>
				<!-- END PAGE CONTENT-->         
			</div>
			<!-- END PAGE CONTAINER-->
		</div>
		<!-- END PAGE -->  
	</div>

	<!-- END CONTAINER -->

	<!-- BEGIN FOOTER -->
	<%@ include file="/view/footer.jsp" %>
	<!-- END FOOTER -->

	<!-- BEGIN JAVASCRIPTS(Load javascripts at bottom, this will reduce page load time) -->
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
	<!-- END CORE PLUGINS -->

	<!-- BEGIN PAGE LEVEL PLUGINS -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/ckeditor.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/bootstrap-fileupload.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/chosen.jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/select2.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/wysihtml5-0.3.0.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/bootstrap-wysihtml5.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.tagsinput.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.toggle.buttons.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/bootstrap-datetimepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/clockface.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/date.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/daterangepicker.js"></script> 
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/bootstrap-colorpicker.js"></script>  
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/bootstrap-timepicker.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.inputmask.bundle.min.js"></script>   
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.input-ip-address-control-1.0.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/media/js/jquery.multi-select.js"></script>   
	<script src="${pageContext.request.contextPath}/media/js/bootstrap-modal.js" type="text/javascript" ></script>
	<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/media/js/bootstrap-modalmanager.js" type="text/javascript" ></script> 
	<!-- END PAGE LEVEL PLUGINS -->

	<!-- BEGIN PAGE LEVEL SCRIPTS -->
	<script src="${pageContext.request.contextPath}/media/js/app.js"></script>
	<script src="${pageContext.request.contextPath}/media/js/form-components.js"></script>     
	<!-- END PAGE LEVEL SCRIPTS -->
	<script>
		jQuery(document).ready(function() {       
		   App.init();
		   FormComponents.init();
		});
	</script>
	<script>
		function cancel(){
			window.location.href="${pageContext.request.contextPath}/CaseServlet?method=findAllCase";                      			
		}
	</script>
	<!-- END JAVASCRIPTS -->   

	<script type="text/javascript">  var _gaq = _gaq || [];  _gaq.push(['_setAccount', 'UA-37564768-1']);  _gaq.push(['_setDomainName', 'keenthemes.com']);  _gaq.push(['_setAllowLinker', true]);  _gaq.push(['_trackPageview']);  (function() {    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;    ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);  })();</script>
</body>

<!-- END BODY -->
</html>
