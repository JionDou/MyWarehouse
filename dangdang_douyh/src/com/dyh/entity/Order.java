package com.dyh.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	/*Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
	订单id	id	integer			TRUE	FALSE	TRUE
	总额	total_money	NUMBER(10,2)	10	2	FALSE	FALSE	FALSE
	创建日期	cre_date	date			FALSE	FALSE	FALSE
	订单状态	order_status	INTEGER			FALSE	FALSE	FALSE
	收货地址收货地址id(外键)	address_id	integer			FALSE	TRUE	FALSE
	用户id(外键)	user_id	integer			FALSE	TRUE	FALSE*/
	
	private Integer id;              //订单id
	private Double totalMoney;      //总额
	private Date creDate;//创建日期
	private Integer orderStatus;  //订单状态
	private Address address;     //收货地址
	private User user;          //用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getTotalMoney() {
		return totalMoney;
	}
	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	public Date getCreDate() {
		return creDate;
	}
	public void setCreDate(Date creDate) {
		this.creDate = creDate;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", totalMoney=" + totalMoney + ", creDate=" + creDate + ", orderStatus="
				+ orderStatus + ", address=" + address + ", user=" + user + "]";
	}
	public Order(Integer id, Double totalMoney, Date creDate, Integer orderStatus, Address address, User user) {
		super();
		this.id = id;
		this.totalMoney = totalMoney;
		this.creDate = creDate;
		this.orderStatus = orderStatus;
		this.address = address;
		this.user = user;
	}
	public Order() {
		super();
	}
	
	
}
