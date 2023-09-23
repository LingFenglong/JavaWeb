package com.lingfenglong.chatgroupjsp.servlets

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.util.HashSet

@WebServlet(name = "login", urlPatterns = ["/login"])
class LoginServlet : HttpServlet() {
    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        super.doGet(req, resp)
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val username = req?.getParameter("username")
        val password = req?.getParameter("password")

        if (username != null && username.trim() != "") {
            val servletContext = this.servletContext
            var users = servletContext.getAttribute("users") as HashSet<String>?
            if (users == null) {
                users = HashSet<String>()
                servletContext.setAttribute("users", users)
            }
            users.add(username)

            req.session?.setAttribute("username", username)
            resp?.sendRedirect("main.html")
        } else {
            req?.setAttribute("errorInfo", "请填写您的账号信息")
            req?.getRequestDispatcher("index.jsp")?.forward(req, resp)
        }
    }
}