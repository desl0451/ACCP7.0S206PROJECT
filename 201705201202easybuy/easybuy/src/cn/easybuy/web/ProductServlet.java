package cn.easybuy.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.ProductDaoImpl;
import cn.easybuy.entity.Product;

public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("id"));
		System.out.println(productId);
		ProductDaoImpl pDao = new ProductDaoImpl();
		Product product = pDao.GetById(productId);
		System.out.println(product.getName()+"==============");
		request.getSession().setAttribute("product", product);
		response.sendRedirect("product-view.jsp");
	}

}
