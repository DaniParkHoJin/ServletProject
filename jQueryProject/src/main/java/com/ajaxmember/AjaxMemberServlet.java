package com.ajaxmember;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxmember")
public class AjaxMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandler(request, response);
	}

	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter writer = response.getWriter();
		
		String id = (String) request.getParameter("id"); 
		System.out.println("id = " + id);
		MemberDAO memberDAO = new MemberDAO();
		
		// ID 중복 여부를 체크한다.
		boolean overlappendID = memberDAO.overlappendID(id);
		
		if(overlappendID == true) {
			writer.print("not_usable");
		} else {
			writer.print("usable");
		}
	}

}
