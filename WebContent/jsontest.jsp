<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery-3.2.1.js" type="text/javascript"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function requestJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/requestJson.action',
			contentType:'application/json;charset=utf-8',
			//发送的数据json串
			data:'{"name":"手机","price":1000}',
			success:function(data){
				alert(data.name);
			}
				
			
		});
		
	}
	function responseJson(){
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath}/responseJson.action',
			//发送的数据json串
			data:'name=手机&price=1200',
			success:function(data){
				alert(data.name);
			}
				
			
		});
		
	}

</script>

<body>
<input type="button" onclick="requestJson()" value="请求json，响应json">
<input type="button" onclick="responseJson()" value="请求key/value，响应json">
</body>
</html>