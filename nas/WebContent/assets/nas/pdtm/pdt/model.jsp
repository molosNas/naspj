<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spr:message code='pdtm.model.page.title'/></title>
<jsp:include page="../../basedef/top_global.jsp" />
<script type="text/javascript" src="assets/common/js/a_common_opr.js"></script>
<script type="text/javascript" src="assets/common/js/a_common_date.js"></script>

<script type="text/javascript">
$(function() {
	$("#tt").datagrid({
		title:"<spr:message code='pdtm.model.datagrid.title'/>",
		url:"list_model",
	    columns:[[   
	       {field:'id',title:"<spr:message code='pdtm.model.bean.id'/>",width:0,hidden:true}, 
	       {field:'codeId',title:"<spr:message code='pdtm.model.bean.encid'/>",width:20,align:'center'}, 
	       {field:'name',title:"<spr:message code='pdtm.model.bean.name'/>",width:30,align:'center'},   
	       {field:'description',title:"<spr:message code='pdtm.model.bean.description'/>",width:100,align:'center'},
	       {field:'modeltype',title:"<spr:message code='pdtm.model.bean.modeltype'/>",width:50,align:'center',formatter:function(row){
	    	   return row.name;
	       }},
	       {field:'ctime',title:"<spr:message code='pdtm.model.bean.ctime'/>",width:50,align:'center'},
	       {field:'utime',title:"<spr:message code='pdtm.model.bean.utime'/>",width:50,align:'center'},
	       {field:'dtime',title:"<spr:message code='pdtm.model.bean.dtime'/>",width:50,align:'center'},
	   ]],
	   toolbar: "#toolbar"
	});
	$('#cc').combobox({
        url:'map_td_modeltype',
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
	$(".easyui-datetimebox").each(function(){
		setVal($(this));
	});
}
function update(){
	$("input[name='name']").validatebox('remove');
	$("input[name='codeId']").validatebox('remove');
	$("input[name='name']").attr('readonly','readonly');
	$("input[name='codeId']").attr('readonly','readonly');
}
function setVal(obj){
	var curr_time = new Date();
	   var strDate = curr_time.getFullYear()+"-";
	   strDate += curr_time.getMonth()+1+"-";
	   strDate += curr_time.getDate()+"-";
	   strDate += curr_time.getHours()+":";
	   strDate += curr_time.getMinutes()+":";
	   strDate += curr_time.getSeconds();
	   $(obj).datetimebox({
		   value:strDate,
		   disabled:true
	   }); 
}
</script>
</head> 
<body>
	<table id="tt"></table>
	<div id="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addData('save_model','<spr:message code="pdtm.model.form.title.add"/>',add)"><spr:message code='datagrid.opr.add'/></a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData('update_model','<spr:message code='pdtm.model.form.title.update'/>',update)"><spr:message code='datagrid.opr.update'/></a>|
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delData('del_model','<spr:message code='pdtm.model.form.title.del.tip'/>')"><spr:message code='datagrid.opr.del'/></a>
	</div>
	<div id="dlg" class="easyui-dialog"
		style="width: 640px; height: 380px; padding: 10px 20px" closed="true"
		buttons="#dlg-buttons">
		<div class="ftitle"><spr:message code='pdtm.model.form.title.main'/></div>
		<form id="fm" method="post" novalidate>
			<div>
			<div style="float:left;">
					<div class="fitem">
						<label><spr:message code='pdtm.model.bean.encid'/>:</label> <input name="codeId"
							class="easyui-validatebox" required="true" validType="isRepeat['is_repeat_model_encid']"  invalidMessage="<spr:message code='pdtm.model.vail.encid'/>" />
					</div>
					<div class="fitem">
						<label> <spr:message code='pdtm.model.bean.name'/>:</label> <input name="name"
							class="easyui-validatebox" required="true" validType="isRepeat['is_repeat_model_name']"  invalidMessage="<spr:message code='pdtm.model.vail.name'/>" />
					</div>
					<div class="fitem">
						<label><spr:message code='pdtm.model.bean.modeltype'/>:</label>
						<input name="modeltype.id" id="cc" required="true" />
					</div>
				</div>
				<div style="float:right;"> 
					<div class="fitem">
						<label><spr:message code='pdtm.model.bean.ctime'/>:</label> <input name="ctime"
						type="text"	class="easyui-datetimebox"/>
					</div>
					<div class="fitem">
						<label><spr:message code='pdtm.model.bean.utime'/>:</label> <input name="utime"
						type="text"	class="easyui-datetimebox"/>
					</div>
					<div class="fitem">
						<label><spr:message code='pdtm.model.bean.dtime'/>:</label> <input name="dtime"
						 type="text" class="easyui-datetimebox"/>
					</div>
				</div>
			</div>
			<div style="clear: both;"></div>
			<div class="fitem">
				<label style="float: left;"><spr:message code='pdtm.model.bean.description'/>:</label> 
				<textarea rows="5" cols="45" name="description"></textarea>
			</div>
		</form>
	</div>
	<jsp:include page="../../basedef/form_opr_bt.jsp"/>
</body>
</html>