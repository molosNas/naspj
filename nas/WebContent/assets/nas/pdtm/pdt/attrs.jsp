<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spr:message code='pdtm.attrs.page.title'/></title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/a_common_opr.js"></script>

<script type="text/javascript">
$(function() {
	$("#tt").datagrid({
		title:"<spr:message code='pdtm.attrs.datagrid.title'/>",
		url:"list_attrs",
	    columns:[[   
	       {field:'id',title:"<spr:message code='pdtm.attrs.bean.id'/>",width:0,hidden:true}, 
	       {field:'codeId',title:"<spr:message code='pdtm.attrs.bean.encid'/>",width:20,align:'center'}, 
	       {field:'name',title:"<spr:message code='pdtm.attrs.bean.name'/>",width:30,align:'center'},   
	       {field:'description',title:"<spr:message code='pdtm.attrs.bean.description'/>",width:100,align:'center'},
	       {field:'attributetype',title:"<spr:message code='pdtm.attrs.bean.attributetype'/>",width:50,align:'center',formatter:function(row){
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
});
function add(){
	$("input[name='codeId']").validatebox('reduce'); 
	$("input[name='name']").validatebox('reduce'); 
	$("input[name='codeId']").removeAttr('readonly');
	$("input[name='name']").removeAttr('readonly');
}
function update(){
	$("input[name='name']").validatebox('remove');
	$("input[name='codeId']").validatebox('remove');
	$("input[name='name']").attr('readonly','readonly');
	$("input[name='codeId']").attr('readonly','readonly');
}
</script>
</head> 
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_attrs','<spr:message code="pdtm.attrs.form.title.add"/>',add)"><spr:message code='datagrid.opr.add'/></a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_attrs','<spr:message code='pdtm.attrs.form.title.update'/>',update)"><spr:message code='datagrid.opr.update'/></a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_attrs','<spr:message code='pdtm.attrs.form.title.del.tip'/>')"><spr:message code='datagrid.opr.del'/></a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 560px; height: 340px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle"><spr:message code='pdtm.attrs.form.title.main'/></div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label><spr:message code='pdtm.attrs.bean.encid'/>:</label> <input name="codeId"
					class="easyui-validatebox" required="true" validType="isRepeat['is_repeat_attrs_encid']"  invalidMessage="<spr:message code='pdtm.attrs.vail.encid'/>" />
			</div>
			<div class="fitem">
				<label> <spr:message code='pdtm.attrs.bean.name'/>:</label> <input name="name"
					class="easyui-validatebox" validType="isRepeat['is_repeat_attrs_name']"  invalidMessage="<spr:message code='pdtm.attrs.vail.name'/>" />
			</div>
			<div class="fitem">
				<label><spr:message code='pdtm.attrs.bean.attributetype'/>:</label>
				<input name="attributetype.id" id="cc" required="true" />
			</div>
			<div class="fitem">
				<label style="float: left;"><spr:message code='pdtm.attrs.bean.description'/>:</label> 
				<textarea rows="5" cols="30" name="description"></textarea>
			</div>
		</form>
	</div>
	<jsp:include page="../../basedef/form_opr_bt.jsp"/>
</body>
</html>