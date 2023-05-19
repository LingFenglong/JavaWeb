package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

import com.database.Data;
import com.entity.cart.Cart;
import com.entity.product.Product;

/**
 * Servlet implementation class ShopHomp
 */

@WebServlet("/shop")
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		Set<Product> products = Data.getAll();
		HttpSession session = request.getSession();
		
		if (session.getAttribute("cart") == null) {
			// 无购物车，分配一个
			session.setAttribute("cart", new Cart());
		}
		
		writer.write("<html><style>"
				+ "    tr td {"
				+ "        text-align: center;"
				+ "    }"
				+ "</style><body>");
		writer.write("<h1>欢迎，" + session.getAttribute("username") + "</h1>");
		writer.write("<table border='2px' cellpadding='15' cellspacing='0'>");
		writer.write("<tr><th>商品id</th> <th>商品名称</th> <th>商品价格</th><th>添加到购物车</th></tr>");
		products.forEach(product -> {
			writer.write("<tr>"
					+ "<td>" + product.getId() + "</td>"
					+ "<td>" + product.getName() + "</td>"
					+ "<td>" + product.getPrice() + "</td>"
					+ "<td><a href=cart?id=" + product.getId() + "><input type='button' value='+'></a></td>"
					+ "</tr>");
		});
		writer.write("</table>");
		writer.write("<a href='showcart'><input type='button' value='购物车'/></a>");
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
