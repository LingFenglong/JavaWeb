package com.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import verification.VerificationCodeBuilder;

import java.awt.image.RenderedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Servlet implementation class VerificationCodeServlet
 */
@WebServlet("/verificationcode")
public class VerificationCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerificationCodeServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		
		VerificationCodeBuilder codeBuilder = new VerificationCodeBuilder(
				VerificationCodeBuilder.DEFAULT_WIDTH,
				VerificationCodeBuilder.DEFAULT_HEIGHT
			);
		String verificationCode = codeBuilder.getRandomString();
		RenderedImage verificationCodeImage = codeBuilder.build(verificationCode);
		session.setAttribute("verificationCode", verificationCode);
		ImageIO.write((RenderedImage) verificationCodeImage, "JPEG", response.getOutputStream());
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
