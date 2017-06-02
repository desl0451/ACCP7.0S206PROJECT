package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.News;

public interface NewsDao {
	/**
	 * 查询全部新闻
	 */
	public List<News> GetALL();
	
	/**
	 * 添加新闻
	 */
	public int Add(News param);
	/**
	 * 修改新闻
	 */
	public int update(News param);
	/**
	 * 删除新闻
	 */
	public int delete(int param);
}
