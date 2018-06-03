package com.dyh.action;

import com.dyh.entity.OrderItem;
import com.dyh.entity.Product;
import com.dyh.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CarAction extends ActionSupport{
	ValueStack vs = ActionContext.getContext().getValueStack();//获取值栈对象
	
	//获取商品id
	private Integer id ;
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}

	//1增加订单项
	public String addOrderItem() throws IOException, InterruptedException {
		Thread.sleep(2000);
		System.out.println(id);
		
		//1获取用户购物车
		Map<Integer ,OrderItem> order =(Map<Integer,OrderItem>) vs.findValue("#session.orderItem");
		//购物车不存在
		if(order == null) {
			order = new HashMap<Integer,OrderItem>();
			vs.setValue("#session.orderItem", order);//将创建的购物车存到session中
		}
		//2添加购物项
		OrderItem orderItem = order.get(id);//通过商品id获取到一个OrderItem对象
		//新的购物项
		//根据商品id获取商品的详细信息
		ProductServiceImpl psi = new ProductServiceImpl();//获取ProductServiceImpl对象
		Product oneProducrtById = psi.queryOneProducrtById(id);//调用方法，实现商品查详情功能
		if(orderItem == null) {//如果购物项为空，就创建购物项，并将信息加入到map中
			//商品信息 和商品的数量
			orderItem = new OrderItem();
			orderItem.setProduct(oneProducrtById);//商品信息
			orderItem.setProductNum(1);          //商品数量
			order.put(id, orderItem);//将新的购物项放在map中
		}else {
			//已存在的购物项
			orderItem.setProductNum(orderItem.getProductNum()+1);//获取到原有的购物项
		}
		// 获取输出流响应结果
		HttpServletResponse response = ServletActionContext.getResponse();
		PrintWriter out = response.getWriter();
		out.println("/car/right.gif");
		return  null;
	}
	
	//成员变量收参
	private Integer productNum;

	private Collection<OrderItem> values;
	public Integer getProductNum() {return productNum;}
	public void setProductNum(Integer productNum) {this.productNum = productNum;}
	
	//2修改订单
	public String modifyCar() {
		System.out.println(id+"\t"+productNum);
		//1获取值栈中的购物车对象
		Map<Integer ,OrderItem> order = (Map<Integer ,OrderItem>)vs.findValue("#session.orderItem");
	   //2根据商品的id获取指定的购物项
		OrderItem orderItem = order.get(id);
	  //3修改购物项的数量为指定数量
		orderItem.setProductNum(productNum);
	 //4跳转视图,重定向到小计的action
		return "totalMoney";//跳转到cart_list.jsp
	}
	//list成员变量替换request作用域
	private List<Double> list;
	public List<Double> getList() {return list;}
	public void setList(List<Double> list) {this.list = list;}
	
	//3计算小计
	public String totalMoney() {
		//1获取值栈中的购物车对象
		Map<Integer ,OrderItem> order = (Map<Integer,OrderItem>)vs.findValue("#session.orderItem");
		//2计算节省的金额，以及总额
		//购物项总额 = 当当价* 数量；节省总额 = （定价-当当价）*数量
		Double count = 0.0;
		Double saveMoney = 0.0;
		for(OrderItem oi: order.values()) {
			
			count += (oi.getProduct().getDdPrice())*(oi.getProductNum());
			saveMoney += (oi.getProduct().getUsedPrice()-oi.getProduct().getDdPrice())*(oi.getProductNum());
		}
		//将计算的两个额度，存放在session中
		list = new ArrayList<Double>();
		list.add(count);
		list.add(saveMoney);
		return "cart_list";	
	}
	
	//4删除购物项
	public String deleteOrderItem() {
		//获取值栈中的购物车对象
		Map<Integer ,OrderItem> order = (Map<Integer ,OrderItem>)vs.findValue("#session.orderItem");
		//创建一个map盛放被删除的OrderItem订单项对象
		Map<Integer ,OrderItem> orderSecond = new HashMap<Integer ,OrderItem>();
		for(Integer ids:order.keySet()) {       //通过遍历order集合的键
			if(ids == id) {			           //如果当前遍历的id和页面传过来的集合一致
			orderSecond.put(id,order.get(id));//将当前的key,value,存放到新的map中	
			}
		}
		order.remove(id);//将被选中的OrderItem对象
		//将被删除的订单项的map存入session中
		vs.setValue("#session.orderSecond", orderSecond);
		
		return "cart_list";//跳转到购物车的cart_list.jsp
	}
	
	//5恢复订单项
	public String modifyOrderItem() {
		
		//1获取session中的两个购物车
		Map<Integer ,OrderItem> order = (Map<Integer,OrderItem>)vs.findValue("#session.orderItem");
		Map<Integer ,OrderItem> orderItem = (Map<Integer,OrderItem>)vs.findValue("#session.orderSecond");
		
		//遍历删除的map
		for(Integer ids :orderItem.keySet()) {
			if(ids == id) {						  //如果当前遍历的id等于页面传过来的id
				order.put(id, orderItem.get(id));//将当前id所在的键值对存入到购物项集合中
			}	
		}
		
		//将被选中的键值对从收集删除的map中移除
		orderItem.remove(id);
		return "cart_list";//跳转到cart_list.jsp
		
	}
}
