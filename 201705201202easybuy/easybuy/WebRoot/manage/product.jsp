<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.easybuy.dao.impl.ProductDaoImpl"%>
<%@ page import="cn.easybuy.entity.Product"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理 - 易买网</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
	</head>
	<body>
		<div id="header" class="wrap">
			<div id="logo">
				<img src="images/logo.gif" />
			</div>
			<div class="help">
				<a href="HomeServlet?action=index">返回前台页面</a>
			</div>
			<div class="navbar">
				<ul class="clearfix">
					<li><a href="manage/index.jsp">首页</a></li>
					<li><a href="manage/user.jsp">用户</a></li>
					<li class="current"><a href="manage/user.jsp">商品</a></li>
					<li><a href="manage/order.jsp">订单</a></li>
					<li><a href="manage/guestbook.jsp">留言</a></li>
					<li><a href="manage/news.jsp">新闻</a></li>
				</ul>
			</div>
		</div>
		<div id="childNav">
			<div class="welcome wrap">管理员pillys您好，今天是2012-12-21，欢迎回到管理后台。</div>
		</div>
		<div id="position" class="wrap">
			您现在的位置：<a href="index.jsp">易买网</a> &gt; 管理后台
		</div>
		<div id="main" class="wrap">
			<div id="menu-mng" class="lefter">
				<div class="box">
					<dl>
						<dt>用户管理</dt>
						<dd>
							<a href="manage/user.jsp">用户管理</a>
						</dd>
						<dt>商品信息</dt>
						<dd>
							<em><a href="manage/productClass-add.jsp">新增</a></em><a
								href="manage/productClass.jsp">分类管理</a>
						</dd>
						<dd>
							<em><a href="manage/product-add.jsp">新增</a></em><a
								href="manage/productClass.jsp">分类管理</a>
						</dd>
						<dt>订单管理</dt>
						<dd>
							<a href="manage/order.jsp">订单管理</a>
						</dd>
						<dt>留言管理</dt>
						<dd>
							<a href="manage/guestbook.jsp">留言管理</a>
						</dd>
						<dt>新闻管理</dt>
						<dd>
							<em><a href="manage/news-add.jsp">新增</a></em><a href="manage/news.jsp">新闻管理</a>
						</dd>
					</dl>
				</div>
			</div>
			<div class="main">
				<h2>商品管理</h2>
				<div class="manage">
					<table class="list">
						<tr>
							<th>编号</th>
							<th>商品名称</th>
							<th>操作</th>
						</tr>
						<%
							ProductDaoImpl dao = new ProductDaoImpl();
							List<Product> list = dao.GetALL();
							for (Product p : list) {
						%>
						<tr>
							<td class="first w4 c"><%=p.getId()%></td>
							<td class="thumb"><img src="files/<%=p.getFileName()%>" width="120" height="100"/>
								<a href="../product-view.jsp" target="_self"><%=p.getName()%></a>
							</td>
							<td class="w1 c"><a href="product-modify.jsp">修改</a> <a
								class="manageDel" href="manage/delproduct.jsp?id=<%=p.getId()%>">删除</a></td>
						</tr>
						<%
							}
						%>
					</table>
				</div>
			</div>
			<div class="clear"></div>
			<div class="pager">
				<ul class="clearfix">
					<li><a>首页</a></li>
					<li>...</li>
					<li><a>4</a></li>
					<li class="current">5</li>
					<li><a>6</a></li>
					<li>...</li>
					<li><a>尾页</a></li>
				</ul>
			</div>
		</div>
		<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
			京ICP证1000001号</div>
	</body>
</html>
