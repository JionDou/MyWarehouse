package com.dyh.entity;

import java.io.Serializable;

public class OrderItem implements Serializable{
	/*Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
	编号	id	integer			TRUE	FALSE	TRUE
	订单编号	order_id	integer			FALSE	TRUE	FALSE
	商品编号	product_id	integer			FALSE	TRUE	FALSE
	商品的数量	product_num	integer			FALSE	FALSE	FALSE
	订单的小计	total	number(10,2)	10	2	FALSE	FALSE	FALSE*/
	
	private Integer id ;          //订单项id;
	private Order order;         //订单
	private Product product;    //商品
	private Integer productNum;//商品的数量
	private Double total;     //订单的小计
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", order=" + order + ", product=" + product + ", productNum=" + productNum
				+ ", total=" + total + "]";
	}
	public OrderItem(Integer id, Order order, Product product, Integer productNum, Double total) {
		super();
		this.id = id;
		this.order = order;
		this.product = product;
		this.productNum = productNum;
		this.total = total;
	}
	public OrderItem() {
		super();
		
	}
	
	
	
}
