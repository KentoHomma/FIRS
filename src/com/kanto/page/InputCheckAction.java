/*
 * InputCheckAction.java
 *   作成	IT-College	2016
 *------------------------------------------------------------
 * Copyright(c) Rhizome Inc. All Rights Reserved.
 */
package com.kanto.page;

import javax.servlet.annotation.WebServlet;

import com.kanto.entity.Employee;
import com.kanto.page.base.BaseServlet;
import com.kanto.service.SearchService;

/**
 * 社員登録情報の確認を行うページクラスです
 * メールアドレスが既に登録されているか判定します
 * @author IT-College
 *
 */
@WebServlet(name="inputCheck", urlPatterns={"/inputCheck"})
public class InputCheckAction  extends BaseServlet {

	@Override
	protected String getPageName() {
		return "insert";
	}

	@Override
	protected String doAction() throws Exception {
		String[] pageParam = super.getInputParameter(
				 "empNm"	// 0
				,"empKn"	// 1
				,"mail"		// 2
				,"pass"		// 3
				,"depId"	// 4

			);

		Employee employee = new Employee();
		employee.setMailAddress(pageParam[2]);

		SearchService service = new SearchService();
		if (service.checkDuplicationMail(null, pageParam[2])) {
			throw new Exception("入力されたメールアドレスは既に存在しています");
		}

		return "insertConfirm";
	}
}
