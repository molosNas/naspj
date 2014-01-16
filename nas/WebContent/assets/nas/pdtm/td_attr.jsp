<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性种类管理</title>
<jsp:include page="../basedef/top_global.jsp" />
<script type="text/javascript">
$(function() {
	$('#tt').datagrid({
		title:"属性种类管理",
		url:"list_td_attrs",
		hideColumn: 'id',
		striped:true,
		singleSelect:true,
		fitColumns:true,
		rownumbers:true,
		loadMsg:"数据装载中......",
		pagination:true,
	    columns:[[   
	       {field:'id',title:'ID',width:0,hidden:true},   
	       {field:'name',title:'名称',width:30,align:'center'},   
	       {field:'description',title:'描述',width:100,align:'center'}
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
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_td_attrs','新增属性种类')">新增</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_td_attrs','修改属性种类')">编辑</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_td_attrs','确定删除该属性种类?')">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 560px; height: 300px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">属性种类管理</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label> 名称:</label> <input name="name"
					class="easyui-validatebox" required="true" validType="isRepeat['is_repeat_td_attrs_name']"  invalidMessage="属性种类名称已存在！">
			</div>
			<div class="fitem">
				<label style="float: left;">描述:</label> 
				<textarea rows="5" cols="30" name="description"></textarea>
			</div>
		</form>
	</div>
	<jsp:include page="../basedef/form_opr_bt.jsp"/>
</body>
</html>