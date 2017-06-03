package cn.easybuy.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.easybuy.dao.impl.ProductDaoImpl;
import cn.easybuy.entity.Cart;
import cn.easybuy.entity.Product;

public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ProductDaoImpl dao = new ProductDaoImpl();
		String action = request.getParameter("action");
		int id = Integer.parseInt(request.getParameter("id"));
		Cart cart = (Cart) request.getSession().getAttribute("cart");
		if (action.equals("add")) {// 够物车添加
			Product product = dao.GetById(id);
			if (cart == null) {
				cart = new Cart();
				request.getSession().setAttribute("cart", cart);
			}
			cart.addGoodsInCart(product, 1);
			Set<Product> items = cart.getGoods().keySet();
			Iterator<Product> it = items.iterator();
			List<Product> list = new ArrayList<Product>();
			while (it.hasNext()) {
				Product p = (Product) it.next();
				list.add(p);
			}
			request.getSession().setAttribute("list", list);
			System.out.println("购物车的总金额：" + cart.getTotalPrice());
		} else if (action.equals("del")) {
			Product product = dao.GetById(id);
			cart.removeGoodsFromCart(product);
			Set<Product> items = cart.getGoods().keySet();
			Iterator<Product> it = items.iterator();
			List<Product> list = new ArrayList<Product>();
			while (it.hasNext()) {
				Product p = (Product) it.next();
				list.add(p);
			}
			request.getSession().setAttribute("list", list);
			System.out.println("购物车的总金额：" + cart.getTotalPrice());
		}
		response.sendRedirect("shopping.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
