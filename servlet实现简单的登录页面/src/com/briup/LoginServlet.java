package com.briup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String remenber = request.getParameter("isR");
		if ("lisi".equals(username) && "lisi".equals(password)) {
			// 如果相等就意味着 勾选了记住我
			if ("Y".equals(remenber)) {
				// 创建cookie
				Cookie cookie = new Cookie("logined", "success");

				// 设置cookie过期时间
				cookie.setMaxAge(60 * 60 * 24 * 1);
				// 将cookie由response返回
				response.addCookie(cookie);
			}
			response.sendRedirect(request.getContextPath() + "/FlashServlet");
		} else {
			response.sendRedirect(request.getContextPath() + "/login.html");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
