<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>属性管理</title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/a_common_opr.js"></script>

<script type="text/javascript">
$(function() {
	$('#tt').datagrid({
		title:"属性管理",
		url:"list_attrs",
	    columns:[[   
	       {field:'id',title:'ID',width:0,hidden:true},   
	       {field:'attributeId',title:'属性编码',width:20,align:'center'},   
	       {field:'name',title:'属性名称',width:30,align:'center'},   
	       {field:'description',title:'描述',width:80,align:'center'},
	       {field:'attributetype',title:'所属种类',width:50,align:'center',formatter:function(row){
	    	   return row.name;
	       }}   
	   ]],
	   toolbar: "#toolbar"
	});
    $('#cc').combobox({
        url:'map_td_attrs',
        valueField:'id',
        textField:'val',
        editable:false
        });
    
    $.post("map_td_attrs",function(data){
    	$.each(data,function(k,v){
    		console.log(k+":"+v.val);
    	});
    },"json");
});
</script>
</head> 
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_attrs','新增资源')">新增</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_attrs','修改资源')">编辑</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_attrs','确定删除该资源?')">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 400px; height: 280px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons"> 
		<div class="ftitle">属性管理</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label>属性编码:</label> <input name="attributeId"
					class="easyui-validatebox" required="true" >
			</div>
			<div class="fitem">
				<label>属性名称:</label> <input name="name"
					class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>属性描述:</label> <input name="description" class="easyui-validatebox" required="true">
			</div>
			<div class="fitem">
				<label>所属属性种类:</label>
				<input name="attributetype.id" id="cc" />
			</div>
		</form>
	</div>
	<jsp:include page="../../basedef/form_opr_bt.jsp"/>
</body>
</html>