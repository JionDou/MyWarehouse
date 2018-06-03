package com.dyh.action;

import com.dyh.entity.User;
import com.dyh.service.impl.UserServiceImpl;
import com.dyh.util.RandomSaltUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction extends ActionSupport {
	//成员变量收参email,password;
	private String email;    //用户邮箱
	private String password;//用户密码
	private String code;   //用户验证码
	public String getCode() {return code;}
	public void setCode(String code) {this.code = code;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}

	
	ValueStack vs = ActionContext.getContext().getValueStack();   //获取值栈对象
	 //通过用户邮箱和密码查询用户登录
	public String findOneUserByEmailAndPassword() {
		UserServiceImpl usi = new UserServiceImpl();  //获取userService实现类对象
		String code1 = vs.findString("#session.code");//获取生成的验证码
		if(code1.equalsIgnoreCase(code)) {           //随机生成的验证码和输入的验证码的比对
			User user = usi.queryUserByEmailAndPassword(email, password);//调方法用登录查询的
			vs.setValue("#session.user", user);//将用户信息存在session中作为是否登录判断的依据
		}
		return "loginOk";//main1.jsp
	}
	
	//用户的登出
	public String exit() {
		ActionContext.getContext().getSession().clear();//清空session
		return "main";//返回到主页页面
	}
	
	
	//用户注册第一步的成员变量收参user
	private User user;
	public User getUser() {return user;}
	public void setUser(User user) {this.user = user;}
	
	//用户的注册第一步
	public String registUserFirst() {
		UserServiceImpl usi = new UserServiceImpl();//获取userService实现类对象
//		System.out.println("666  "+user);
		usi.addUserFirst(user);
		vs.setValue("#session.user",user);
		return "gotRandom";//注册成功后 ，跳转到获取邮箱的验证码的action中
	
	}
	//邮箱验证码的生成
	public String gotRandom() {
		//获取邮箱随机数
		String randomCode = RandomSaltUtil.generetRandomSaltCode();
		System.out.println("randomCode:"+randomCode);
		/**
		 * 将随机数存入session作用域中
		 */
		vs.setValue("#session.randomCode",randomCode);//将随机数存入session中
		return "compareRandom";//跳转到verify_form.jsp，然后verify_form.jsp跳转到邮箱验证码的比对的action中
	}
	
	//邮箱验证码的匹配
	public String compareRandom() {
		//在session中获取驻存的随机数
		String randomCode = vs.findString("#session.randomCode");
		if(randomCode.equalsIgnoreCase(code)) {
			return "verifyUser";//跳转到用户状态的修改
		}else {
			return "gotRandom";//获取随机数的action 中
		}
		
	}
	
	//用户状态的修改
	public String modifyUserStatus() {
		UserServiceImpl  usi = new UserServiceImpl();  //获取userService实现类对象
		String emailUser = vs.findString("#session.user.email");//获取来注册信息中的邮箱信息
		usi.ModifyUser(emailUser);//调用修改方法，实现状态的修改
		return "registerOk";     //跳转到用户注册成功页面
	}
}