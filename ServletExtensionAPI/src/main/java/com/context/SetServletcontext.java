package com.context;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/setcontext")
public class SetServletcontext extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SetServletcontext() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ServletContext ��ü�� �����´�.
		ServletContext context = getServletContext();
		
		List member = new ArrayList();
		member.add("ȫ�浿");
		member.add(28);
		// ServletContext ��ü�� �����͸� ���ε� �Ѵ�.
		context.setAttribute("member", member);
		
		out.print("<html><body>");
		out.print("�̸� ȫ�浿�� ���� 28 ����");
		out.print("</body></html>");
	}

}
