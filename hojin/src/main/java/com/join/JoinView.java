package com.join;

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
public class JoinView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JoinView() {
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
		;

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		@SuppressWarnings("unchecked")
		List<JoinVO> membersList = (List<JoinVO>) request.getAttribute("membersList");
		
		membersList.forEach(member->{
			
			System.out.println("member"+member.getId());
			
		});
		
		/*
		 * out.print("<html><body>");
		 * out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		 * out.print(
		 * "<td>이름</td><td>생년월일</td><td>아이디</td><td>비밀번호</td><td>이메일</td><td>이메일동의</td><td>전화번호</td><td>핸드폰</td><td>문자수신동의</td><td>우편번호</td><td>주소</td><td>직업</td><td>가입경로</td><td>삭제</td></tr>"
		 * ); for (int i = 0; i < membersList.size(); i++) { JoinVO memberVO = (JoinVO)
		 * membersList.get(i); String name = memberVO.getName(); String birthday =
		 * memberVO.getBirthday(); String id = memberVO.getId(); String password =
		 * memberVO.getPassword(); String email = memberVO.getEmail(); String emailAgree
		 * = memberVO.getEmailagree(); String tel = memberVO.getTel(); String phone =
		 * memberVO.getPhone(); String telAgree = memberVO.getTelagree(); String zipcode
		 * = memberVO.getZipcode(); String address = memberVO.getAddress(); String job =
		 * memberVO.getJob(); String pathway = memberVO.getPathway(); Date joinDate =
		 * memberVO.getJoinDate(); out.print("<tr><td>" + name + "</td><td>" + birthday
		 * + "</td><td>" + id + "</td><td>" + password + "</td><td>" + email +
		 * "</td><td>" + emailAgree + "</td><td>" + tel + "</td><td>" + phone +
		 * "</td><td>" + telAgree + "</td><td>" + zipcode + "</td><td>" + address +
		 * "</td><td>" + job + "</td><td>" + pathway + "</td><td>" + joinDate +
		 * "</td><td>" + "<a href='./join?command=delMember&id=" + id +
		 * "'>삭제</a></td></tr>"); } out.print("</table></body></html>");
		 * out.print("<a href='./join.html'>새 회원 등록하기</a");
		 */
	}

}
