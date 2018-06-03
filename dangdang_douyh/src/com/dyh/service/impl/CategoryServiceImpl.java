package com.dyh.service.impl;

import com.dyh.dao.CategoryMapper;
import com.dyh.entity.Category;
import com.dyh.service.CategoryService;
import com.dyh.util.MyBatisUtil;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

	@Override//分类查所有
	public List<Category> queryAllCategory() {
		List<Category> allCategory;
		try {
			CategoryMapper categoryMapper = MyBatisUtil.getMapper(CategoryMapper.class);//获取CategoryDao的实现类对象
			 allCategory = categoryMapper.selectAllCategory();//调用查询所有分类
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException ("分类查询所有失败");
		}
		return allCategory;
	}

	@Override//分类查部分
	public List<Category> querySomeCategory(Integer secondId) {
		List<Category> selectSomeCategory;
		try {
			CategoryMapper	 categoryMapper = MyBatisUtil.getMapper(CategoryMapper.class);//获取CategoryDao的实现类对象
			selectSomeCategory = categoryMapper.selectSomeCategory(secondId);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("分类查部分失败");
		}
		return selectSomeCategory;//返回一个查部分分类
	}


}
