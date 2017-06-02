package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.UserDao;
import cn.easybuy.entity.User;
import cn.easybuy.util.BaseDao;

public class UserDaoImpl extends BaseDao implements UserDao {

	
	public List<User> GetALL() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<User>();
		try {
			String sql = "select * from EASYBUY_USER";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("EU_USER_ID"));
				user.setUserName(rs.getString("EU_USER_NAME"));
				user.setSex(rs.getString("EU_SEX"));
				user.setEmail(rs.getString("EU_EMAIL"));
				user.setMobile(rs.getString("EU_MOBILE"));
				user.setAddress(rs.getString("EU_ADDRESS"));
				user.setStatus(rs.getInt("EU_STATUS"));
				user.setPassword(rs.getString("EU_PASSWORD"));
				user.setBirthday(rs.getDate("EU_BIRTHDAY"));
				user.setIdentityCode(rs.getString("EU_IDENTITY_CODE"));
				list.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeALL(conn, pstmt, rs);
		}
		return list;
	}

	
	public List<User> GetByCondition(User param) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int Add(User param) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int Delete(String param) {
		// TODO Auto-generated method stub
		String sql="DELETE FROM [easybuy].[dbo].[EASYBUY_USER]  WHERE EU_USER_ID=?";
		Object[] params={param};		
		return this.executeUpdate(sql, params);
	}

	
	public int Update(User param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
