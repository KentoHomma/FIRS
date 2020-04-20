<%@ page pageEncoding="utf-8"%>

<jsp:include page="Header.jsp" />

<div class="container">
	<div class="top-wrapper">

		<h1>セッションが保持されているときにだけ表示される→ ${ sessionScope.LOGIN_USER.mailAddress }</h1>
		<h1>｛キャッチコピー的な何か｝</h1>
		<p>FIRS(Folk Instruments Rental Service)-は、</p>
		<p>なかなか手に入らない民族楽器をレンタルでお試しできるサービスです。</p>
	</div>

	<div class="search-wrapper">

		<div class="heading">
			<h2>レンタル楽器検索</h2>
		</div>

		<div class="serche-types">
			<div class="search-type">
				<form action="selectByName" id="instrumentSearch-name" method="post">
					<div class="search-form">
						<p>名前検索</p>
						<input type="text" class="form-control" placeholder="例：チャランゴ"
							id="instrument_name" name="instrument_name" value="">
						<input type="submit" value="検索">
					</div>
				</form>
			</div>
			<div class="search-type">
				<form action="selectByCategory" id="instrumentSearch-category" method="post">
					<div class="search-form">
						<p>カテゴリ検索</p>
						<div class="category-btn">
							<!-- ここの部分はサーブレットで各楽器のカテゴリを受け取って一覧を流すページに飛ばすイメージ -->
							<input type="submit" name="category" value="弦楽器" /> <input
								type="submit" name="category" value="打楽器" /> <input
								type="submit" name="category" value="管楽器" /> <input
								type="submit" name="category" value="鍵盤楽器" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="item-wrapper">
	<div class="container">
		<div class="heading">
			<h2>レンタル楽器一覧</h2>
		</div>
		<div class="items">
			<div class="item">

				<!-- 個々の部分はfor文で商品マスタから画像、名前、カテゴリだけを抜き取ってだーーっと流すようなイメージ -->
				<img src="image/sample.jpg">
				<p>楽器１</p>
				<p class="text-contents">楽器１説明</p>
			</div>
			<div class="item">
				<img src="image/sample2.jpg">
				<p>楽器２</p>
				<p class="text-contents">楽器２説明</p>
			</div>
			<div class="item">
				<img src="image/sample.jpg">
				<p>楽器３</p>
				<p class="text-contents">楽器３説明</p>
			</div>
			<div class="item">
				<img src="image/sample2.jpg">
				<p>楽器４</p>
				<p class="text-contents">楽器４説明</p>
			</div>
			<div class="clear"></div>
		</div>
	</div>
</div>
<div class="message-wrapper">
	<div class="container">
		<div class="heading">
			<h2></h2>
			<h3>あなたもさっそく民族楽器の音色を楽しみませんか？</h3>
		</div>
		<span class="btn message">新規登録/楽器レンタル</span>
	</div>
</div>
<jsp:include page="Footer.jsp" />





