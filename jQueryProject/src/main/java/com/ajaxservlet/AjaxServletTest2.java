package com.ajaxservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxtest2")
public class AjaxServletTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AjaxServletTest2() {
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
		String result = "";
		PrintWriter writer = response.getWriter();
		result = "<main><book>" + "<title><![CDATA[Power JAVA]]></title>"
				+ "<writer><![CDATA[인피니티북스 저 | 천인국]]></writer>"
				+ "<image><![CDATA[http://localhost:8080/jQueryProject/image/image1.png]]></image>" + "</book>"
				+ "<book>" + "<title><![CDATA[스프링 인 액션]]></title>" + "<writer><![CDATA[제이펍 저 | 크레이그 월즈]]></writer>"
				+ "<image><![CDATA[http://localhost:8080/jQueryProject/image/image2.png]]></image>" + "</book></main>";
		System.out.println(result);
		writer.print(result);
	}

}
