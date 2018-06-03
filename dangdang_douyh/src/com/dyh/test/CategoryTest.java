package com.dyh.test;

import com.dyh.entity.Category;
import com.dyh.service.impl.CategoryServiceImpl;
import org.junit.Test;

import java.util.List;

public class CategoryTest {
	@Test
	public void queryAllCategoryTest() {
		CategoryServiceImpl csi = new CategoryServiceImpl();//创建实现类对象
		List<Category> allCategory = csi.queryAllCategory();
		for (Category category : allCategory) {
			System.out.println(category.getCategoryName());
			for (Category  category2: category.getCategory()) {
				System.out.println("\t"+category2.getCategoryName());
			}
		}
	}
	
	@Test
	public void test2() {
		CategoryServiceImpl csi = new CategoryServiceImpl();//创建实现类对象
		List<Category> list = csi.querySomeCategory(1);
		for (Category category : list) {
			System.out.println(category);
		}
	}
}
