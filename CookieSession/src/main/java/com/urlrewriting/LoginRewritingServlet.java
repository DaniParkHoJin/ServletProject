package com.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginrewriting")
public class LoginRewritingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginRewritingServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : " + user_id;
		data += "<br>";
		data += "비밀번호 : " + user_pw;
		data += "<br>";
		data += "주소 : " + user_address;
		data += "<br>";
		data += "email : " + user_email;
		data += "<br>";
		data += "휴대 전화 : " + user_hp;
		data += "<br>"; 
		out.print(data);
		
		// Get 방식으로 한글을 전송하기 위해 utf-8로 인코딩한다.
		user_address = URLEncoder.encode(user_address, "utf-8");
		out.print("<a href='/CookieSession/secondrewriting?user_id=" + user_id + "user_pw=" + user_pw + "&user_address=" + user_address + "'>두 번째 서블릿으로 보내기</a>");
		data = "</body></html>"; 
		out.print(data);
	
	}

}
