package com.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxtest1")
public class AjaxServletTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxServletTest1() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		// getParameter() 메서드를 이용해 ajax 로 전송된 매개변수를 가져온다.
		String param = (String) request.getParameter("param");
		System.out.println("param : " + param);
		
		PrintWriter writer = response.getWriter();
		writer.print("안녕하세요. 서버입니다.");
	}

}
