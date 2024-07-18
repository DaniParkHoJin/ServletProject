package com.join;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String name;
		String birthday;
		String id;
		String password;
		String email;
		String emailagree;
		String tel;
		String phone;
		String zipcode;
		String address;
		String job;
		String pathway;

		name = request.getParameter("name_name");
		birthday = request.getParameter("birthday");
		id = request.getParameter("name_userid");
		password = request.getParameter("name_password");
		email = request.getParameter("name_email");
		
		if ("checked".equals(request.getParameter("emailagree"))) {
			emailagree = "emailOk";
		} else {
			emailagree ="emailNo";
		}
		
		tel = request.getParameter("name_tel1") + request.getParameter("name_tel2") + request.getParameter("name_tel3");
		phone = request.getParameter("name_phone1") + request.getParameter("name_phone2")
				+ request.getParameter("name_phone3");
		zipcode = request.getParameter("name_zipcode");
		address = request.getParameter("name_address1") + request.getParameter("name_address2")
				+ request.getParameter("name_address3");
		job = request.getParameter("name_job");
		pathway = request.getParameter("pathway");

		System.out.println("name = " + name);
		System.out.println("birthday = " + birthday);
		System.out.println("id = " + id);
		System.out.println("password = " + password);
		System.out.println("email = " + tel);
		System.out.println("emailagree = " + emailagree);
		System.out.println("tel = " + tel);
		System.out.println("phone = " + phone);
		System.out.println("zipcode = " + zipcode);
		System.out.println("address = " + address);
		System.out.println("job = " + job);
		System.out.println("pathway = " + pathway);

	}

}
