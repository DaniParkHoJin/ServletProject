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
	DataSource dataFactory;
	
	public JoinDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	public List listMember() {
		List list = new ArrayList();
		try {
			con = dataFactory.getConnection();
			String query = "select *from member_hojin";
			System.out.println("prepareStatment(listmember()) : " +query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				Date birthday = rs.getDate("birthday");
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
				vo.setName(name);
				vo.setBirthday(birthday);
				vo.setId(id);
				vo.setPassword(password);
				vo.setEmail(emailAgree);
				vo.setEmailagree(emailAgree);
				vo.setTel(telAgree);
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
}
