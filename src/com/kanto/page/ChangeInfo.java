package com.kanto.page;

import javax.servlet.annotation.WebServlet;

import com.kanto.page.base.BaseServlet;
import com.kanto.service.UpdateService;

@WebServlet(name="changeInfo", urlPatterns={"/changeInfo"})
public class ChangeInfo extends BaseServlet {
	//Mypage.jsp から UserInfoChange.jsp への画面遷移時に使用するサーブレット

	@Override
	protected String getPageName() {
		return "Mypage";
	}

	@Override
	protected String doAction() throws Exception {

		//受け取りたい要素に応じて変更すること
		String[] pageParam = super.getInputParameter(
				 "user_id"		// 0
		);

		//使うDAOによって変更すること
		UpdateService service = new UpdateService();
		service.deleteEmployee(Integer.parseInt(pageParam[0]));

		return "UserInfoChange";
	}

}