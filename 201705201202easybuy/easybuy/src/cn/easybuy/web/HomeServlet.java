package cn.easybuy.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.NewsDaoImpl;
import cn.easybuy.dao.impl.ProductCategoryDaoImpl;
import cn.easybuy.dao.impl.ProductDaoImpl;
import cn.easybuy.entity.News;
import cn.easybuy.entity.Product;
import cn.easybuy.entity.ProductCategory;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = (String) request.getParameter("action");
		if (action.equals("index")) {// 显示首页内容
			// ##########新闻###########
			NewsDaoImpl dao = new NewsDaoImpl();
			List<News> newList = dao.GetALL();
			request.getSession().setAttribute("newsList", newList);

			// ##########商品###########
			ProductDaoImpl pdao = new ProductDaoImpl();
			List<Product> pList = pdao.GetALL();
			request.getSession().setAttribute("productList", pList);

			// ###########################
			ProductCategoryDaoImpl pcDao = new ProductCategoryDaoImpl();
			List<ProductCategory> categories = pcDao.getProductCategories(null);
			request.getSession().setAttribute("categories", categories);
			response.sendRedirect("index.jsp");
		}
	}

}
