<%@ page pageEncoding="utf-8"%>

<jsp:include page="Header.jsp" />


<div class="item-wrapper">
	<div class="heading">
		<h2>検索結果一覧</h2>
	</div>
	<div class="container">
		<div class="items">
			<div class="item">

				<!-- EMservletだとこういう風に引っ張ってたという例
							<table>
		<thead>
			<tr>
				<th style="width: 60px;">社員ID</th>
				<th style="width: 100px;">社員名</th>
				<th style="width: 150px;">フリガナ</th>
				<th style="width: 150px;">メールアドレス</th>
				<th style="width: 60px;">パスワード</th>
				<th style="width: 150px;">所属部署</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${ empInfoList }" var="empInfo">
				<tr>
					<td><c:out value="${ empInfo.employee.idEmployee }" /></td>
					<td><c:out value="${ empInfo.employee.nmEmployee }" /></td>
					<td><c:out value="${ empInfo.employee.knEmployee }" /></td>
					<td><c:out value="${ empInfo.employee.mailAddress }" /></td>
					<td><c:out value="${ empInfo.employee.password }" /></td>
					<td><c:out value="${ empInfo.nmDepartment }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

						なので、表形式にする必要がない今回はおそらく以下のみでOK-->
				<c:forEach items="${ itemInfoList }" var="itemInfo">
					<c:out value="${ itemInfo.item. }" />
					<c:out value="${ itemInfo.item. }" />
					<c:out value="${ itemInfo.item. }" />
				</c:forEach>
			</div>
		</div>

		<div class="heading">
			<h1>ここに商品一覧がTOPページの商品一覧と同じく1行ごとに4個ずつ表示されていく</h1>
			<a href="Top.jsp"> <a-black> TOPページに戻る</a-black></a>
		</div>
	</div>
</div>

<jsp:include page="Footer.jsp" />
