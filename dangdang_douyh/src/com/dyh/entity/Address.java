package com.dyh.entity;

import java.io.Serializable;

public class Address  implements Serializable{
	/*Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
	主键Id	id	integer			TRUE	FALSE	TRUE
	收件人	consignee	VARCHAR2(50 )	50		FALSE	FALSE	FALSE
	收货地址	address	VARCHAR2(50 )	50		FALSE	FALSE	FALSE
	邮编	zip_code	VARCHAR2(6 )	6		FALSE	FALSE	FALSE
	电话	phone	VARCHAR2(11)	11		FALSE	FALSE	FALSE
	手机	telephone	VARCHAR2(11 )	11		FALSE	FALSE	FALSE
	用户id(外键)	user_id	integer			FALSE	TRUE	FALSE*/
	
	private Integer id;			  //地址id
	private String consignee;	 //收件人
	private String address;     //收获地址
	private String zipCode;    //邮编
	private String phone;     //电话
	private String telephone;//手机
	private User user;      //用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getConsignee() {
		return consignee;
	}
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", consignee=" + consignee + ", address=" + address + ", zipCode=" + zipCode
				+ ", phone=" + phone + ", telephone=" + telephone + ", user=" + user + "]";
	}
	public Address(Integer id, String consignee, String address, String zipCode, String phone, String telephone,
			User user) {
		super();
		this.id = id;
		this.consignee = consignee;
		this.address = address;
		this.zipCode = zipCode;
		this.phone = phone;
		this.telephone = telephone;
		this.user = user;
	}
	public Address() {
		super();
	}
	
	
	
}
