/*
 * UserのDTO
 * User.java
 */
package com.kanto.entity;

import com.kanto.entity.base.BaseEntity;

/**
 * ユーザーマスタテーブルのEntity
 * @author Yoshinaga
 *
 */
public class User implements BaseEntity {
	public static final String USER_ID = "ユーザーID";
	public static final String USER_LAST_NAME = "姓";
	public static final String USER_FIRST_NAME = "名";
	public static final String USER_LAST_NAME_KN = "セイ";
	public static final String USER_FIRST_NAME_KN = "メイ";
	public static final String GENDER = "性別";
	public static final String MAIL_ADDRESS = "メールアドレス";
	public static final String USER_POST_NO = "郵便番号";
	public static final String USER_PREFECTURE_NM = "県名";
	public static final String USER_MUNICIPALITY_NM = "市区町村";
	public static final String USER_CITY_NM = "町域";
	public static final String USER_ADDRESS = "番地";
	public static final String USER_BUILDING_NM = "建物名";
	public static final String USER_TEL_NO = "電話番号";
	public static final String USER_PASSWD = "パスワード";

	/** ユーザーID */
	private Integer userId;
	/** ユーザー姓 */
	private String lastName;;
	/** ユーザー名 */
	private String firstName;
	/** ユーザーセイ */
	private String lastNameKn;
	/** ユーザーメイ */
	private String firstNameKn;
	/** 性別 */
	private String gender;
	/** メールアドレス */
	private String mailAddress;
	/** 郵便番号 */
	private String postNm;
	/** 県名 */
	private String prefecture;
	/** 市区町村 */
	private String municipality;
	/** 町域 */
	private String city;
	/** 番地 */
	private String address;
	/** 建物名 */
	private String building;
	/** 電話番号 */
	private String tel;
	/** パスワード */
	private String password;

	/**
	 * 各情報の取得(getter)
	 * 		get～()
	 * 各情報の設定(setter)
	 * 		set～(～)
	 */

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastNameKn() {
		return lastNameKn;
	}

	public void setLastNameKn(String lastNameKn) {
		this.lastNameKn = lastNameKn;
	}

	public String getFirstNameKn() {
		return firstNameKn;
	}

	public void setFirstNameKn(String firstNameKn) {
		this.firstNameKn = firstNameKn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public String getPostNm() {
		return postNm;
	}

	public void setPostNm(String postNm) {
		this.postNm = postNm;
	}

	public String getPrefecture() {
		return prefecture;
	}

	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
