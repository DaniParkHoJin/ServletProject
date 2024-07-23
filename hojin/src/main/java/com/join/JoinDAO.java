package com.join;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JoinDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public JoinDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	// 회원 목록
	public List<JoinVO> listMember() {
		List<JoinVO> list = new ArrayList<JoinVO>();

		try {
			con = dataFactory.getConnection();
			String query = "select * from member_hojin";

			System.out.println("prepareStatment(listmember()) : " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String birthday = rs.getString("birthday");
				String id = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String emailAgree = rs.getString("emailAgree");
				String tel = rs.getString("tel");
				String phone = rs.getString("phone");
				String telAgree = rs.getString("telAgree");
				String zipcode = rs.getString("zipcode");
				String address = rs.getString("address");
				String job = rs.getString("job");
				String pathway = rs.getString("pathway");
				Date joinDate = rs.getDate("joinDate");

				JoinVO vo = new JoinVO();
				vo.setNo(no);
				vo.setName(name);
				vo.setBirthday(birthday);
				vo.setId(id);
				vo.setPassword(password);
				vo.setEmail(email);
				vo.setEmailagree(emailAgree);
				vo.setTel(tel);
				vo.setPhone(phone);
				vo.setTelagree(telAgree);
				vo.setZipcode(zipcode);
				vo.setAddress(address);
				vo.setJob(job);
				vo.setPathway(pathway);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 회원 등록

	public void addMember(JoinVO joinVO) {

		try {
			con = dataFactory.getConnection();

			String name; // 이름
			String birthday; // 생년월일
			String id; // 아이디
			String password; // 비밀번호
			String email; // 이메일
			String emailAgree; // 이메일 수신동의여부
			String tel; // 전화번호
			String phone; // 핸드폰 번호
			String telAgree; // 문자 수신동의
			String zipcode; // 우편번호
			String address; // 주소
			String job; // 직업
			String pathway; // 가입경로

			name = joinVO.getName();
			birthday = joinVO.getBirthday();
			id = joinVO.getId();
			password = joinVO.getPassword();
			email = joinVO.getEmail();
			emailAgree = joinVO.getEmailagree();
			tel = joinVO.getTel();
			phone = joinVO.getPhone();
			telAgree = joinVO.getTelagree();
			zipcode = joinVO.getZipcode();
			address = joinVO.getAddress();
			job = joinVO.getJob();
			pathway = joinVO.getPathway();

			String query; // 회원 추가 쿼리문

			query = "insert into member_hojin (no ,name, birthday, id, password, email, emailagree, tel, phone, telagree, zipcode, address, job, pathway) values (MEMBER_HOJIN_SEQ.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			System.out.println("회원추가 쿼리문" + query);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, birthday);
			pstmt.setString(3, id);
			pstmt.setString(4, password);
			pstmt.setString(5, email);
			pstmt.setString(6, emailAgree);
			pstmt.setString(7, tel);
			pstmt.setString(8, phone);
			pstmt.setString(9, telAgree);
			pstmt.setString(10, zipcode);
			pstmt.setString(11, address);
			pstmt.setString(12, job);
			pstmt.setString(13, pathway);
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 회원 삭제
	public void delMember(String id) {
		try {
			con = dataFactory.getConnection();
			String query; // 회원 목록 쿼리
			query = "delete from member_hojin where id= ?";
			System.out.println(id);
			System.out.println("회원삭제 쿼리문:" + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ID 중복 검사
	public boolean overlappedID(String id) {
		String query;

		boolean result = false;
		try {
			con = dataFactory.getConnection();
			// decode() 함수를 이용해 ID 가 존재하면 true, 존재하지 않으면 false 를 문자열로 조회
			query = "select decode(count(*),1,'true','false') as result " + " from member_hojin where id=?";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = Boolean.parseBoolean(rs.getString("result"));
			pstmt.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
