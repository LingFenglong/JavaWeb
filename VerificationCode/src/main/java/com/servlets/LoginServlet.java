package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

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
		writer.write("");
		writer.write("");
		writer.write("<a href='verificationcode'>换一张</a>");
		writer.write("<br/>");
		writer.write("<input type='submit' name='登录'/>");
		writer.write("</form>");
		writer.write("</body></html>");
		
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String code = request.getParameter("verification_code");
		String verificationCode = (String) session.getAttribute("verificationCode");
		System.out.println("code = " + code + "\r\n"
				+ "verificationCode = " + verificationCode);
		
		if (code.equalsIgnoreCase(verificationCode)) {
			session.setAttribute("state", "验证成功");
		} else {
			session.setAttribute("state", "验证失败");
		}
		response.sendRedirect("showstatus");
	}

}
