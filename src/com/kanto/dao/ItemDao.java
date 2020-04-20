package com.kanto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kanto.dao.base.BaseDao;
import com.kanto.entity.Item;
import com.kanto.entity.ItemInfo;
import com.kanto.util.Util;

public class ItemDao extends BaseDao<Item> {

	public ItemDao(Connection con) {
		super(con);
	}

	/**
	 * 条件検索を行う (商品名、商品説明、商品分類名)
	 * @param itm 検索条件
	 * @return 検索結果
	 */
	public List<ItemInfo> findByParam(Item itm) throws SQLException {
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT");
		sql.append("      i.item_nm");
		sql.append("      i.item_description");
		sql.append("     ,d.item_div_cd");
		sql.append(" FROM");
		sql.append("     item_m i INNER JOIN item_div_m d");
		sql.append("         ON i.item_div_cd = d.item_div_cd");

		String keyword = " WHERE ";
		List<Object> paramList = new ArrayList<>();

		if (itm.getItemNm() != null) {
			sql.append(keyword + " i.item_nm = ?");
			paramList.add(itm.getItemNm());
			keyword = " AND ";
		}

		if (!(Util.isStringEmpty(itm.getItemDescription()))) {
			sql.append(keyword + " i.item_description LIKE ?");
			paramList.add("%" + itm.getItemDescription() + "%");
			keyword = " AND ";
		}

		if (itm.getItemDivCd() != null) {
			sql.append(keyword + " i.item_div_cd = ?");
			paramList.add(itm.getItemDivCd());
			keyword = " AND ";
		}

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(paramList.toArray());

		ResultSet rs = stmt.executeQuery();

		// 検索結果の取得
		List<ItemInfo> itmList = new ArrayList<>();
		while (rs.next()) {
			ItemInfo itmInfo = new ItemInfo(rowMapping(rs));
			itmInfo.setItemDivNm(rs.getString("item_div_cd"));
			itmList.add(itmInfo);
		}

		// 見つからなかった
		this.closeStatement();
		return itmList;
	}

	/**
		 * 商品情報の登録を行う
		 * @param itm
		 * @return
		 */
	public int insertItem(Item itm) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO " + this.getTableName());
		sql.append("(");
		sql.append("    ,item_id");
		sql.append("    ,item_nm");
		sql.append("    ,item_image");
		sql.append("    ,item_price");
		sql.append("    ,item_stock");
		sql.append("    ,item_description");
		sql.append("    ,item_div_cd");
		sql.append(") VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(
				itm.getItemId(),
				itm.getItemNm(),
				itm.getItemImage(),
				itm.getItemPrice(),
				itm.getItemStock(),
				itm.getItemDescription(),
				itm.getItemDivCd());

		int count = this.stmt.executeUpdate();

		this.closeStatement();
		return count;
	}

	@Override
	protected String getTableName() {
		return "item";
	}

	@Override
	protected Item rowMapping(ResultSet rs) throws SQLException {
		Item item = new Item();
		item.setItemId(rs.getInt("item_id"));
		item.setItemNm(rs.getString("item_nm"));
		item.setItemImage(rs.getString("item_image"));
		item.setItemPrice(rs.getString("item_price"));
		item.setItemStock(rs.getString("item_stock"));
		item.setItemDescription(rs.getString("item_description"));
		item.setItemDivCd(rs.getString("item_div_cd"));

		return item;
	}

	@Override
	protected String[] getColumnsList() {
		return new String[] {
				"item_id", "item_nm", "item_image", "item_price", "item_stock", "item_description", "item_div_cd"
		};
	}

	@Override
	protected String[] getPrimaryKey() {
		return new String[] {
				"ItemId"
		};
	}
}
