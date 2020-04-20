package com.kanto.page;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.kanto.entity.Item;
import com.kanto.entity.ItemInfo;
import com.kanto.page.base.BaseServlet;
import com.kanto.service.SearchService;

@WebServlet(name="selectByName", urlPatterns={"/selectByName"})
public class SelectByName extends BaseServlet {
	// Top.jsp から ItemList.jsp への画面遷移時に使用するサーブレット
	// EM-ServletのSelectAction.java からたくさん引用

	@Override
	protected String getPageName() {
		System.out.println("失敗！！");
		return "Top";
	}

	@Override
	protected String doAction() throws Exception {
		System.out.println("成功！！");

		//Top.jspのフォームに入力した値(name属性はinstrument_name)を受け取ってpageParam[0]に代入
		String[] pageParam = super.getInputParameter(
				"instrument_name"		// 0
				);
		System.out.println(pageParam[0]);

		// 入力チェック
		/*
		 * IDが数値でない場合は検索しなくても0件
		 */
		if (pageParam[0].trim().length() > 0) {
			try {
				Integer.parseInt(pageParam[0]);
			} catch (NumberFormatException e) {
				request.setAttribute("errMsg", "入力された条件で情報が見つかりませんでした");
				throw new Exception("入力された条件で情報が見つかりませんでした");
			}
		}

		// 画面入力値 -> DTOへ
		Item item = new Item();
		if (!"".equals(pageParam[0])) {
			item.setItemNm(pageParam[0]);
		}

		// 検索を行う
		SearchService service = new SearchService();
		List<ItemInfo> itemInfoList = service.searchItemInfo(item);

		// 検索結果の判定
		if (itemInfoList == null) {
			request.setAttribute("errMsg", "入力された条件で情報が見つかりませんでした");
			throw new Exception("入力された条件で情報が見つかりませんでした");
		} else {

			// 取得した結果をリクエストにセット
			super.request.setAttribute("itemInfoList", itemInfoList);
		}
		return "ItemList";
	}

}