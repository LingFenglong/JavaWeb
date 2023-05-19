package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.database.Data;
import com.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		writer.write("<html><body>");
		writer.write("<h1>登录</h1>");
		writer.write("<form action='login' method='post'>");
		writer.write("<input type='text' name='username'> <input type='submit'>");
		if (request.getAttribute("error") != null && request.getAttribute("error").equals("UserExist")) {
			writer.write("<font color='red'>该用户已存在</font>");
		}
		writer.write("</form>");
		writer.write("</body></html>");
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("username = " + username);
		User user = new User("" + username);
		if (user.isAvailable()) {
			Data.addOne(user);
			request.getSession().setAttribute("username", username);
			response.sendRedirect("chatGroup.html");
		} else {
			request.setAttribute("error", "UserExist");
			doGet(request, response);
		}
	}
}
