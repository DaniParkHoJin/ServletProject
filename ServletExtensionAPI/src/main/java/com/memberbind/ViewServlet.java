package com.memberbind;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewmembers")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		List membersList = (List) request.getAttribute("membersList");
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td >삭제</td></tr>");

		for (int i = 0; i < membersList.size(); i++) {
			MemberVO memberVO = (MemberVO) membersList.get(i);
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>"
					+ joinDate + "</td><td>" + "<a href='#" + id + "'>삭제</a></td></tr>");
		}
		out.print("</table></body></html>");
		out.print("<a href='#'>새 회원 등록하기</a");
	}

}
