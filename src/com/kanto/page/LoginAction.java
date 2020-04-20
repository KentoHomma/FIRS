package com.kanto.page;

import java.util.Map;

import javax.servlet.annotation.WebServlet;

import com.kanto.page.base.BaseServlet;
import com.kanto.service.SearchService;

@WebServlet(name="loginAction", urlPatterns={"/loginAction"})
public class LoginAction extends BaseServlet {
	//Login.jsp から Top.jsp の画面遷移時に使用するサーブレット

	@Override
	protected String getPageName() {
		return "Login";
	}

	@Override
	protected String doAction() throws Exception {
		// 画面入力項目の取得
		String[] param = super.getInputParameter(
				"mail", //0
				"pass"	//1
				);
		System.out.println(param[0]);
		System.out.println(param[1]);
		// 入力チェック
		/*
		 * 必須チェックはHTML側で済みのため、Java側は特になし
		 */

		// ログイン処理
		SearchService service = new SearchService();
		Map<String, Object> loginData = service.doLogin(param[0], param[1]);

		// 結果の取得（検索結果0件）
		if (loginData == null || loginData.get("LOGIN_USER") == null) {
			request.setAttribute("errMsg", "入力された条件で情報が見つかりませんでした");
			throw new Exception("メールアドレスまたはパスワードが間違っています");
		}

		// 取得した情報をセッションへ格納
		super.session.setAttribute("LOGIN_USER", loginData.get("LOGIN_USER"));

		return "Top";
	}

}
