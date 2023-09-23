<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 28080
  Date: 2023/9/21
  Time: 9:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
</head>
<body>
    <%
        Object obj = application.getAttribute("msgs");
        if (obj != null) {
            List<String> msgs = (List<String>) obj;
            for (String msg : msgs) {
                out.print(msg + "<br/>");
            }
        }
    %>
</body>
</html>
