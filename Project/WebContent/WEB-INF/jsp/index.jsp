<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
	<link rel="stylesheet" type="text/css" href="index.css">
	</head>
	<body>
		<h1 align="center">ログイン画面</h1><br>
		<p style="color: red" align="center">${errorMessage}</p>
		<form action="Login" method="post">
			<div class="item" align="center">
			ログインID　　<input type="text" name="loginID" size="25"><br><br>
			パスワード　　<input type="password" name="password" size="25"><br><br><br>
			<input type="submit" value="ログイン">
			</div>

		</form>

	</body>
</html>