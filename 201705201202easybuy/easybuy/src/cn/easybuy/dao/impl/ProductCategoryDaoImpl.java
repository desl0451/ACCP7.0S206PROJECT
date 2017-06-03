package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.ProductCategoryDao;
import cn.easybuy.entity.Comment;
import cn.easybuy.entity.ProductCategory;
import cn.easybuy.util.BaseDao;

public class ProductCategoryDaoImpl extends BaseDao implements ProductCategoryDao {

	public List<ProductCategory> getProductCategories(Long parentId) {
		// TODO Auto-generated method stub
		List<ProductCategory> pList = new ArrayList<ProductCategory>();
		String sql = "select * from  easybuy_product_category ";
		sql = sql + " order by epc_parent_id,epc_id";
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Comment> list = new ArrayList<Comment>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProductCategory p = new ProductCategory();
				p.setId(rs.getInt("epc_id"));
				p.setName(rs.getString("epc_name"));
				p.setParentId(rs.getInt("epc_parent_id"));
				pList.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeALL(conn, pstmt, rs);
		}
		return pList;
	}

}
