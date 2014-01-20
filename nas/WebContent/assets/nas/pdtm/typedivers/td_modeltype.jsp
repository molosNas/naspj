<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>型号种类管理</title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/a_common_opr.js"></script>

<script type="text/javascript">
$(function() {
	$('#tt').datagrid({
		title:"型号种类管理",
		url:"list_td_modeltype",
	    columns:[[   
	       {field:'id',title:'ID',width:0,hidden:true},   
	       {field:'name',title:'名称',width:30,align:'center'},   
	       {field:'description',title:'描述',width:100,align:'center'}
	   ]],
	   toolbar: "#toolbar"
	});
});
function removeRepeatCheck(){
	$('input').filter(function(index){
		if($(this).attr("validType")!= undefined && $(this).attr("validType").indexOf("isRepeat") >= 0){
			return $(this);
		}
	}).attr("readonly","readonly").removeAttr("validType").removeAttr("required");
}
function addRepeatCheck(){
	$("input[name='name']").attr("validType","isRepeat['is_repeat_td_modeltype_name']").attr("required",true).removeAttr("readonly");
}
</script>
</head> 
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_td_modeltype','新增型号种类')">新增</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_td_modeltype','修改型号种类')">编辑</a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_td_modeltype','确定删除该型号种类?')">删除</a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 560px; height: 300px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle">型号种类管理</div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label> 名称:</label> <input name="name"
					class="easyui-validatebox" invalidMessage="型号种类名称已存在！" >
			</div>
			<div class="fitem">
				<label style="float: left;">描述:</label> 
				<textarea rows="5" cols="30" name="description"></textarea>
			</div>
		</form>
	</div>
	<jsp:include page="../../basedef/form_opr_bt.jsp"/>
</body>
</html>