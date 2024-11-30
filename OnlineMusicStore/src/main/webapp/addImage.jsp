<!-- IT Number : IT22050908 -->
<!-- Name		 : Premaratne R.A.N.C. --> 

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Details</title>
</head>
<body>
	<h1 style="color: red" align="center">Add Song Details</h1>
	<div align="center">
		<form action="AddImage" method="post" enctype="multipart/form-data">
			Select Image : <input type="file" name="image"><br>
			<br> Enter the title : <input type="text" name="title"><br>
			<br> Enter artist name : <input type="text" name="artist"><br>
			<br> Select audio : <input type="file" name="audio"><br>
			<br> <input type="submit" value="Submit">
		</form>
	</div>
</body>
</html>