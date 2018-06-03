package com.dyh.dao;

import com.dyh.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {
	
	List<Product> selectRecommendProduct();                  //编辑推荐，根据点击次数
	List<Product> selectHotProduct();                       //热销图书，根据购买数量
	List<Product> selectNewProduct();                      //最新上架，根据上架时间
	List<Product> selectNewHotProduct();                  //新书热卖榜，根据销量和上架时间
	Product selectOneProductById(@Param("id") Integer id);//查一本书
	List<Product> selectAllProduct();                   //查询所有图书
	/*
	 * 分页查询 ，
	 * 级联查询，
	 * 上架时间 
	 * 
	*/
	List<Product> selectAllProductCategory(@Param("firstId") Integer firstId,   //级联查询
                                           @Param("secondId") Integer secondId,//级联查询2
                                           //  @Param("order")String order,      //排序规则
                                           @Param("start") Integer start,     //分页的开始下标
                                           @Param("end") Integer end);      //分类的结束下标
}
