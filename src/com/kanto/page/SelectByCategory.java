package com.kanto.page;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.kanto.entity.Item;
import com.kanto.page.base.BaseServlet;
import com.kanto.service.SearchService;

@WebServlet(name="selectByCategory", urlPatterns={"/selectByCategory"})
public class SelectByCategory extends BaseServlet {
	//Top.jsp から ItemList.jsp への画面遷移時に使用するサーブレット

	@Override
	protected String getPageName() {
		return "Top";
	}

	@Override
	protected String doAction() throws Exception {

		//Top.jspでクリックしたカテゴリー名(name属性はcategory)を受け取ってpageParam[0]に代入
		String[] pageParam = super.getInputParameter(
				"category"		// 0
				);

		// 画面入力値 -> DTOへ
		Item item = new Item();
		if (!"".equals(pageParam[0])) {
			item.setItemDivCd(pageParam[0]);
		}

		// 検索を行う
		SearchService service = new SearchService();
		List<ItemInfo> itemInfoList = service.searchItemByCategory(item);
		super.request.setAttribute("itemInfoList", itemInfoList);

		return "ItemList";
	}

}