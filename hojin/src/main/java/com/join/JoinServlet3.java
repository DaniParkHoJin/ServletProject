package com.join;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.Utils;

@WebServlet("/join3")
public class JoinServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinServlet3() {
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
		if (command != null && command.equals("addMember")) {
		
			Utils.parameterCheck(request);
			
			String _name;
			String _birthday;
			String _id;
			String _password;
			String _email;
			String _emailAgree;
			String _tel;
			String _phone;
			String _telAgree;
			String _zipcode;
			String _address;
			String _job;
			String _pathway;

			_name = request.getParameter("name_name");
			_birthday = request.getParameter("birthday");
			_id = request.getParameter("name_userid");
			_password = request.getParameter("name_password");
			_email = request.getParameter("name_email");

			if ("checked".equals(request.getParameter("emailagree"))) {
				_emailAgree = "Y";
			} else {
				_emailAgree = "N";
			}
			_tel = request.getParameter("name_tel1") + request.getParameter("name_tel2")
					+ request.getParameter("name_tel3");
			_phone = request.getParameter("name_phone1") + request.getParameter("name_phone2")
					+ request.getParameter("name_phone3");
			if ("N".equals(request.getParameter("name_telagree"))) {
				_telAgree = "N";
			} else {
				_telAgree = "Y";
			}

			_zipcode = request.getParameter("name_zipcode");
			_address = request.getParameter("name_address1") + request.getParameter("name_address2")
					+ request.getParameter("name_address3");
			_job = request.getParameter("name_job");

			if ((_pathway = request.getParameter("pathway")).equals(null)) {
				_pathway = "가입경로모름";
			}

			List membersList = dao.listMember();
			request.setAttribute("membersList", membersList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("viewmembers");
			dispatcher.forward(request, response);
		
			
			JoinVO vo = new JoinVO();
			vo.setName(_name);
			vo.setBirthday(_birthday);
			vo.setId(_id);
			vo.setPassword(_password);
			vo.setEmail(_email);
			vo.setEmailagree(_emailAgree);
			vo.setTel(_tel);
			vo.setPhone(_phone);
			vo.setTelagree(_telAgree);
			vo.setZipcode(_zipcode);
			vo.setAddress(_address);
			vo.setJob(_job);
			vo.setPathway(_pathway);
			dao.addMember(vo);
			
			
		} else if (command != null && command.equals("delMember")) {
			
			Utils.parameterCheck(request);
			
			String id = request.getParameter("id");
			dao.delMember(id);
		}
		
	}

	
	
}
