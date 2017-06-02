package cn.easybuy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.easybuy.dao.ProductDao;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.util.BaseDao;

public class ProductDaoImpl extends BaseDao implements ProductDao {

	public Product GetById(Integer id) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Product pro = new Product();
		try {
			String sql = "select * from EASYBUY_PRODUCT where EP_ID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro.setCid(rs.getInt("EPC_ID"));
				pro.setDescription(rs.getString("EP_DESCRIPTION"));
				pro.setFileName(rs.getString("EP_FILE_NAME"));
				pro.setId(rs.getInt("EP_ID"));
				pro.setName(rs.getString("EP_NAME"));
				pro.setPrice(rs.getFloat("EP_PRICE"));
				pro.setStock(rs.getInt("EP_STOCK"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeALL(conn, pstmt, rs);
		}

		return pro;
	}

	public List<Product> GetALL() {
		Connection conn = getConnection();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Product> nList = new ArrayList<Product>();
		try {
			String sql = "select * from EASYBUY_PRODUCT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Product pro = new Product();
				pro.setCid(rs.getInt("EPC_ID"));
				pro.setDescription(rs.getString("EP_DESCRIPTION"));
				pro.setFileName(rs.getString("EP_FILE_NAME"));
				pro.setId(rs.getInt("EP_ID"));
				pro.setName(rs.getString("EP_NAME"));
				pro.setPrice(rs.getFloat("EP_PRICE"));
				pro.setStock(rs.getInt("EP_STOCK"));
				nList.add(pro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeALL(conn, pstmt, rs);
		}

		return nList;
	}

	public int Add(Product param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int update(Product param) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int delete(int param) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM [dbo].[EASYBUY_PRODUCT] WHERE EP_ID=?";
		Object[] params = { param };
		return this.executeUpdate(sql, params);
	}

}
