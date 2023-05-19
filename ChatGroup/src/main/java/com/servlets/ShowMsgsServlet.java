package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.entity.Msg;

/**
 * Servlet implementation class ShowMsgsServlet
 */
@WebServlet("/showmsgs")
public class ShowMsgsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMsgsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		response.setHeader("refresh", "4;");
		
		String myself = (String) session.getAttribute("username");
		@SuppressWarnings("unchecked")
		List<Msg> msgs = (List<Msg>) getServletContext().getAttribute("msgs");

		writer.write("<html><body>");

		msgs.forEach(msg -> {
			if (msg.getUser().getUsername().equals(myself)) {
				writer.write("<font color='blue'>" + msg.getMsg() + "</font><br/>");
			} else {
				writer.write("<font>" + msg.getMsg() + "</font><br/>");
			}
		});

		writer.write("</body></html>");
		writer.flush();
		writer.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
