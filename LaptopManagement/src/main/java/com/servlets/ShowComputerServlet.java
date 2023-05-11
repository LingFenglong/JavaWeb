package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.database.Data;
import com.entity.Admin;

/**
 * Servlet implementation class ShowComputerServlet
 */
@WebServlet("/show")
public class ShowComputerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowComputerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin admin = new Admin((String) request.getSession().getAttribute("username"));
		PrintWriter writer = response.getWriter();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		writer.write("<html><body>");
		writer.write("<h1>" + admin.getName() + "新增的笔记本</h1>");
		writer.write("<table border='2px' cellpadding='10px' cellspacing='0px'>");
		writer.write("<tr> <th>品牌</th> <th>颜色</th> <th>价格</th> </tr>");
		Data.getAll().stream().filter(dataItem -> dataItem.getAdmin().equals(admin)).forEach(dataItem ->
		writer.write("<tr>"
				+ "<td>" + dataItem.getComputer().getBrand() + "</td>"
				+ "<td>" + dataItem.getComputer().getColor() + "</td>"
				+ "<td>" + dataItem.getComputer().getPrice() + "</td>"
				+ "</tr>"));
        writer.write("</table>");

		writer.write("<h1>所有新增的笔记本</h1>");
		writer.write("<table border='2px' cellpadding='10px' cellspacing='0px'>");
		writer.write("<tr> <th>品牌</th> <th>颜色</th> <th>价格</th> </tr>");
		Data.getAll().forEach(dataItem ->
		writer.write("<tr>"
				+ "<td>" + dataItem.getComputer().getBrand() + "</td>"
				+ "<td>" + dataItem.getComputer().getColor() + "</td>"
				+ "<td>" + dataItem.getComputer().getPrice() + "</td>"
				+ "</tr>"));   
        writer.write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
