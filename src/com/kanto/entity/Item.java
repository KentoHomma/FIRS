/*
 * 商品のDTO
 * Item.java
 */
package com.kanto.entity;

import com.kanto.entity.base.BaseEntity;

/**
 * 商品マスタテーブルのEntity
 * @author Yoshinaga
 *
 */
public class Item implements BaseEntity {
	public static final String ITEM_ID = "商品ID";
	public static final String ITEM_DIV_CD = "商品分類コード";
	public static final String ITEM_NM = "商品名";
	public static final String ITEM_IMAGE = "商品画像";
	public static final String ITEM_PRICE = "価格";
	public static final String ITEM_STOCK = "在庫数";
	public static final String ITEM_DESCRIPTION = "商品説明";

	/** 商品ID */
	private Integer itemId;
	/** 商品分類コード */
	private String itemDivCd;;
	/** 商品名 */
	private String itemNm;
	/** 商品画像 */
	private String itemImage;
	/** 価格 */
	private String itemPrice;
	/** 在庫数 */
	private String itemStock;
	/** 商品説明 */
	private String itemDescription;

	/**
	 * 各情報の取得(getter)
	 * 		get～()
	 * 各情報の設定(setter)
	 * 		set～(～)
	 */
	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getItemDivCd() {
		return itemDivCd;
	}

	public void setItemDivCd(String itemDivCd) {
		this.itemDivCd = itemDivCd;
	}

	public String getItemNm() {
		return itemNm;
	}

	public void setItemNm(String itemNm) {
		this.itemNm = itemNm;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}
