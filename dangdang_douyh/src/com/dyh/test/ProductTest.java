package com.dyh.test;

import com.dyh.entity.Product;
import com.dyh.service.impl.ProductServiceImpl;
import org.junit.Test;

import java.util.List;

public class ProductTest {
	/*queryRecommendProduct();  //编辑推荐，根据点击次数
	List<Product> queryHotProduct();       //热销图书，根据购买数量
	List<Product> queryNewProduct();      //最新上架，根据上架时间
	List<Product> queryNewHotProduct();*/
	
	
	@Test 
	public void  queryRecommendProductTest() {
		ProductServiceImpl psi = new  ProductServiceImpl ();//创建实现类对象
		List<Product> queryRecommendProduct = psi.queryRecommendProduct();
		for (Product product : queryRecommendProduct) {
			System.out.println("jjjjjjjjjjjj"+product);
		}
	}
	@Test
	public void queryHotProductTest() {
		ProductServiceImpl psi = new  ProductServiceImpl ();//创建实现类对象
		List<Product> queryHotProduct = psi.queryHotProduct();
		for (Product product1 : queryHotProduct) {
			System.out.println("ddddddddddddddddd"+product1);
		}
	}
	
	/*@Test
	public void selectAllProductCategoryTest() {
		ProductDao productDao =(ProductDao) Util.getMapper(ProductDao.class);//获取ProductDao实现类对象
		List<Product> list = productDao.selectAllProductCategory(1,null);
		System.out.println(list.size());
		for (Product product3 : list) {
			System.out.println("我是分类测试"+product3);
		}
	}*/
	
}
