package com.member4;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet4
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet {

	public LoginServlet4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet 메서드 호출");
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost 메서드 호출");
		doHandle(request, response);

	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		System.out.println("doHandle 메서드 호출");
		
		String user_id;
		String user_pw;
		
		user_id = request.getParameter("user_id");
		user_pw = request.getParameter("user_pw");
		System.out.println("아이디 : " + user_id);
		System.out.println("비밀번호 : " + user_pw);
		
	}

}
