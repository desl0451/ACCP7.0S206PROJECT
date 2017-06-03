<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="cn.easybuy.dao.impl.ProductDaoImpl"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'delproduct.jsp' starting page</title>

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
       int id=Integer.parseInt(request.getParameter("id"));
       ProductDaoImpl dao=new ProductDaoImpl();
       int i=dao.delete(id);
       out.print(i);
       if(i>0){
       		out.print("<script>alert('删除成功!');location.href='product.jsp'</script>");
       }else{
       	    out.print("<script>alert('删除失败!');location.href='product.jsp'</script>");
       }
   %>
</body>
</html>
