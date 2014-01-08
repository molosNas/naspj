$("#_save").click(function() {
	$('#fm').form('submit', {
		url: url,
		onSubmit: function() {
			return $(this).form('validate');
		},
		success: function(data) {
			var result = jQuery.parseJSON(data);
			if (result.suc == '0') {
				$('#dlg').dialog('close');
				$('#tt').datagrid('reload');
				$.messager.show({
					title: '提示',
					msg: result.opr + "品牌<span style='color: green;'>" + result.msg + "</span>成功!",
					timeout: 3000
				});
			} else if (result.suc == '2') {
				$.messager.alert('警告！', "<span style='color: red;'>必须添加图片文件！</span>", 'info');
			} else if (result.suc == '1') {
				$.messager.alert('警告！', "<span style='color: red;'>品牌名称重复！</span>", 'info');
			} else {
				$('#dlg').dialog('close');
				$.messager.show({
					title: '提示',
					msg: result.opr + "品牌<span style='color: red;'>" + result.msg + "</span>失败!",
					timeout: 3000
				});

			}
		}
	});
});
function add() {
	$('#dlg').dialog('open').dialog('setTitle', '新增品牌');
	$('#fm').form('clear');
	url = 'brandAction!addBrand.actionx';
}
function edit() {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		$('#dlg').dialog('open').dialog('setTitle', '修改品牌');
		$('#fm').form('load', row);
		url = 'brandAction!updateBrand.actionx';
	} else {
		$.messager.alert('警告！', '请选中一条记录！', 'info');
	}
}
function remove() {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		$.messager.confirm('确认', '确定删除当前记录吗?',
		function(r) {
			if (r) {
				$.post('brandAction!delete.actionx?path=' + row.picPath, {
					id: row.id
				},
				function(data) {
					if (data.suc == '0') {
						$('#tt').datagrid('reload');
						$.messager.show({
							title: '提示',
							msg: "删除品牌<span style='color: green;'>" + row.brandName + "</span>成功!",
							timeout: 3000
						});
					} else if (data.suc == '1') {
						$.messager.alert('错误', '该品牌下还存在型号数据！不能删除！', 'info');
					} else {
						$.messager.alert('错误', '删除失败！', 'info');
					}
				},
				'json');
			}
		});
	} else {
		$.messager.alert('警告！', '请选中一条需要删除记录！', 'info');
	}
}
// 取消弹出的编辑框
//$("#_cancel").click(function() {
//	$('#dlg').dialog('close');
//});

//搜索功能
function searchBrand() {
	var param = "";
	$('#search_bra input').each(function(i) {
		//此处取出的参数不是很合适，但可以通过后台处理
		if ($(this).text() != null || $(this).text() != "") {
			param = param + $(this).val() + " ,";
		}
	});

	url = "brandAction!searchByParam.actionx?param=" + param;
	$('#brSerarch').form('submit', {
		url: url,
		onSubmit: function() {
			return true;
		},
		success: function(data) {
			var result = jQuery.parseJSON(data);
			if (result.success == "true") {
				$('#tt').datagrid('loadData', result);
			}
			if (result.success == "false") {
				alert("没有相关数据！");
				$('#tt').datagrid('reload');
			}
		}
	});
}