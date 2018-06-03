package com.dyh.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable{
	/*Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
	id	id	integer			TRUE	FALSE	TRUE
	邮箱	email	VARCHAR2(100 )	100		FALSE	FALSE	FALSE
	昵称	nickname	VARCHAR2(50)	50		FALSE	FALSE	FALSE
	密码	password	VARCHAR2(32)	32		FALSE	FALSE	FALSE
	状态	status	integer			FALSE	FALSE	FALSE
	创建时间	cre_date	DATE			FALSE	FALSE	FALSE*/
	
	private Integer id;                  //用户id
	private String email;               //用户邮箱
	private String nickname;           //用户昵称
	private String password;          //用户密码
	private Integer status;          //用户状态
	private Date cre_date;//用户创建日期
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCre_date() {
		return cre_date;
	}
	public void setCre_date(Date cre_date) {
		this.cre_date = cre_date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", nickname=" + nickname + ", password=" + password + ", status="
				+ status + ", cre_date=" + cre_date + "]";
	}
	public User(Integer id, String email, String nickname, String password, Integer status, Date cre_date) {
		super();
		this.id = id;
		this.email = email;
		this.nickname = nickname;
		this.password = password;
		this.status = status;
		this.cre_date = cre_date;
	}
	public User() {
		super();
	}
	
}
