/*
 * 商品情報を取得します
 * ItemInfo.java
 */
package com.kanto.entity;

import com.kanto.entity.base.BaseEntity;

public class ItemInfo implements BaseEntity {
	public static final String ITEM_DIV_NM = "商品分類名";

	/** 商品情報 */
	private Item item;
	/** 商品分類名 */
	private String itemDivNm;

	public ItemInfo() {}
	public ItemInfo(Item itm) {
		this.item = itm;
	}

	/**
	 * 商品情報を取得します
	 * @return 商品情報
	 */
	public Item getItem() {
		return item;
	}
	/**
	 * 商品情報を設定します
	 * @param item 商品情報
	 */
	public void setItem(Item item) {
		this.item = item;
	}
	/**
	 * 商品分類名を取得します
	 * @return
	 */
	public String getItemDivNm() {
		return itemDivNm;
	}
	/**
	 * 商品分類名を設定します
	 * @param nmDepartment
	 */
	public void setItemDivNm(String itemDivNm) {
		this.itemDivNm = itemDivNm;
	}
}
