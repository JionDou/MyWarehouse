package com.dyh.service;

import com.dyh.entity.Category;

import java.util.List;

/**
 * 
 * @author  FuNian
 *
 * @description 分类的业务接口
 *
 * @2018年5月25日 下午8:18:35
 */
public interface CategoryService {
	
	
	List<Category> queryAllCategory();                           //分类查所有
	List<Category> querySomeCategory(Integer firstId);          //分类查部分
	
}
