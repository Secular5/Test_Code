package com.briup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("logined".equals(cookie.getName())) {
					// 判断 value值，如果为空代表没有登陆数据，不为空就是有登陆数据
					if (cookie.getValue() != null) {
						response.setHeader("refresh", "1;url=http://39.107.92.125/");
					} else {
						response.sendRedirect(request.getContextPath() + "/login.html");
					}
				}
			}
		} else {
			response.sendRedirect(request.getContextPath() + "/login.html");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
