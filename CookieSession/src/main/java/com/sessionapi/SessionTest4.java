package com.sessionapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessionlogin")
public class SessionTest4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionTest4() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");

		// 최초 요청 시 수행
		if (session.isNew()) {
			// 로그인창에서 서블릿으로 요청했다면 ID 가 null 이 아니므로 세션에 ID 를 바인딩한다
		if (user_id != null) {
			session.setAttribute("user_id", user_id);
			out.println("<a href='sessionlogin'>로그인 상태 확인</a>");
		} else {
			out.print("<a href='login2.html'>다시 로그인하세요!!</a>");
			session.invalidate();
		}
		} else {
			// 재 요청시 세션에서 ID 를 가져와 이전에 로그인했는지 여부를 확인한다.
			user_id = (String) session.getAttribute("user_id");
			if (user_id != null && user_id.length() != 0) { 
			out.print("안녕하세요   " + user_id + "님!!!");
			} else {
				out.print("<a = href ='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		
		}

	}

}
