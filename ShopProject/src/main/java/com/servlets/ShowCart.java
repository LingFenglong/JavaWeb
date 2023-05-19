package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import com.entity.cart.Cart;
import com.entity.cart.CartItem;

/**
 * Servlet implementation class ShowCart
 */
@WebServlet("/showcart")
public class ShowCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();
		if (session.getAttribute("cart") == null) {
			return;
		}
		Cart cart = (Cart) session.getAttribute("cart");
		Map<Long, CartItem> cartItems = cart.getAll(); 

		writer.write("<html><style>"
				+ "    tr td {"
				+ "        text-align: center;"
				+ "    }"
				+ "</style><body>");
		writer.write("<h1>" + session.getAttribute("username") + "的购物车</h1>");
		if (cartItems.isEmpty()) {
			writer.write("<h2>购物车还是空的哦，去<a href='shop'>逛一逛吧！</a></h2>");
		} else {
			writer.write("<table border='2px' cellpadding='15' cellspacing='0'>");
			writer.write("<tr><th>商品id</th> <th>商品名称</th> <th>商品价格</th><th>购买数量</th></tr>");
			cartItems.forEach((id, cartItem) -> {
				writer.write("<tr>"
						+ "<td>" + cartItem.getProduct().getId() + "</td>"
						+ "<td>" + cartItem.getProduct().getName() + "</td>"
						+ "<td>" + cartItem.getProduct().getPrice() + "</td>"
						+ "<td>" + cartItem.getCount() + "</td>"
						+ "</tr>");
			});
			writer.write("</table>");
			writer.write("总计：" + String.format("%.2f", cart.getTotalPrice()) + "<br/>");
			writer.write("<a href='shop'><input type='button' value='继续购物'/></a>");
			writer.write("<a href='thanks'><input type='button' value='立即清单'/></a>");
		}
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
