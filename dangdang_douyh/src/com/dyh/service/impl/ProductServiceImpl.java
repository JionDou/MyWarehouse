package com.dyh.service.impl;

import com.dyh.dao.ProductMapper;
import com.dyh.entity.Product;
import com.dyh.service.ProductService;
import com.dyh.util.MyBatisUtil;
import java.util.List;


public class ProductServiceImpl implements ProductService {

	@Override//编辑推荐，根据点击次数
	public List<Product> queryRecommendProduct() {
		List<Product> selectRecommendProduct;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);//获取ProductDao的实现类对象
		    selectRecommendProduct = productMapper.selectRecommendProduct(); //调用根据点击量查询方法，实现编辑推荐功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("编辑推荐查询失败");
		}
		return  selectRecommendProduct;//返回一个selectRecommendProduct 编辑推荐集合
	}

	@Override //热销图书，根据购买数量
	public List<Product> queryHotProduct() {
		List<Product> selectHotProduct;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);//获取ProductDao实现类对象
			selectHotProduct = productMapper.selectHotProduct();//调用根据销量查询方法，实现热销功能
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("热销图书查询失败");
		}
		return  selectHotProduct;//返回一个 selectHotProduct热销图书集合
	}

	@Override//最新上架，根据上架时间
	public List<Product> queryNewProduct() {
		List<Product> selectNewProduct;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);//获取ProductDao实现类对象
		    selectNewProduct = productMapper.selectNewProduct();//调用根据图书上架时间查询方法，实现新书查询
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("新书上架图书查询失败");
		}
		return  selectNewProduct;//返回一个 selectNewProduct 新书集合
	}

	@Override//新书热卖榜，根据销量和上架时间
	public List<Product> queryNewHotProduct() {
		 List<Product> selectNewHotProduct;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);//获取ProductDao实现类对象
		    selectNewHotProduct = productMapper.selectNewHotProduct();//调用根据图书上架时间和销量查询方法，实现新书热卖的查询功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("新书热卖查询失败");
		}
		return selectNewHotProduct;//返回一个selectNewHotProduct 新书热卖的集合
	}
	
	
	@Override //所有图书展示
	public List<Product> queryAllProduct() {
		List<Product>  allProduct;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);//获取ProductDao实现类对象
		    allProduct = productMapper.selectAllProduct();          //调用查询所有方法，实现查询功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有图书失败");
		}
		   return  allProduct;
	}

	@Override//单本图书展示
	public Product queryOneProducrtById(Integer id) {
		Product product;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);//获取ProductDao实现类对象
			product = productMapper.selectOneProductById(id);//调用根据id
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("单本图书展示失败");
		}
		return product;//返回一个一本书的对象
	}

	@Override//级联查询
	public List<Product> queryAllProductCategory(Integer firstId, Integer secondId,Integer  start,Integer end) {
		List<Product> proCateList;
		try {
			ProductMapper productMapper = MyBatisUtil.getMapper(ProductMapper.class);  //获取ProductDao实现类对象
		    proCateList	= productMapper.selectAllProductCategory(firstId, secondId,start,end);//调用分级查询方法，实现分级查询功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("分页查询,级联查询展示失败");
		}
		return proCateList;//返回一个级联查询的集合
	}

}
