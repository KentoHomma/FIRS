/*
 * InsertAction.java
 *   作成	IT-College	2016
 *------------------------------------------------------------
 * Copyright(c) Rhizome Inc. All Rights Reserved.
 */
package com.kanto.page;

import javax.servlet.annotation.WebServlet;

import com.kanto.entity.Employee;
import com.kanto.page.base.BaseServlet;
import com.kanto.service.UpdateService;
import com.kanto.service.UpdateService.UPDATE_MODE;

/**
 * 社員情報の登録を行う画面に対応したクラスです
 * 入力されたパスワードと確認パスワードが一致しているか判定します。
 * @author IT-College
 *
 */
@WebServlet(name="insert", urlPatterns={"/insert"})
public class InsertAction extends BaseServlet {
	@Override
	protected String getPageName() {
		return "insertConfirm";
	}

	@Override
	protected String doAction() throws Exception {

		String[] pageParam = super.getInputParameter(
				 "empNm"		// 0
				,"empKn"		// 1
				,"mail"			// 2
				,"pass"			// 3
				,"passConfirm"	// 4
				,"depId"		// 5
				/*
				 * 登録->内容編集時の値保持バグの修正
				 */
				,"editFlg"	// 6
		);

		/*
		 * 登録->内容編集時の値保持バグの修正
		 */
		if ("edit".equals(pageParam[6])) {
			return "insert";
		}

		if (!pageParam[3].equals(pageParam[4])) {
			throw new Exception("パスワードが一致していません");
		}

		Employee emp = new Employee();
		emp.setNmEmployee(pageParam[0]);
		emp.setKnEmployee(pageParam[1]);
		emp.setMailAddress(pageParam[2]);
		emp.setPassword(pageParam[3]);
		emp.setIdDepartment(Integer.parseInt(pageParam[5]));

		UpdateService service = new UpdateService();
		service.registEmployee(emp, UPDATE_MODE.INSERT);

		return "insertResult";
	}
}
