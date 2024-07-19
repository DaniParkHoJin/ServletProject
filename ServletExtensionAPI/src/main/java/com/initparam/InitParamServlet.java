package com.initparam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(
		urlPatterns = { 
				"/initparam1", 
				"/initparam2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@servlet.com"), 
				@WebInitParam(name = "phone", value = "010-1234-5678")
		})
public class InitParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String email = getInitParameter("email");
		String phone = getInitParameter("phone");
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>email: </td><td>" + email + "</td></tr>");
		out.print("<tr><td>»ﬁ¥Î¿¸»≠: </td><td>" + phone + "</td>");
		out.print("</tr></table></body></html>");
	}

}
