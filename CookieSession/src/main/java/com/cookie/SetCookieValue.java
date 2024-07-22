package com.cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/setcookie")
public class SetCookieValue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	Date d = new Date();
	Cookie c = new Cookie("cookieTest", URLEncoder.encode("서블릿 프로그래밍.", "utf-8"));
	
	//c.setMaxAge(24*60*60);// 유효기간 설정
	c.setMaxAge(-1); // 유효 시간을 음수로 지정하여 Session 쿠키를 만든다.
	
	response.addCookie(c); // 생성된 쿠키를 브라우저로 전송
	out.println("현재시간 : " + d);
	out.println("<br> 문자열을 Cookie 에 저장한다.");	
	
	}

}
