package cn.easybuy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.NewsDaoImpl;
import cn.easybuy.entity.News;

public class NewsServlet extends HttpServlet {
	NewsDaoImpl dao = new NewsDaoImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		if (action.equals("add")) {
			addNews(request, response, out);
		} else if (action.equals("del")) {
			delNews(request, response, out);
		} else if (action.equals("list")) {
			displayNews(request, response, out);
		}
		out.flush();
		out.close();
	}

	public void displayNews(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws ServletException, IOException {
		List<News> newsList = dao.GetALL();
		request.getSession().setAttribute("newsList", newsList);
		response.sendRedirect("manage/news.jsp");
	}

	public void delNews(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int i = dao.delete(id);
		if (i > 0) {
			out.print("<script>alert('ɾ���ɹ�!');location.href='NewsServlet?action=list';</script>");
		} else {
			out.print("<script>alert('ɾ��ʧ��!');location.href='NewsServlet?action=list';</script>");
		}
	}

	public void addNews(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
			throws ServletException, IOException {
		String strTitle = request.getParameter("title");
		strTitle = new String(strTitle.getBytes("ISO-8859-1"), "UTF-8");
		String strContent = request.getParameter("content");
		strContent = new String(strContent.getBytes("ISO-8859-1"), "UTF-8");
		try {
			// �������Ŷ���
			News news = new News();
			// �����Ᵽ�浽news����
			news.setTitle(strTitle);
			// �����ݱ��浽news����
			news.setContent(strContent);
			// Date date = (new
			// SimpleDateFormat("yyyy-MM-dd")).parse(startdate);
			news.setCreateTime(new Timestamp((new java.util.Date()).getTime()));
			// ������Ӷ���
			int i = dao.Add(news);
			if (i > 0) {
				out.print("<script>alert('��ӳɹ�!');location.href='NewsServlet?action=list';</script>");
			} else {
				out.print("<script>alert('���ʧ��!');location.href='NewsServlet?action=list';</script>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
