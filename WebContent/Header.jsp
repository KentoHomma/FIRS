<!-- 各ページの最上部。各ページにincludeして全ページ共通の編集をここだけで済ませられるようにするー -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>FIRS</title>

<link rel="stylesheet" href="stylesheet.css">
<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>

<body>

	<header>
		<div class="container">
			<div class="header-left">
				<a href="#"><h2>ファース-FIRS-</h2></a>
			</div>

			<span class="fa fa-bars menu-icon"></span>

			<div class="header-right">

			<c:if test="${(送られてきたフォームの内容).equals(既存ユーザーのmail,Pass)}">
				<a href="RegisterNew.jsp">新規登録</a> <a href="Login.jsp" class="login">ログイン</a>
			</c:if>

				<c:if test="${!(送られてきたフォームの内容).equals(既存ユーザーのmail,Pass)}">
				<a href="Mypage.jsp"
					class="login">マイページ</a>
			</c:if>
			</div>
		</div>
	</header>