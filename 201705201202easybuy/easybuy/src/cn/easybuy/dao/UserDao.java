package cn.easybuy.dao;

import java.util.List;

import cn.easybuy.entity.User;

public interface UserDao {
	//查询全部
	public List<User> GetALL();
	public List<User> GetByCondition(User param);
	public int Add(User param);//添加
	public int Delete(String param);//删除
	public int Update(User param);//修改
}
