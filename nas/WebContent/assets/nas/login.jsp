<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="basedef/top_common_js.jsp" />
<jsp:include page="basedef/top_encp_js.jsp" />
<script type="text/javascript">
	$(function() {
		$("a").click(
				function() {

					//vail
					$("input[name='pazzwd']").val(
							SHA256($("input[name='pazzwd']").val()));
					$("form").submit();
				});
	});
</script>
</head>
<body>${msg }
	<h1>login page</h1>
	<form action="main" method="post">
		username:<input type="text" name="uname" /><br> password:<input
			type="password" name="pazzwd" /><br> <a href="javascript:void;">登陆</a>
	</form>
</body>
</html>