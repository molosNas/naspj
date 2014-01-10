<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源管理</title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript">
$(function() {
	$('#tt').datagrid({
		title:"系统模块管理",
		url:"list_resource",
		hideColumn: 'id',
		striped:true,
		singleSelect:true,
		fitColumns:true,
		rownumbers:true,
		loadMsg:"数据装载中......",
		pagination:true,
	    columns:[[   
	       {field:'id',title:'ID',width:0,hidden:true},   
	       {field:'moduleName',title:'模块名称',width:100,align:'center'},   
	       {field:'modulePath',title:'模块路径',width:100,align:'center'},   
	       {field:'level',title:'菜单级别',width:100,align:'center',formatter:function(val){
	    	  switch (val) {
				case 0:
					return "顶级模块";
				case 1:
					return "一级模块";
				case 2:
					return "二级模块";
				}
	       }},
	       {field:'parentId',title:'父级ID',width:100,align:'center',hidden:true}   
	   ]],
	   toolbar: "#toolbar"
	});
	$('#tt').datagrid("getPager").pagination({
		pageSize: 10,
		pageList: [5, 10, 50],
		beforePageText: '第',
		afterPageText: '页    共 {pages} 页',
		displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
	});
});
</script>
</head>
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_resource','新增资源')">新增</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_resource','修改资源')">编辑</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_resource','确定删除该资源?')">删除</a>
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
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData()">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>  
</body>
</html>