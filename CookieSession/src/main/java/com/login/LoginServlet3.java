package com.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginexam")
public class LoginServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet3() {
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
		
		// 로그인창에서 전송된 ID 와 비밀번호
		String user_id = request.getParameter("user_id"); 
		String user_pwd = request.getParameter("user_pwd");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		
		MemberDAO dao = new MemberDAO();
		// MemberDAO 의 isExisted() 메서드를 호출하면서 memberVO 를 전달
		boolean result = dao.isExisted(memberVO);
		
		if (result) {
			HttpSession session = request.getSession();
			// 조회한 결과가 true 이면  isLogOn 속성을 true 로 세션에 저장
			session.setAttribute("isLogon", true);
			// 조회한 결과가 true 이면  ID 와 비밀번호를 세션에 저장 
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("안녕하세요   " + user_id + "님!!!<br>");
			out.print("<a href='showmember'>회원정보보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>회원 아이디가 틀립니다.");
			out.print("<a href='login3.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
	}

}
