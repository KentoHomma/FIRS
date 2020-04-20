package com.kanto.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kanto.dao.base.BaseDao;
import com.kanto.entity.User;
import com.kanto.entity.UserInfo;
import com.kanto.util.Util;

public class UserDao extends BaseDao<User> {

	public UserDao(Connection con) {
		super(con);
	}

	/**
	 * ユーザー検索を行う (ユーザーID,メールアドレス（ログインで使用）)
	 * @param user 検索条件
	 * @return
	 */
	public List<UserInfo> findByParam(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT");
		sql.append("      u.user_id");
		sql.append("      u.mail_address");
		sql.append(" FROM");
		sql.append("     user_m u");

		String keyword = " WHERE ";
		List<Object> paramList = new ArrayList<>();

		if (user.getUserId() != null) {
			sql.append(keyword + " u.user_id = ?");
			paramList.add(user.getUserId());
			keyword = " AND ";
		}

		if (!(Util.isStringEmpty(user.getMailAddress()))) {
			sql.append(keyword + " u.mail_address LIKE ?");
			paramList.add("%" + user.getMailAddress() + "%");
			keyword = " AND ";
		}

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(paramList.toArray());

		ResultSet rs = stmt.executeQuery();

		// 検索結果の取得
		List<UserInfo> userList = new ArrayList<>();
		while (rs.next()) {
			UserInfo userInfo = new UserInfo(rowMapping(rs));
			userList.add(userInfo);
		}

		// 見つからなかった
		this.closeStatement();
		return userList;
	}

	/**
	 * ログインで入力された情報で検索を行う
	 * @param mail
	 * @param pass
	 * @return ログイン情報に合致したユーザー情報
	 */
	public User selectLoginInfo(String mail, String pass) throws SQLException {
		User entity = null;
		StringBuilder sql = new StringBuilder();

		// SQLの生成
		sql.append(" SELECT * FROM " + this.getTableName());
		sql.append(" WHERE mail_address = ? AND user_passwd = ?");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(mail, pass);

		ResultSet rs = stmt.executeQuery();

		// 主キー検索のため、0件、または1件と想定
		if (rs.next()) {
			entity = rowMapping(rs);
		}

		// 見つからなかった
		this.closeStatement();
		return entity;
	}

	/**
	 * ユーザー情報の登録を行う
	 * @param emp
	 * @return
	 */
	public int insertUser(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO " + this.getTableName());
		sql.append("(");
		sql.append("    user_last_name");
		sql.append("    ,user_first_name");
		sql.append("    ,user_last_name_kn");
		sql.append("    ,user_first_name_kn");
		sql.append("    ,gender");
		sql.append("    ,mail_address");
		sql.append("    ,user_post_no");
		sql.append("    ,user_prefecture_nm");
		sql.append("    ,user_municipality_nm");
		sql.append("    ,user_city_nm");
		sql.append("    ,user_address");
		sql.append("    ,user_building_nm");
		sql.append("    ,user_tel_no");
		sql.append("    ,user_passwd");
		sql.append(") VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");

		// Statementの生成および条件の設定
		this.stmt = this.con.prepareStatement(sql.toString());
		setParameter(
				user.getLastName(), user.getFirstName(), user.getLastNameKn(), user.getFirstNameKn(), user.getGender(),
				user.getMailAddress(), user.getPostNm(), user.getPrefecture(), user.getMunicipality(), user.getCity(),
				user.getAddress(), user.getBuilding(), user.getTel(), user.getPassword()

		);

		int count = this.stmt.executeUpdate();

		this.closeStatement();
		return count;
	}

	@Override
	protected String getTableName() {
		return "user_m";
	}

	@Override
	protected User rowMapping(ResultSet rs) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("user_id"));
		user.setLastName(rs.getString("user_last_name"));
		user.setFirstName(rs.getString("user_first_name"));
		user.setLastNameKn(rs.getString("user_last_name_kn"));
		user.setFirstNameKn(rs.getString("user_first_name_kn"));
		user.setGender(rs.getString("gender"));
		user.setMailAddress(rs.getString("mail_address"));
		user.setPostNm(rs.getString("user_post_no"));
		user.setPrefecture(rs.getString("user_prefecture_nm"));
		user.setMunicipality(rs.getString("user_municipality_nm"));
		user.setCity(rs.getString("user_city_nm"));
		user.setAddress(rs.getString("user_address"));
		user.setBuilding(rs.getString("user_building_nm"));
		user.setTel(rs.getString("user_tel_no"));
		user.setPassword(rs.getString("user_passwd"));
		return user;
	}

	@Override
	protected String[] getColumnsList() {
		return new String[] {
				"user_id", "user_last_name", "user_first_name", "user_last_name_kn", "user_first_name_kn", "gender",
				"mail_address", "user_post_no", "user_prefecture_nm", "user_municipality_nm", "user_city_nm",
				"user_address", "user_building_nm", "user_tel_no", "user_passwd"
		};
	}

	@Override
	protected String[] getPrimaryKey() {
		return new String[] {
				"user_Id"
		};
	}
}
