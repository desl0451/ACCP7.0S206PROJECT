package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Comment;

public interface CommentDao {
	public List<Comment> GetALL();// 查询全部
	public List<Comment> GetByCondition(Comment param);
	public int Add(Comment param);//添加
	public int Delete(int param);//删除
	public int Update(Comment param);//修改
}
