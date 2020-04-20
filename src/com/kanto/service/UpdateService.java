package com.kanto.service;

import java.util.ArrayList;
import java.util.List;

import com.kanto.dao.UserDao;
import com.kanto.entity.User;
import com.kanto.service.base.BaseService;
import com.kanto.util.DbUtil;

public class UpdateService extends BaseService {

	public UpdateService() throws Exception {
		super(true);
	}

	public enum UPDATE_MODE {
		 INSERT
		,UPDATE
	}

	/**
	 * ユーザーの登録・更新を行う
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int registEmployee(User user, UPDATE_MODE mode) throws Exception {
		UserDao dao = new UserDao(this.con);
		int count = -1;

		try {
			if (mode == UPDATE_MODE.INSERT) {
				count = dao.insertUser(user);
			} else if (mode == UPDATE_MODE.UPDATE){
				// DAO -> List<Object>（DAO#updateを呼び出すため）
				List<Object> paramList = new ArrayList<>();
				paramList.add(user.getUserId());
				paramList.add(user.getLastName());
				paramList.add(user.getFirstName());
				paramList.add(user.getLastNameKn());
				paramList.add(user.getFirstNameKn());
				paramList.add(user.getGender());
				paramList.add(user.getMailAddress());
				paramList.add(user.getPostNm());
				paramList.add(user.getPrefecture());
				paramList.add(user.getMunicipality());
				paramList.add(user.getCity());
				paramList.add(user.getAddress());
				paramList.add(user.getBuilding());
				paramList.add(user.getTel());
				paramList.add(user.getPassword());
				count = dao.updateByPrimaryKey(paramList, user.getUserId());
			}
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("登録できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return count;
	}

	/**
	 * ユーザー情報の物理削除を行う
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public int deleteUser(Integer userId) throws Exception {
		UserDao dao = new UserDao(this.con);
		int deleteCount = -1;

		try {
			deleteCount = dao.deleteByPrimaryKey(userId);
			this.con.commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.con.rollback();
			throw new Exception("削除できませんでした:" + e.getMessage());
		} finally {
			DbUtil.closeConnection(this.con);
		}
		return deleteCount;
	}

}
