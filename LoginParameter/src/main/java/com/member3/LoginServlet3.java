package com.member3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet3
 */
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	
	String user_id;
	String user_pw;
	
	user_id = request.getParameter("user_id");
	user_pw = request.getParameter("user_pw");
	System.out.println("아이디 : " + user_id);
	System.out.println("비밀번호 : " + user_pw);
	}

}
