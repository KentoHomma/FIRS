/*
 * ユーザー情報を取得します
 * ItemInfo.java
 */
package com.kanto.entity;

import com.kanto.entity.base.BaseEntity;

public class UserInfo implements BaseEntity {

	/** ユーザー情報 */
	private User user;

	public UserInfo() {}
	public UserInfo(User user) {
		this.user = user;
	}

	/**
	 * ユーザー情報を取得します
	 * @return ユーザー情報
	 */
	public User getUser() {
		return user;
	}
	/**
	 * 商品情報を設定します
	 * @param item 商品情報
	 */
	public void setUser(User user) {
		this.user =user;
	}

}
