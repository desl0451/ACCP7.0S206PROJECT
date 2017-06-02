<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.easybuy.dao.impl.NewsDaoImpl"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'del.jsp' starting page</title>

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
		int id = Integer.parseInt(request.getParameter("id"));
		NewsDaoImpl dao = new NewsDaoImpl();
		int i = dao.delete(id);
		if(i>0){
			out.print("<script>alert('删除成功!');location.href='manage/news.jsp';</script>");
		}else{
			out.print("<script>alert('删除失败!');location.href='manage/news.jsp';</script>");
		}
	%>

</body>
</html>
