package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.NewsDao;
import cn.easybuy.entity.News;
import cn.easybuy.util.BaseDao;

public class NewsDaoImpl extends BaseDao implements NewsDao {
	/**
	 * 查询全部新闻
	 */

	public List<News> GetALL() {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<News> nList = new ArrayList<News>();
		try {
			String sql = "select top 9 * from EASYBUY_NEWS order by EN_CREATE_TIME desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("EN_ID"));
				news.setTitle(rs.getString("EN_TITLE"));
				news.setContent(rs.getString("EN_CONTENT"));
				news.setCreateTime(rs.getDate("EN_CREATE_TIME"));
				nList.add(news);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeALL(conn, pstmt, rs);
		}

		return nList;
	}


	
	public int Add(News param) {
		// TODO Auto-generated method stub
		String sql="INSERT INTO [easybuy].[dbo].[EASYBUY_NEWS]        ([EN_TITLE]          ,[EN_CONTENT])   VALUES  (?,?)";
		Object[] params={param.getTitle(),param.getContent()};
		return this.executeUpdate(sql, params);
	}


	
	public int update(News param) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public int delete(int param) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM [dbo].[EASYBUY_NEWS] WHERE EN_ID=?";
		Object[] params = { param };
		return this.executeUpdate(sql, params);
	}

}
