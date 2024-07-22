package com.login;

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

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// 회원 목록
	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("prepareStatemenet1 : " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");

				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);

			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 회원 등록
	public void addMember(MemberVO memberVO) {
		try {
			con = dataFactory.getConnection();

			String id; // 아이디
			String pwd; // 비밀번호
			String name; // 이름
			String email; // 이메일

			id = memberVO.getId();
			pwd = memberVO.getPwd();
			name = memberVO.getName();
			email = memberVO.getEmail();

			String query; // 회원추가 쿼리문

			query = "insert into t_member(id, pwd, name, email) values(?,?,?,?)";

			System.out.println("prepareStatement : " + query);

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeLargeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 회원 삭제
	public void delMember(String id) {

		try {
			con = dataFactory.getConnection();
			String query; // 회원 목록 쿼리
			query = "delete from t_member where id=?";
			System.out.println("prepareStatement : " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean isExisted(MemberVO memberVO) {
		
		String query;
		boolean result = false; 
		String id = memberVO.getId(); 
		String pwd = memberVO.getPwd();
		
		try {
			con = dataFactory.getConnection();
			// decode() 함수를 이용해 조회하여 ID 와 비밀번호가  테이블에 존재하면 true 를, 존재하지 않으면 false 를 조회
			
			query = "select decode(count(*),1,'true','false') as result from t_member" 
					+ " where id=? and pwd=?";
			
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			rs.next(); //커서를 첫번째 레코드로 위치시킨다.
			result = Boolean.parseBoolean(rs.getString("result")); 
			System.out.println("result=" + result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
}
