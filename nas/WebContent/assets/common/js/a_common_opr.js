$.extend($.fn.validatebox.defaults.rules, {
	isRepeat: { //验证单一字段是否重复
		validator: function(value, param) {
			var bl = false;
			$.ajax({
				type:"post",
				url:param[0],
				data:{ name :value },
				dataType:"json",
				async:false,
				success:function(data){
					if(data==1){
						bl=true;
					};
				}
			});
			return bl;
		},
		message: "不可重复！"
	}
});
$.extend($.messager.defaults,{  
    ok:"确定",  
    cancel:"取消"  
});  
$.extend($.fn.datagrid.defaults,{  
	hideColumn: 'id',
	striped:true,
	singleSelect:true,
	fitColumns:true,
	rownumbers:true,
	loadMsg:"数据装载中......",
	pagination:true
});  
$.extend($.fn.pagination.defaults,{  
	pageSize: 10,
	pageList: [5, 10, 50],
	beforePageText: '第',
	afterPageText: '页    共 {pages} 页',
	displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
});  
var url;
function addData(_action, _tt,func) {
	$('#dlg').dialog('open').dialog('setTitle', _tt);
	$('#fm').form('clear');
	if(func!=null&&func!=undefined){
		func();
	}
	url = _action;
}
function editData(_action, _tt,func) {
	var row = $('#tt').datagrid('getSelected');
	if (row) {
		if(func!=null&&func!=undefined){
			func();
		}
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
					if (result==1) {
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
$.extend($.fn.validatebox.methods, {  
    remove: function(jq, newposition){  
        return jq.each(function(){  
            $(this).removeClass("validatebox-text validatebox-invalid").unbind('focus').unbind('blur');
        });  
    },
    reduce: function(jq, newposition){  
        return jq.each(function(){  
           var opt = $(this).data().validatebox.options;
           $(this).addClass("validatebox-text").validatebox(opt);
        });  
    }   
});

