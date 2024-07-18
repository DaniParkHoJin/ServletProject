package com.join;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join2")
public class JoinServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet2() {
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
		JoinDAO dao = new JoinDAO();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		if (command != null && command.equals("addMember"))
		{
			String _name;
			Date _birthday;
			String _id;
			String _password;
			String _email;
			String _emailAgree;
			String _tel;
			String _telAgree;
			String _phone;
			String _zipcode;
			String _address;
			String _job;
			String _pathway;
			
			
			
			
			_name = request.getParameter("name_name");
			String temp = request.getParameter("birthday");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			_id = request.getParameter("name_userid");
			_password = request.getParameter("name_password");
			_email = request.getParameter("name_email");
			
			if ("checked".equals(request.getParameter("emailagree"))) {
				_emailAgree = "Y";
			} else {
				_emailAgree ="N";
			}
			
			_tel = request.getParameter("name_tel1") + request.getParameter("name_tel2") + request.getParameter("name_tel3");
			_phone = request.getParameter("name_phone1") + request.getParameter("name_phone2")
					+ request.getParameter("name_phone3");
			if ("N".equals(request.getParameter("name_telagree"))) {
				_telAgree ="N";
			} else {
				_telAgree ="Y";
			}
			
			_zipcode = request.getParameter("name_zipcode");
			_address = request.getParameter("name_address1") + request.getParameter("name_address2")
					+ request.getParameter("name_address3");
			_job = request.getParameter("name_job");

			if ((_pathway = request.getParameter("pathway")).equals(null) ) {
				_pathway = "가입경로모름";
			}

		}

	}

}
