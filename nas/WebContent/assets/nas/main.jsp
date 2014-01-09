<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/loadmenus.js"></script>
<script type="text/javascript">
	$(function() {
		$.post("menus",function(data){
			console.log(data);
			initMenu(data);
		},"json");
	});
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" fit="true"
	scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<!-- 进度显示框 -->
	<div id="loading-mask"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; background: #D2E0F2; z-index: 20000">
		<div id="pageloading"
			style="position: absolute; top: 50%; left: 50%; margin: -120px 0px 0px -120px; text-align: center; border: 2px solid #8DB2E3; width: 200px; height: 40px; font-size: 14px; padding: 10px; font-weight: bold; background: #fff; color: #15428B;">
			<img src=" " align="absmiddle" /> 正在加载中,请稍候...
		</div>
	</div>
	<!-- 头定义 -->
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 30px; background: url() #7f99be repeat-x center 50%; line-height: 20px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
		<span style="float: right; padding-right: 20px;" class="head">欢迎
			${user.name } <a href="#" id="editpass">修改密码</a> <a href="#"
			id="loginOut">安全退出</a>
		</span> <span style="padding-left: 10px; font-size: 16px;"><img src=""
			width="210" height="20" align="absmiddle" style="margin-right: 10px;" />后台管理系统
		</span>
	</div>
	<div region="south" split="true"
		style="height: 30px; background: #D2E0F2; overflow: hidden;">
		<div class="footer">
			<p>Copyright © 2012- HICAR Corporation, All Rights Reserved</p>
		</div>
	</div>
	<div region="west" split="true" title="导航菜单" style="width: 180px;"
		id="west">
		<div id="nav">
			<!--  导航内容 -->
		</div>
	</div>
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false"></div>
	</div>

	<div id="mm" class="easyui-menu" style="width: 150px;">
		<div id="tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="close">关闭</div>
		<div id="closeall">全部关闭</div>
		<div id="closeother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="closeright">当前页右侧全部关闭</div>
		<div id="closeleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="exit">退出</div>
	</div>
</body>
</html>