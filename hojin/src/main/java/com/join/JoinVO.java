package com.join;

import java.sql.Date;

public class JoinVO {
	private String no; // 일련번호 시퀀스
	private String name; // 이름
	private Date birthday; // 생일
	private String id; // 아이디
	private String password; // 비밀번호
	private String email; // 이메일
	private String emailagree; // 이메일 동의
	private String tel; // 집 전화번호
	private String phone; // 핸드폰 번호
	private String telagree; // 전화 수신 동의
	private String zipcode; // 우편번호
	private String address; // 주소
	private String job; // 직업
	private String pathway; // 가입 경로
	private Date joinDate;  // 가입 일자
	
	
	public JoinVO() {
		super();
	}


	public JoinVO(String no, String name, Date birthday, String id, String password, String email, String emailagree,
			String tel, String phone, String telagree, String zipcode, String address, String job, String pathway,
			Date joinDate) {
		super();
		this.no = no;
		this.name = name;
		this.birthday = birthday;
		this.id = id;
		this.password = password;
		this.email = email;
		this.emailagree = emailagree;
		this.tel = tel;
		this.phone = phone;
		this.telagree = telagree;
		this.zipcode = zipcode;
		this.address = address;
		this.job = job;
		this.pathway = pathway;
		this.joinDate = joinDate;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmailagree() {
		return emailagree;
	}


	public void setEmailagree(String emailagree) {
		this.emailagree = emailagree;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getTelagree() {
		return telagree;
	}


	public void setTelagree(String telagree) {
		this.telagree = telagree;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getPathway() {
		return pathway;
	}


	public void setPathway(String pathway) {
		this.pathway = pathway;
	}


	public Date getJoinDate() {
		return joinDate;
	}


	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}


	@Override
	public String toString() {
		return "JoinVO [no=" + no + ", name=" + name + ", birthday=" + birthday + ", id=" + id + ", password="
				+ password + ", email=" + email + ", emailagree=" + emailagree + ", tel=" + tel + ", phone=" + phone
				+ ", telagree=" + telagree + ", zipcode=" + zipcode + ", address=" + address + ", job=" + job
				+ ", pathway=" + pathway + ", joinDate=" + joinDate + "]";
	}
	
	
	
}
