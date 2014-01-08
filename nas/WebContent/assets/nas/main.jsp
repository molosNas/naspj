<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="basedef/top_eui_css.jsp" />
<jsp:include page="basedef/top_common_js.jsp" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/assets/common/js/loadmenus.js"></script>
<script type="text/javascript">
	$(function() {

	});
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      
	function menus() {

	}
</script>
</head>
<body class="easyui-layout" style="overflow-y: hidden;" fit="true"
	scroll="no">
	<noscript>
		<div
			style="position: absolute; z-index: 100000; height: 2046px; top: 0px; left: 0px; width: 100%; background: white; text-align: center;">
			<img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' />
		</div>
	</noscript>
	<!-- 进度显示框 -->
	<div id="loading-mask"
		style="position: absolute; top: 0px; left: 0px; width: 100%; height: 100%; background: #D2E0F2; z-index: 20000">
		<div id="pageloading"
			style="position: absolute; top: 50%; left: 50%; margin: -120px 0px 0px -120px; text-align: center; border: 2px solid #8DB2E3; width: 200px; height: 40px; font-size: 14px; padding: 10px; font-weight: bold; background: #fff; color: #15428B;">
			<img src="images/loading.gif" align="absmiddle" /> 正在加载中,请稍候...
		</div>
	</div>
	<!-- 头定义 -->
	<div region="north" split="true" border="false"
		style="overflow: hidden; height: 30px; background: url(images/layout-browser-hd-bg.jpg) #7f99be repeat-x center 50%; line-height: 20px; color: #fff; font-family: Verdana, 微软雅黑, 黑体">
		<span style="float: right; padding-right: 20px;" class="head">欢迎
			${user.name } <a href="#" id="editpass">修改密码</a> <a href="#"
			id="loginOut">安全退出</a> <input type="button" id="breakSystem"
			value="刷新系统" onclick="blushSystem()" />
		</span> <span style="padding-left: 10px; font-size: 16px;"><img
			src="images/blocks.png" width="210" height="20" align="absmiddle"
			style="margin-right: 10px;" />嗨车后台管理系统 </span>
	</div>
	<!-- 底部定义 -->
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
	<!-- 主要数据显示区 -->
	<div id="mainPanle" region="center"
		style="background: #eee; overflow-y: hidden">
		<div id="tabs" class="easyui-tabs" fit="true" border="false">
			<div title="欢迎使用"
				style="padding: 20px; overflow: hidden; color: red;">
				<div id="hot-key-1" class="hot-key">
					<ul>
						<li><a rel="http://www.baidu.com" href="#"><img
								src="css/navmenu/hot-person-order.png" /><br>个人订单管理</a></li>
						<li><a href="#"><img src="css/navmenu/hot-price-cfg.png" /><br>配件方案管理</a></li>
						<li><a href="#"><img src="css/navmenu/hot-article.png" /><br>文章管理</a></li>
					</ul>
				</div>
				<div id="hot-key-2" class="hot-key">
					<ul>
						<li><a href="#"><img src="css/navmenu/hot-vip-person.png" /><br>个人会员管理</a></li>
						<li><a href="#"><img
								src="css/navmenu/hot-bussiness-supp.png" /><br>企业供应商管理</a></li>
						<li><a href="#"><img src="css/navmenu/hot-auth.png" /><br>权限设置</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!--修改密码窗口-->
	<div id="w" class="easyui-window" title="修改密码" collapsible="false"
		minimizable="false" maximizable="false" icon="icon-save"
		style="width: 300px; height: 150px; padding: 5px; background: #fafafa;">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false"
				style="padding: 10px; background: #fff; border: 1px solid #ccc;">
				<table cellpadding=3>
					<tr>
						<td>新密码：</td>
						<td><input id="txtNewPass" type="Password" class="txt01" /></td>
					</tr>
					<tr>
						<td>确认密码：</td>
						<td><input id="txtRePass" type="Password" class="txt01" /></td>
					</tr>
				</table>
			</div>
			<div region="south" border="false"
				style="text-align: right; height: 30px; line-height: 30px;">
				<a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
					href="javascript:void(0)"> 确定</a> <a id="btnCancel"
					class="easyui-linkbutton" icon="icon-cancel"
					href="javascript:void(0)">取消</a>
			</div>
		</div>
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