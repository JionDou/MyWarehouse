package com.dyh.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

public class Captcha extends ActionSupport{
	
	public String execute() throws Exception{
		// 获取验证码随机数
		String securityCode = SecurityCode.getSecurityCode();
		System.out.println("securityCode:"+securityCode); 
		/**
		 * 将验证码随机数存入session作用域
		 */
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setValue("#session.code", securityCode); 
		// 使用验证码随机数 创建验证码图片
		BufferedImage image = SecurityImage.createImage(securityCode); 
		// 将验证码图片 响应到客户端
		HttpServletResponse response = ServletActionContext.getResponse();
		//获取输出流
		OutputStream output = response.getOutputStream(); 
		/**
		 * 第一个参数： 验证码图片对象
		 * 第二个参数： 图片的格式
		 * 第三个参数： 输出字节流
		 */
		ImageIO.write(image, "png", output);
		
		return null;//  没有任何的跳转， 使用IO流响应内容时的处理
	}
}

