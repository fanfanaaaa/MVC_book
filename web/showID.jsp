<%--
  Created by IntelliJ IDEA.
  User: 94997
  Date: 2021-11-04
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我猜中文会乱码</title>
</head>
<body>
    <%
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        out.println("id:" + id + "<br>");
        out.println("password:" + pwd + "<br>");
    %>

</body>
</html>
