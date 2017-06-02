package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Product;

public interface ProductDao {
	/**
	 * 查询全部产品
	 */
	public List<Product> GetALL();
	/**
	 * 根据ID查询商品
	 * @param id
	 * @return
	 */
	public Product GetById(Integer id);
	/**
	 * 添加产品
	 */
	public int Add(Product param);
	/**
	 * 修改产品
	 */
	public int update(Product param);
	/**
	 * 删除产品
	 */
	public int delete(int param);
}
