package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;

import com.database.Data;
import com.entity.User;

/**
 * Servlet implementation class ShowNamesServlet
 */
@WebServlet("/shownames")
public class ShowNamesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowNamesServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("refresh", "4;");
		
		String myself = (String) session.getAttribute("username");

		writer.write("<html><body>");

		Data.getAll()
			.stream().sorted(Comparator.comparing(User::getUsername)).forEach(user -> {
			if (user.getUsername().equals(myself)) {
				writer.write("<font color='blue'>" + user.getUsername() + "</font><br/>");
			} else {
				writer.write("<font>" + user .getUsername() + "</font><br/>");
			}
		});

		writer.write("</body></html>");
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
