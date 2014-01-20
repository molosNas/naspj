<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>方案管理</title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/a_common_opr.js"></script>

<script type="text/javascript">
$(function() {
	$('#tt').datagrid({
		title:"方案管理",
		url:"list_proposition",
	    columns:[[   
	       {field:'id',title:'ID',width:0,hidden:true},   
	       {field:'attributeId',title:'方案编码',width:100,align:'center'},   
	       {field:'name',title:'方案名称',width:100,align:'center'},   
	       {field:'description',title:'描述',width:100,align:'center'},
	       {field:'parentId',title:'父级ID',width:100,align:'center',hidden:true}   
	   ]],
	   toolbar: "#toolbar"
	});
});
</script>
</head> 
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_proposition','新增资源')">新增</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_proposition','修改资源')">编辑</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_proposition','确定删除该资源?')">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons"> 
		<div class="ftitle">资源模块管理</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>模块名称:</label> <input name="moduleName"
					class="easyui-validatebox" required="true" validType="isRepeat['123','321']"  invalidMessage="exception">
			</div>
			<div class="fitem">
				<label>模块路径:</label> <input name="modulePath"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>菜单级别:</label> <input name="level" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>父级ID:</label> <input name="parentId" class="easyui-validatebox">
			</div>
		</form>
	</div>
	<jsp:include page="../../basedef/form_opr_bt.jsp"/>
</body>
</html>