package com.lingfenglong.chatgroupjsp.servlets

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.util.LinkedList

@WebServlet("/send")
class SendServlet : HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val msg = req?.getParameter("msg")
        val myself = req?.session?.getAttribute("username")

        val obj = this.servletContext.getAttribute("msgs")
        if (obj == null) {
            val msgs = LinkedList<String>()
            this.servletContext.setAttribute("msgs", msgs)
        }

        val msgs = this.servletContext.getAttribute("msgs") as LinkedList<String>
//        val msgs: LinkedList<String> = obj as LinkedList<String>
        msgs.add("${myself}: $msg")
        resp?.sendRedirect("send.jsp")
    }
}