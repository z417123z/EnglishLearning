package com.lzq.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{

	private Integer id;
	//用户名
	private String username;
	//用户姓名
	private String name;
	//密码
	private String password;
	//性别
	private String sex;
	//电话
	private String tel;
	//年级
	private String grade;
	//角色
	private Integer role;
	//签到时间
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date signInTime;
	//签到次数
	private Integer signInNumber;

	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Date getSignInTime() {
		return signInTime;
	}

	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	public Integer getSignInNumber() {
		return signInNumber;
	}

	public void setSignInNumber(Integer signInNumber) {
		this.signInNumber = signInNumber;
	}
}
