package cn.easybuy.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;//购物车类

public class Cart {
	// 购买商品的集合
	private Map<Product, Integer> goods;

	// 购物车的总金额
	private double totalPrice;

	public Map<Product, Integer> getGoods() {
		return goods;
	}

	public void setGoods(Map<Product, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Cart() {
		goods = new HashMap<Product, Integer>();
		totalPrice = 0.0;
	}

	/**
	 * 添加商品进购物车的方法
	 * 
	 * @param product
	 *            产品名称
	 * @param number
	 *            产品数量
	 * @return
	 */
	public boolean addGoodsInCart(Product product, int number) {
		if (goods.containsKey(product)) {
			goods.put(product, goods.get(product) + number);
		} else {
			goods.put(product, number);
		}
		calTotalPrice();
		return true;
	}

	/**
	 * 删除商品的方法
	 * 
	 * @param product
	 * @return
	 */
	public boolean removeGoodsFromCart(Product product) {
		goods.remove(product);
		calTotalPrice();
		return true;
	}

	/**
	 * 统计购物车的总金额
	 * 
	 * @return
	 */
	public double calTotalPrice() {
		double sum = 0.0;
		Set<Product> keys = goods.keySet(); // 获得键的集合
		Iterator<Product> it = keys.iterator();// 获得迭代器对象
		while (it.hasNext()) {
			Product p = it.next();
			sum += p.getPrice() * goods.get(p);
		}
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}

	// public List<Product> showCart(Cart cart) {
	// Set<Map.Entry<Product, Integer>> items = cart.getGoods().entrySet();
	// List<Product> pList = new ArrayList<Product>();
	// for (Map.Entry<Product, Integer> obj : items) {
	// pList.add(obj);
	// }
	// }

	// this.id = id;
	// this.name = name;
	// this.description = description;
	// this.price = price;
	// this.stock = stock;
	// this.cid = cid;
	// this.fileName = fileName;
	public static void main(String[] args) {
		Product p1 = new Product(593, "扩肤王", "女士专用", 300f, 29984, 545, "596.jpg");
		Product p2 = new Product(601, "奶粉", "三元", 98f, 189, 626, "601.jpg");
		// 创建购物车
		Cart cart = new Cart();
		cart.addGoodsInCart(p1, 1);
		cart.addGoodsInCart(p2, 2);
		cart.addGoodsInCart(p1, 2);
		// 循环遍历购物商品的集合

		Set<Product> items = cart.getGoods().keySet();
		Iterator<Product> it = items.iterator();
		while (it.hasNext()) {
			Product product = (Product) it.next();
			System.out.println(product.getName());
			System.out.println(product.getPrice());
		}
		System.out.println("购物车的总金额：" + cart.getTotalPrice());
	}
}
