<%@ page import="java.util.Set" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Names</title>
</head>
<body>
  <%
    Object obj = application.getAttribute("users");
    String myself = session.getAttribute("username").toString();
    if (obj != null) {
      Set<String> users = (Set<String>) obj;

      for (String user : users) {
        if (myself.equals(user)) {
          out.print("<font color='red'>" + myself + "</font>");
        } else {
          out.print("<font color='blue'>" + myself + "</font>");
        }
        out.print("<br/>");
      }
    }

  %>
</body>
</html>
