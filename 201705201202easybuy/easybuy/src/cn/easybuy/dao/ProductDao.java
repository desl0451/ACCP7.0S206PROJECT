package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Product;

public interface ProductDao {
	/**
	 * ��ѯȫ����Ʒ
	 */
	public List<Product> GetALL();
	/**
	 * ����ID��ѯ��Ʒ
	 * @param id
	 * @return
	 */
	public Product GetById(Integer id);
	/**
	 * ��Ӳ�Ʒ
	 */
	public int Add(Product param);
	/**
	 * �޸Ĳ�Ʒ
	 */
	public int update(Product param);
	/**
	 * ɾ����Ʒ
	 */
	public int delete(int param);
}
