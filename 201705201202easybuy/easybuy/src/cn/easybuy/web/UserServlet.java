package cn.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.UserDaoImpl;

public class UserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//获得操作类型
		String req = request.getParameter("opr");
		if (req.equals("del")) {
			request.setCharacterEncoding("UTF-8");
			String id = (String) (request.getParameter("id"));
			int stats = Integer.parseInt(request.getParameter("stats"));
			// out.print(stats)
			if (stats == 2) {
				out.print("<script>alert('管理员不能删除!');location.href='manage/user.jsp';</script>");
			} else {
				UserDaoImpl dao = new UserDaoImpl();
				int did = dao.Delete(id);
				if (did > 0) {
					out.print("<script>alert('删除成功!');location.href='manage/user.jsp';</script>");
				} else {
					out.print("<script>alert('删除失败!');location.href='manage/user.jsp';</script>");
				}
			}
		}else if(req.equals("list")){
			
		}

		out.flush();
		out.close();
	}

	public void delete(HttpServletRequest request, HttpServletResponse response) {
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
