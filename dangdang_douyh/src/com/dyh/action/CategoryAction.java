package com.dyh.action;

import com.dyh.entity.Category;
import com.dyh.service.impl.CategoryServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class CategoryAction extends ActionSupport{
	
	//成员变量替换request作用域
	private List<Category>  allCategory;
	public List<Category> getAllCategory() {return allCategory;}
	public void setAllCategory(List<Category> allCategory) {this.allCategory = allCategory;}

	//查询所有种类
	public String findAllCategory() {
		try {
			CategoryServiceImpl csi = new CategoryServiceImpl();//创建实现类对象
			allCategory = csi.queryAllCategory();//调用实现类对象
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有的种类失败");
		}
		return "category";//跳转到category.jsp
	}
	
	
}
