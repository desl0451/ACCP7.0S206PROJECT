package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.News;

public interface NewsDao {
	/**
	 * ��ѯȫ������
	 */
	public List<News> GetALL();
	
	/**
	 * �������
	 */
	public int Add(News param);
	/**
	 * �޸�����
	 */
	public int update(News param);
	/**
	 * ɾ������
	 */
	public int delete(int param);
}
