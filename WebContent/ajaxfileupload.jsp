<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>photo</title>
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
<script src="js/ajaxfileupload.js" type="text/javascript"></script>
<style>
#photo {
	width: 300px;
	height: 400px;
	text-align: center;
	margin: 0 auto;
	border: 1px solid #000;
}
</style>
</head>
 
<body>
	<center>
		<h3>图片上传</h3>
	</center>
	<hr />
	<form name="form1" method="post" action=""
		enctype="multipart/form-data">
		<table width="373" height="634" border="1" align="center"
			cellpadding="0" cellspacing="0">
			<tr>
				<td height="458" align="center"><div id="photo"></div></td>
			</tr>
			<tr>
				<td height="174" align="center" bgcolor="#99FFFF">
				<input type="file" name="upfile" id="upfilePhotoId" onchange="upfilePhoto();"/>
				</td>
			</tr>
		</table>
	</form>
 
	<script type="text/javascript" charset="UTF-8">
		function upfilePhoto() {
 
			$.ajaxFileUpload({
						url : "upfile.action",
						secureuri : false,
						fileElementId : "upfilePhotoId",
						dataType : 'text',
						success : function(data) {
 
							$("#photo").html("<img  width='300px' height='400px' src='"+data+"'/>");
 
						},
						error : function(XMLHttpRequest, textStatus,errorThrown) {
							alert('上传失败！');
						}
					});
		};
	</script>
</body>
</html>
