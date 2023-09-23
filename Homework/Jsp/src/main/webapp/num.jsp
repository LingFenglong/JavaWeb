<%@ page import="java.io.IOException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Num</title>
</head>
<body>
    <a href="index.jsp">返回</a>
    <%!
        private void printMultiplicationTable(JspWriter out , int num) throws IOException {
            out.print("<pre>");
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= i; j++) {
                    out.print(j + " * " + i + " = " + i * j + "&#9;");
                }
                out.print("<br/>");
            }
            out.print("</pre>");
        }

        private boolean validNumber(int num) {
            return num >= 1 && num <=20;
        }
    %>

    <%
        String input = request.getParameter("number");
        // 未输入
        if (input.trim().equals("")) {
            session.setAttribute("errorInfo", "NotInput");
            response.sendRedirect("index.jsp");
            return;
        }

        try {
            int num = Integer.parseInt(input);
            if (validNumber(num)) {
                printMultiplicationTable(out, num);
                session.removeAttribute("errorInfo");
                session.removeAttribute("errorInputNum");
            } else {
                session.setAttribute("errorInfo", "NumOutOfRange");
                session.setAttribute("errorInputNum", num);
                response.sendRedirect("index.jsp");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            request.setAttribute("errorInfo", "NumOutOfRange");
            response.sendRedirect("index.jsp");
        }
    %>
</body>
</html>
