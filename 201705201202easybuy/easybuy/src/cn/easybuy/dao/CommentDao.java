package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.Comment;

public interface CommentDao {
	public List<Comment> GetALL();// ��ѯȫ��
	public List<Comment> GetByCondition(Comment param);
	public int Add(Comment param);//���
	public int Delete(int param);//ɾ��
	public int Update(Comment param);//�޸�
}
