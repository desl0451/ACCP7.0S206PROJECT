<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>登录</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>
<body>
			<%
				request.setCharacterEncoding("UTF-8");
				String username = request.getParameter("userId");
				String password = request.getParameter("password");
				if (username.equals("admin") && password.equals("123456")) {
					//转发										
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					//重定向
					response.sendRedirect("login.jsp");
				}
			%>
</body>
</html>
