package com.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login2" )
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	response.setContentType("text/html;charset=utf-8");
	PrintWriter out = response.getWriter();
	
	String id = request.getParameter("user_id");
	String pw = request.getParameter("user_pw");
	
	String data = "<html>";
	data += "<body>";
	data += "아이디 : " + id;
	data += "<br>";
	data += "비밀번호   : " + pw;
	data += "</body>";
	data += "</html>"; 
	out.print(data);
	
	}

}
