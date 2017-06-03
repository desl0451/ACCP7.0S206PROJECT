package cn.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.CommentDaoImpl;
import cn.easybuy.entity.Comment;

public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("list")) {
			CommentDaoImpl comment = new CommentDaoImpl();
			List<Comment> cList = comment.GetALL();
			request.getSession().setAttribute("cList", cList);
		}
		response.sendRedirect("manage/guestbook.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
