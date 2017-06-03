<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>易买网 - 首页</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="scripts/function.js"></script>
</head>
<body>
<div id="header" class="wrap">
	<div id="logo"><img src="images/logo.gif" /></div>
	<div class="help">
	<a href="Cart" class="shopping" id="shoppingBag" data="cart">购物车<c:out value="${sessionScope.cart.items.size()}" default="0"/>件
	</a>
	<c:if test="${sessionScope.loginUser!=null && sessionScope.cart.items.size()>0}">	     
		 <a class="button" id="logout" href="javascript:void(0);">注销</a>
	</c:if>
	
	<c:if test="${sessionScope.loginUser!=null && sessionScope.cart==null || sessionScope.loginUser!=null&&sessionScope.cart.items.size()==0}">
    	<a class="button" href="Login?action=logout">注销</a>
	</c:if>
	<c:if  test="${sessionScope.loginUser==null}" >
		<a href="login.jsp">登录</a>
	</c:if>
	<a href="register.jsp">注册</a>
	<!-- && sessionScope.loginUser.administrator -->
	<c:if test="${sessionScope.loginUser!=null }">
		<a href="GuestBook">留言</a>
    	<a href="manage/index.jsp">后台管理</a>
	</c:if>
	</div>
	<div class="navbar">
		<ul class="clearfix">
			<li class="current"><a href="Home">首页</a></li>
			<li><a href="#">图书</a></li>
			<li><a href="#">百货</a></li>
			<li><a href="#">品牌</a></li>
			<li><a href="#">促销</a></li>
		</ul>
	</div>
</div>
<div id="childNav">
	<div class="wrap">
		<ul class="clearfix">
			<li class="first"><a href="#">音乐</a></li>
			<li><a href="#">影视</a></li>
			<li><a href="#">少儿</a></li>
			<li><a href="#">动漫</a></li>
			<li><a href="#">小说</a></li>
			<li><a href="#">外语</a></li>
			<li><a href="#">数码相机</a></li>
			<li><a href="#">笔记本</a></li>
			<li class="last"><a href="#">Investor Relations</a></li>
		</ul>
	</div>
</div>
	<div id="register" class="wrap">
		<div class="shadow">
			<em class="corner lb"></em> <em class="corner rt"></em>
			<div class="box">
				<h1>欢迎回到易买网</h1>
				<c:out value="${entityId}"></c:out>
				<form id="loginForm" method="post" action="Login"
					onsubmit="return checkForm(this)">
					<input type="hidden" name="action2" value="${action}" /> <input
						type="hidden" name="entityId" value="${entityId}" />
					<table>
						<tr>
							<td class="field">用户名：</td>
							<td><input class="text" type="text" id="userId"
								name="userId" value="${userId}" /> <c:if
									test="${not empty errors && not empty errors['userId']}">
									<span class="error">${errors['userId']}</span>
								</c:if> <c:if test="${empty errors || empty errors['userId']}">
									<span></span>
								</c:if></td>
						</tr>
						<tr>
							<td class="field">登录密码：</td>
							<td><input class="text" type="password" id="password"
								name="password" value="${password}" /> <c:if
									test="${not empty errors && not empty errors['password']}">
									<span class="error">${errors['password']}</span>
								</c:if> <c:if test="${empty errors || empty errors['password']}">
									<span></span>
								</c:if></td>
						</tr>
						<tr>
							<td class="field">验证码：</td>
							<td>
								<img src="Number.jsp" id="safeCode" />
								<a id="changeCode">看不清，换一张</a><br> 
								<input type="text" name="code">
							<div class="mess">
									<c:if test="${not empty errors && not empty errors['mess']}">
										<span class="error">${errors['mess']}</span>
									</c:if>
									<c:if test="${empty errors || empty errors['mess']}">
										<span></span>
									</c:if></td>
						</tr>
						<tr>
							<td></td>
							<td><label class="ui-green"><input type="submit"
									name="submit" value="立即登录" /></label></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div id="footer">Copyright &copy; 2013 北大青鸟 All Rights Reserved.
		京ICP证1000001号</div>
</body>
</html>

