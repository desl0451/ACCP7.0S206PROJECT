package cn.easybuy.test;

import java.text.SimpleDateFormat;

import cn.easybuy.dao.impl.NewsDaoImpl;
import cn.easybuy.entity.News;

public class Test {

	public static void main(String[] args) {
		// NewsDaoImpl dao = new NewsDaoImpl();
		// List<News> newList = dao.GetALL();
		// for (News news : newList) {
		// System.out.println(news.getTitle());
		// System.out.println(news.getCreateTime());
		// }

//		UserDaoImpl dao = new UserDaoImpl();
//		List<User> userList = dao.GetALL();
//		for (User user : userList) {
//			System.out.println(user.getUserId());
//			System.out.println(user.getUserName());
//			System.out.println(user.getSex());
//			System.out.println(user.getEmail());
//			System.out.println(user.getMobile());
//
//		}
//		ProductDaoImpl dao = new ProductDaoImpl();
//		List<Product> list = dao.GetALL();
//		for (Product p : list) {
//			System.out.println(p.getFileName());
//		}
//		CommentDaoImpl dao=new CommentDaoImpl();
//		List<Comment> list=dao.GetALL();
//		for(Comment c:list){
//			System.out.println(c.getNickName());
//			System.out.println(c.getContent());
//		}
		try {
			
			NewsDaoImpl dao = new NewsDaoImpl();
			News news = new News();
			news.setTitle("今天天气真不错");
			news.setContent("下暴雨，刮大风。");

			int i = dao.Add(news);
			if (i>0) {
				System.out.println("添加");
			}else{
				System.out.println("失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
