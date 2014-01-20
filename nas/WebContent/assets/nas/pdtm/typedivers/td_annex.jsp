<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code='pdtm.td.annex.form.title'/></title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/a_common_opr.js"></script>

<script type="text/javascript">
$(function() {
	$("#tt").datagrid({
		title:"<spring:message code='pdtm.td.annex.title'/>",
		url:"list_td_annex",
	    columns:[[   
	       {field:'id',title:"<spring:message code='pdtm.td.annex.bean.id'/>",width:0,hidden:true},   
	       {field:'name',title:"<spring:message code='pdtm.td.annex.bean.name'/>",width:30,align:'center'},   
	       {field:'description',title:"<spring:message code='pdtm.td.annex.bean.description'/>",width:100,align:'center'}
	   ]],
	   toolbar: "#toolbar"
	});	 
});
</script>
</head> 
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_td_annex','新增附加种类')"><spring:message code='bt.opr.add'/></a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_td_annex','修改附加种类')"><spring:message code='bt.opr.update'/></a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_td_annex','确定删除该附加种类?')"><spring:message code='bt.opr.del'/></a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 560px; height: 300px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle"><spring:message code='pdtm.td.annex.form.title'/></div>
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<label> <spring:message code='pdtm.td.annex.bean.name'/>:</label> <input name="name"
					class="easyui-validatebox" >
			</div>
			<div class="fitem">
				<label style="float: left;"><spring:message code='pdtm.td.annex.bean.description'/>:</label> 
				<textarea rows="5" cols="30" name="description"></textarea>
			</div>
		</form>
	</div>
	<jsp:include page="../../basedef/form_opr_bt.jsp"/>
</body>
</html>