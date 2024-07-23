package com.join;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.Utils;

@WebServlet("/join")
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
		List list = dao.listMember();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print(
				"<td>이름</td><td>생년월일</td><td>아이디</td><td>비밀번호</td><td>이메일</td><td>이메일동의</td><td>전화번호</td><td>핸드폰</td><td>문자수신동의</td><td>우편번호</td><td>주소</td><td>직업</td><td>가입경로</td><td>삭제</td></tr>");

		for (int i = 0; i < list.size(); i++) {
			JoinVO joinVO = (JoinVO) list.get(i);
			String name = joinVO.getName();
			String birthday = joinVO.getBirthday();
			String id = joinVO.getId();
			String password = joinVO.getPassword();
			String email = joinVO.getEmail();
			String emailAgree = joinVO.getEmailagree();
			String tel = joinVO.getTel();
			String phone = joinVO.getPhone();
			String telAgree = joinVO.getTelagree();
			String zipcode = joinVO.getZipcode();
			String address = joinVO.getAddress();
			String job = joinVO.getJob();
			String pathway = joinVO.getPathway();
			Date joinDate = joinVO.getJoinDate();
			out.print("<tr><td>" + name + "</td><td>" + birthday + "</td><td>"+ id + "</td><td>" + password + "</td><td>" + email + "</td><td>" + emailAgree + "</td><td>" + tel + "</td><td>" + phone + "</td><td>" + telAgree + "</td><td>" + zipcode + "</td><td>" + address + "</td><td>" + job + "</td><td>" + pathway + "</td><td>" + joinDate + "</td><td>"
			+ "<a href='./join?command=delMember&id=" + id + "'>삭제</a></td></tr>");
		}
		out.print("</table></body></html>");
		out.print("<a href='./join.html'>새 회원 등록하기</a");
	}

	
	
}
