package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.User;

public interface UserDao {
	//��ѯȫ��
	public List<User> GetALL();
	public List<User> GetByCondition(User param);
	public int Add(User param);//���
	public int Delete(String param);//ɾ��
	public int Update(User param);//�޸�
}
