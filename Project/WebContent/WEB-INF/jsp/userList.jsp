<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザ一覧</title>
	<link rel="stylesheet" type="text/css" href="userList.css">
	</head>
	<body style="overflow-x: hidden;">
		<header>
			<span id = userName>${loginUser.name} さん</span>
			<span id = logOut><a href="index.html" style="color:#ff0000;text-decoration:none">ログアウト</a></span>

		</header>
	<div id="container">
		<h1>ユーザ一覧</h1>

		<a href="signUp.html" class= "signUp">新規登録</a><br>

		<form action="userList.html" method="post">
		<div align="center">
		<p>ログインID　　<input type="text" name="id" size="50"></p>
		<p>ユーザ名　　　<input type="text" name="userName" size="50"></p>
		<p>生年月日　　　<input type="date" name="birthday1" size="30" placeholder="年/月/日">
		　　～　　　
		<input type="date" name="birthday2" size="30" placeholder="年/月/日"><br><br></p>
		<p class="submit">
			<input type="submit" name="submit"  value="検索" style="WIDTH: 100px">
		</p>
		</div>
		</form>

		<hr width="90%">

		<table>
		<tr>
		<th>ログインID</th><th>ユーザ名</th><th>生年月日</th><th></th>
		</tr>


		<tr>
		<td>id0001</td><td>田中太郎</td><td>1989年04月26日</td>
		<td align="center"><a href="userDetail.html" class="detail_btn">　詳細　</a>
		<a href="userUpdate.html" class="update_btn">　更新　</a>
		<a href="userDelete.html" class="delete_btn">　削除　</a></td>
		</tr>


		<tr>
		<td>id0002</td><td>佐藤二郎</td><td>2001年11月12日</td>
		<td align="center"><a href="userDetail.html" class="detail_btn">　詳細　</a>
		<a href="userUpdate.html" class="update_btn">　更新　</a>
		<a href="userDelete.html" class="delete_btn">　削除　</a></td>
		</tr>
		<tr>
		<td>id0003</td><td>佐川真司</td><td>2000年01月01日</td>
		<td align="center"><a href="userDetail.html" class="detail_btn">　詳細　</a>
		<a href="userUpdate.html" class="update_btn">　更新　</a>
		<a href="userDelete.html" class="delete_btn">　削除　</a></td>
		</tr>
		</table>

	</div>

	</body>
</html>