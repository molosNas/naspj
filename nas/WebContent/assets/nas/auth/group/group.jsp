<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>工艺管理</title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript">
$(function() {
	$('#tt').datagrid({
		title:"工艺管理",
		url:"craft_list",
		hideColumn: 'id',
		striped:true,
		singleSelect:true,
		fitColumns:true,
		rownumbers:true,
		loadMsg:"数据装载中......",
		pagination:true,
	    columns:[[   
	       {field:'id',title:'ID',width:0,hidden:true},   
	       {field:'name',title:'工艺名称',width:100,align:'center'},   
	       {field:'duration',title:'默认时长',width:100,align:'center'},   
	       {field:'deviation',title:'时间偏差',width:100,align:'center'},
	       {field:'weight',title:'权重',width:100,align:'center'}   
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

var url;
function newUser() {
	$('#dlg').dialog('open').dialog('setTitle', '新增工艺');
	$('#fm').form('clear');
	url = 'save_craft';
}
function editUser() {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '修改工艺');
		$('#fm').form('load', row);
		url = 'update_craft?id=' + row.id;
	}else{
		 $.messager.alert('提示','请选择需要操作的数据!','warning');
	}
}
function saveUser() {
	$('#fm').form('submit', {
		url: url,
		onSubmit: function() {
			return $(this).form('validate');
		},
		success: function(result) {
			if (result.errorMsg) {
				$.messager.show({
					title: 'Error',
					msg: result.errorMsg
				});
			} else {
				$('#dlg').dialog('close'); // close the dialog
				$('#tt').datagrid('reload'); // reload the user data
			}
		}
	});
}
function destroyUser() {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', '确定删除选中工艺?',
		function(r) {
			if (r) {
				$.post('destroy_craft', {
					id: row.id
				},
				function(result) {
					if (result.success) {
						$('#tt').datagrid('reload'); // reload the user data
					} else {
						$.messager.show({ // show error message
							title: 'Error',
							msg: result.errorMsg
						});
					}
				},
				'json');
			}
		});
	}else{
		$.messager.alert('提示','请选择需要操作的数据!','warning');
	}
}

</script>
</head>
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">工艺管理</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>工艺名称:</label> <input name="name"
					class="easyui-validatebox" required="true" validType="valiName">
			</div>
			<div class="fitem">
				<label>默认时长:</label> <input name="duration"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>时间偏差:</label> <input name="deviation" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>权重:</label> <input name="weight" class="easyui-validatebox">
			</div>
		</form>
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
	</div>  
</body>
</html>