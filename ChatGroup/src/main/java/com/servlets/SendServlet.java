package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Msg;
import com.entity.User;

/**
 * Servlet implementation class SendServlet
 */
@WebServlet("/send")
public class SendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String msg = request.getParameter("msg");
		
		Object obj = getServletContext().getAttribute("msgs");
		if (obj == null) {
			List<Msg> list = new ArrayList<>();
			getServletContext().setAttribute("msgs", list);
			obj = list;
		}
		@SuppressWarnings("unchecked")
		List<Msg> msgs = (List<Msg>) obj;
		msgs.add(new Msg(msg, new User(username)));
		response.sendRedirect("send.html");
	}

}
