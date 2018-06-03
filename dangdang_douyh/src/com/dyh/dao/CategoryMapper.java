package com.dyh.dao;

import com.dyh.entity.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper {
	List<Category> selectAllCategory();    //查所有分类
	List<Category> selectSomeCategory(@Param("secondId") Integer secondId);//通过eg:通过小说的id,来查找小说下的分类
}
