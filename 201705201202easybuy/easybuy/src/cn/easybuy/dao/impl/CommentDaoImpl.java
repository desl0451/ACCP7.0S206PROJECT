package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.CommentDao;
import cn.easybuy.entity.Comment;
import cn.easybuy.util.BaseDao;

public class CommentDaoImpl extends BaseDao implements CommentDao {

	
	public List<Comment> GetALL() {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			String sql = "select * from EASYBUY_COMMENT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Comment c = new Comment();
				c.setNickName(rs.getString("EC_NICK_NAME"));
				c.setCreateTime(rs.getDate("EC_CREATE_TIME"));
				c.setContent(rs.getString("EC_CONTENT"));
				c.setId(rs.getLong("EC_ID"));
				c.setReply(rs.getString("EC_REPLY"));
				c.setReplyTime(rs.getDate("EC_REPLY_TIME"));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeALL(conn, pstmt, rs);
		}
		return list;
	}

	
	public List<Comment> GetByCondition(Comment param) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public int Add(Comment param) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int Delete(int param) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int Update(Comment param) {
		// TODO Auto-generated method stub
		return 0;
	}

}
