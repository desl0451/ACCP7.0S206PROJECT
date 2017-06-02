package cn.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.NewsDaoImpl;
import cn.easybuy.entity.News;

public class NewsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String strTitle = request.getParameter("title");
		strTitle=new String(strTitle.getBytes("ISO-8859-1"),"UTF-8");
		String strContent = request.getParameter("content");
		strContent=new String(strContent.getBytes("ISO-8859-1"),"UTF-8");
		try {
			//��������
			NewsDaoImpl dao = new NewsDaoImpl();
			//�������Ŷ���
			News news = new News();
			//�����Ᵽ�浽news����
			news.setTitle(strTitle);
			//�����ݱ��浽news����
			news.setContent(strContent);
			//������Ӷ���
			int i = dao.Add(news);
			if (i > 0) {
				out.print("<script>alert('�ɹ�!');location.href='manage/manage-result.jsp';</script>");
			} else {
				out.print("<script>alert('ʧ��!');location.href='manage/manage-result.jsp';</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		out.flush();
		out.close();
	}

}
