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
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		
		writer.write("<html><body>");
		writer.write("<form action='login' method='post'>");
		writer.write("用户名：<input type='text' name='username'/>");
		writer.write("<br/>");
		writer.write("密码：<input type='password' name='password'/>");
		writer.write("<br/>");
		writer.write("验证码：<input type='text' name='verification_code'/>");
		writer.write("<img id='verificationCodeImg' src='verificationcode' />");
		writer.write("<a href='verificationcode' target='_blank'>换一张</a>");		
		writer.write("<br/>");
		writer.write("<input type='submit' name='登录'/>");
		writer.write("</form>");
		writer.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verificationCode = request.getParameter("verification_code");
		
		System.out.println(username + "\t" + password + "\t" + verificationCode);
	}

}
