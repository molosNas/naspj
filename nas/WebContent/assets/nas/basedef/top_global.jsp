<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="top_eui_css.jsp" />
<jsp:include page="top_common_js.jsp" />
<script type="text/javascript">
$.extend($.fn.validatebox.defaults.rules, {
	isRepeat: { //验证用户Id是否有效
		validator: function(value, param) {
			var bl = false;
			console.log(value);
			console.log(param);
			return bl;
		},
		message: '已存在用户!'
	}
});
var url;
function addData(_action, _tt) {
	$('#dlg').dialog('open').dialog('setTitle', _tt);
	$('#fm').form('clear');
	url = _action;
}
function editData(_action, _tt) {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', _tt);
		$('#fm').form('load', row);
		url = _action + '?id=' + row.id;
	} else {
		$.messager.alert('提示', '请选择需要操作的数据!', 'warning');
	}
}
function saveData() {
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
				$('#dlg').dialog('close');
				$('#tt').datagrid('reload');
			}
		}
	});
}
function delData(_action, _tt) {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		$.messager.confirm('Confirm', _tt,
		function(r) {
			if (r) {
				$.post(_action, {
					id: row.id
				},
				function(result) {
					if (result.success) {
						$('#tt').datagrid('reload');
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.errorMsg
						});
					}
				},
				'json');
			}
		});
	} else {
		$.messager.alert('提示', '请选择需要操作的数据!', 'warning');
	}
}	
</script>
