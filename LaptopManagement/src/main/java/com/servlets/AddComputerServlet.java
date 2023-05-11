package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.database.Data;
import com.entity.Admin;
import com.entity.Computer;
import com.entity.DataItem;

/**
 * Servlet implementation class AddComputerServlet
 */
@WebServlet("/add")
public class AddComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddComputerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String brand = request.getParameter("brand");
		String color = request.getParameter("color");	// default = red
		String price = request.getParameter("price");
		
		if (brand.equals("") || color == null || price.equals("")) {
			request.setAttribute("state", "请填写必要的信息！");
			request.getRequestDispatcher("status").forward(request, response);
			return;
		}
		
		try {
			if (!Data.addOne(new DataItem(
					new Computer(brand, color, Double.parseDouble(price)),
					new Admin((String) session.getAttribute("username"))))) {
				// 已存在这台笔记本
				request.setAttribute("state", "已存在该笔记本！");
			} else {
				request.setAttribute("state", "添加成功！");
			}
		} catch (NumberFormatException e) {
			request.setAttribute("state", "价格格式错误！");
		}
		
		
		request.getRequestDispatcher("status").forward(request, response);
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
