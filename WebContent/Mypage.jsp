<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="Header.jsp" />

<div class="item-wrapper">
<div class="container">
<div class="top-wrapper">
		<h2>マイページ</h2>
</div>

	<div class="heading">
		<h3>基本登録内容</h3>
	</div>
	<table>
		<thead>
			<tr>
				<th style="width: 60px;">氏名</th>
				<th style="width: 100px;">氏名カナ</th>
				<th style="width: 150px;">性別</th>
				<th style="width: 150px;">メルアド</th>
				<th style="width: 60px;">都道府県</th>
				<th style="width: 150px;">市町区村</th>
				<th style="width: 60px;">町域</th>
				<th style="width: 100px;">番地</th>
				<th style="width: 150px;">建物名</th>
				<th style="width: 150px;">電話番号</th>
				<th style="width: 60px;">パスワード</th>
					<th style="width: 60px;">カード番号</th>
				<th style="width: 100px;">カード名義</th>
				<th style="width: 150px;">有効期限</th>
				<th style="width: 150px;">セキュリティコード</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ userInfoList }" var="userInfo">
				<tr>
					<td><c:out value="${ userInfo.user_m.user_id }" /></td>
					<td><c:out value="${ userInfo.user_m.user_last_name }" /></td>
					<td><c:out value="${ userInfo.user_m.user_first_name }" /></td>
					<td><c:out value="${ userInfo.user_m.user_last_name_kn }" /></td>
					<td><c:out value="${ userInfo.user_m.user_first_name_kn }" /></td>
					<td><c:out value="${ userInfo.user_m.gender }" /></td>
					<td><c:out value="${ userInfo.user_m.mail_address }" /></td>
					<td><c:out value="${ userInfo.user_m.user_post_no }" /></td>
					<td><c:out value="${ userInfo.user_m.user_prefecture_nm }" /></td>
					<td><c:out value="${ userInfo.user_m.user_municipality_nm }" /></td>
					<td><c:out value="${ userInfo.user_m.user_city_nm }" /></td>
					<td><c:out value="${ userInfo.user_m.user_address }" /></td>
					<td><c:out value="${ userInfo.user_m.user_building_nm }" /></td>
					<td><c:out value="${ userInfo.user_m.user_tel_no }" /></td>
					<td><c:out value="${ userInfo.user_m.user_passwd }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<span class="btn message">登録情報編集</span>

	<div class="heading">
		<h3>レンタル情報</h3>
	</div>
		<table>
		<thead>
			<tr>
				<th style="width: 60px;">楽器名</th>
				<th style="width: 100px;">レンタル期限</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ empInfoList }" var="empInfo">
				<tr>
					<td><c:out value="${ empInfo.user_m.iduser_m }" /></td>
					<td><c:out value="${ empInfo.user_m.nmuser }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

		<span class="btn message">退会</span>

	</div>
</div>

<jsp:include page="Footer.jsp" />
