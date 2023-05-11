package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

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
		writer.write("<h1>登陆</h1>");
		writer.write("<form action='login' method='post'>");
		writer.write("<input type='text' name='username'> <input type='submit'>");
		if (request.getAttribute("error") != null && request.getAttribute("error").equals("usernameIsNull")) {
			writer.write("<font color='red'>用户名为空</font>");
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
		String username = request.getParameter("username").trim();
		if (username.equals("")) {
			request.setAttribute("error", "usernameIsNull");
			doGet(request, response);
		} else {
			request.getSession().setAttribute("username", username);
			response.sendRedirect("computer.html");
		}
	}

}
