<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.lingfenglong.newshomework.entity.News" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>

<body>
    <%
        ArrayList<News> list = new ArrayList();
        News news1 = new News();
        news1.setId(1);
        news1.setTitle("2022年9月19日河北省新型冠状病毒肺炎疫情情况");
        news1.setPublishTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        News news2 = new News();
        news2.setId(2);
        news2.setTitle("国庆假期火车票今日起正式开售");
        news2.setPublishTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        News news3 = new News();
        news3.setId(3);
        news3.setTitle("C++ 学习 ---STL 中 nullptr_t 的实现原理");
        news3.setPublishTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        News news4 = new News();
        news4.setId(4);
        news4.setTitle("JDK 19 最新动态和 JDK 20 新特性预测");
        news4.setPublishTime("2023-5-1");
        News news5 = new News();
        news5.setId(5);
        news5.setTitle("Linux 内核写锁实现原理与源码解析");
        news5.setPublishTime("2023-5-1");
        list.add(news1);
        list.add(news2);
        list.add(news3);
        list.add(news4);
        list.add(news5);
        request.setAttribute("newslist", list);
    %>

    <a href="list.jsp">list.jsp</a><br>
    <a href="list_color.jsp">list_color.jsp</a><br>
    <a href="list_part.jsp">list_part.jsp</a><br>
    <a href="list_title.jsp">list_title.jsp</a><br>

</body>

</html>