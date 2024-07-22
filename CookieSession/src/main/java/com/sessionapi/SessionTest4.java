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

		// ���� ��û �� ����
		if (session.isNew()) {
			// �α���â���� �������� ��û�ߴٸ� ID �� null �� �ƴϹǷ� ���ǿ� ID �� ���ε��Ѵ�
		if (user_id != null) {
			session.setAttribute("user_id", user_id);
			out.println("<a href='sessionlogin'>�α��� ���� Ȯ��</a>");
		} else {
			out.print("<a href='login2.html'>�ٽ� �α����ϼ���!!</a>");
			session.invalidate();
		}
		} else {
			// �� ��û�� ���ǿ��� ID �� ������ ������ �α����ߴ��� ���θ� Ȯ���Ѵ�.
			user_id = (String) session.getAttribute("user_id");
			if (user_id != null && user_id.length() != 0) { 
			out.print("�ȳ��ϼ���   " + user_id + "��!!!");
			} else {
				out.print("<a = href ='login2.html'>�ٽ� �α��� �ϼ���!!</a>");
				session.invalidate();
			}
		
		}

	}

}
