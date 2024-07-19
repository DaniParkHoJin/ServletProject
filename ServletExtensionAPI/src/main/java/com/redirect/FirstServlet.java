package com.redirect;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FirstServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}


	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//response.sendRedirect("second");
		// GET 방식을 이용해 이름/값 쌍으로 데이터를 다른 서블릿으로 전달
		response.sendRedirect("second?name=hong");
		out.println("<html><boby>");
		out.println("FirstServlet 입니다.");
		out.println("</body></html>");
	}

}
