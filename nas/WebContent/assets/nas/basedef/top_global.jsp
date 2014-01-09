<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="top_eui_css.jsp" />
<jsp:include page="top_common_js.jsp" />
<script type="text/javascript">
$.extend($.fn.validatebox.defaults.rules, {
    isRepeat : { //验证用户Id是否有效
        validator : function(value, param) {
         var bl=false;
         console.log(value);
         console.log(param);
            return bl;
        },
        message : '已存在用户!'
    } 
   });
   
	
</script>