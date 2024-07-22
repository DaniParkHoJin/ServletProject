package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/showmember")
public class ShowMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowMember() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String id = "", pwd = "";
		Boolean isLogon = false;
		// 이미 세션이 존재하면 세션을 반환하고, 없으면 null 을 반환한다.
		HttpSession session = request.getSession(false);
		// 세션이 생성되어 있는지 확인
		if (session != null) {
			// isLogOn 속성을 가져와 로그 상태 확인
			isLogon = (Boolean) session.getAttribute("isLogon");
			// isLogOn 이 true 면 로그인 상태이므로 회원 정보를 브라우저에 표시
			if (isLogon == true) {
				id = (String) session.getAttribute("login.id");
				pwd = (String) session.getAttribute("login.pwd");
				out.print("<html><body>");
				out.print("아이디: " + id + "<br>");
				out.print("비밀번호: " + pwd + "<br>");
				out.print("</body></html>");
			} else {
				// 로그인 상태가 아니면 로그인창으로 이동
				response.sendRedirect("login3.html");
			}
		} else {
			// 세션이 생성되지 않았으면 로그인 창으로 이동
			response.sendRedirect("login3.html");
		}
	}

}
