package com.httpservletrequest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/secondhttpservlet")
public class SecondHttpServletRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondHttpServletRequestServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	String address = (String) request.getAttribute("address");
	out.println("<html><body>");
	out.println("주소 : " + address);
	out.println("<br>");
	out.println("redirect 를 이용한 바인딩 실습입니다.");
	out.println("</body></html>");
	
	}

}
