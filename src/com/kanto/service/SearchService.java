package com.kanto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kanto.dao.ItemDao;
import com.kanto.dao.UserDao;
import com.kanto.entity.Item;
import com.kanto.entity.ItemInfo;
import com.kanto.entity.User;
import com.kanto.entity.UserInfo;
import com.kanto.service.base.BaseService;
import com.kanto.util.DbUtil;

public class SearchService extends BaseService {

	public SearchService() throws Exception {
		super(false);
	}

	/**
	 * メールアドレス、パスワードでログイン判定を行う
	 * @param mail
	 * @param pass
	 * @return loginData
	 * @throws Exception
	 */
	public Map<String, Object> doLogin(String mail, String pass) throws Exception {
		Map<String, Object> loginData = new HashMap<>();
		UserDao dao = new UserDao(this.con);
		try {
			loginData.put("LOGIN_USER", dao.selectLoginInfo(mail, pass));
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return loginData;
	}

	/**
	 * 商品一覧を取得する
	 * @return
	 */
	private List<Item> getDivision() throws Exception {
		ItemDao dao = new ItemDao(this.con);
		List<Item> depList = null;
		depList = dao.findAll();
		return depList;
	}

	/**
	 * 商品検索を行う
	 * @param form
	 * @return
	 */
	public List<ItemInfo> searchItemInfo(Item itm) throws Exception {
		ItemDao dao = new ItemDao(this.con);
		List<ItemInfo> itemInfoList = null;
		try {
			itemInfoList = dao.findByParam(itm);
			if (itemInfoList.size() == 0) {
				itemInfoList = null;
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return itemInfoList;
	}

	/**
	 * アイテムカテゴリーで検索する
	 * @param itemDivCd
	 * @return
	 * @throws Exception
	 */
	public Item searchItemByCategory(Integer itemDivCd) throws Exception {
		ItemDao dao = new ItemDao(this.con);
		Item item = null;
		try {
			item = dao.findByPramaryKey(itemDivCd);
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return item;
	}

	/**
	 * メールアドレスの重複チェック
	 * @param id
	 * @param mail
	 * @return
	 * @throws Exception
	 */
	public boolean checkDuplicationMail(Integer id, String mail) throws Exception {
		// メールアドレスで検索を行う
		UserDao dao = new UserDao(this.con);
		User user = new User();
		try {
			user.setMailAddress(mail);
			List<UserInfo> userList = dao.findByParam(user);

			for (UserInfo userInfo : userList) {
				if (id == null ||
						id.equals(userInfo.getUser().getUserId()) == false) {
					return true;
				}
			}
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return false;
	}

}
