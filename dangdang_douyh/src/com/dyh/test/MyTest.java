package com.dyh.test;

import com.opensymphony.xwork2.ActionSupport;

public class MyTest extends ActionSupport {
	
	public String execute() {
		System.out.println("���ǲ���");
		return "index";
	}
}
