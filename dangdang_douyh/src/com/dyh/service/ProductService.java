package com.dyh.service;

import com.dyh.entity.Product;

import java.util.List;

public interface ProductService {
	List<Product> queryRecommendProduct();       //编辑推荐，根据点击次数
	List<Product> queryHotProduct();            //热销图书，根据购买数量
	List<Product> queryNewProduct();           //最新上架，根据上架时间
	List<Product> queryNewHotProduct();       //新书热卖榜，根据销量和上架时间
	Product queryOneProducrtById(Integer id);//通过id展示单本图书
	List<Product> queryAllProduct();        //所有图书展示
	List<Product> queryAllProductCategory(Integer firstId, Integer secondId,
                                          //String order,
                                          Integer start, Integer end);//级联查询,分页
}
