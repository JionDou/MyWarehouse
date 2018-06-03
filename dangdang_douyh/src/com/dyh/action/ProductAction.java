package com.dyh.action;

import com.dyh.entity.Category;
import com.dyh.entity.PageBean;
import com.dyh.entity.Product;
import com.dyh.service.impl.CategoryServiceImpl;
import com.dyh.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;

public class ProductAction extends ActionSupport{
	ValueStack vs = ActionContext.getContext().getValueStack();//获取值栈对象
	//recommendProList替换request作用域  编辑推荐
	private List<Product> recommendProList ;
	public List<Product> getRecommendProList() {return recommendProList;}
	public void setRecommendProList(List<Product> recommendProList) {this.recommendProList = recommendProList;}

	//1编辑推荐 ，根据点击量查询
	public String findRecommendProduct() {
		try {
			ProductServiceImpl psi = new ProductServiceImpl();//创建实现类对象
		    recommendProList = psi.queryRecommendProduct();//实现编辑推荐功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("编辑推荐查询失败");
		}
		return "recommend";//跳转到recommend.jsp
	}

	//hotProList成员变量替换request作用域
	private List<Product> hotProList;
	public List<Product> getHotProList() {return hotProList;}
	public void setHotProList(List<Product> hotProList) {this.hotProList = hotProList;}
	
	//2热销图书
	public String  findHotProduct() {
		try {
			ProductServiceImpl psi = new ProductServiceImpl();//创建实现类对象
			hotProList = psi.queryHotProduct();              //实现新书查询功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("热销图书查询失败");
		}
		return "hot";//跳转到hot.jsp
	}
	
	//newProList成员变量替换作用域
	private List<Product> newProList;
	public List<Product> getNewProList() {return newProList;}
	public void setNewProList(List<Product> newProList) {this.newProList = newProList;}
	
	//3最新上架图书
	public String findNewProduct() {
		try {
			ProductServiceImpl psi = new ProductServiceImpl();//创建实现类对象
		    newProList = psi.queryNewProduct();//实现查询最新上架的功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("新书上架查询失败");
		}
		return "new";//跳转到new.jsp
	}


	//newHotProList成员变量替换request作用域
	private List<Product> newHotProList;
	public List<Product> getNewHotProList() {return newHotProList;}
	public void setNewHotProList(List<Product> newHotProList) {this.newHotProList = newHotProList;}
	
	//4新书热卖榜
	public String findNewHotproduct() {
		try {
			ProductServiceImpl psi = new ProductServiceImpl();//创建实现类对象
		    newHotProList = psi.queryNewHotProduct();        //实现查询新书热卖的功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("新书热卖查询失败");
		}
		return  "hotBoard";//跳转到hotBoard.jsp
	}
	
	// allProduct成员变量替换request作用域
    private	List<Product>  allProduct ;
	public List<Product> getAllProduct() {return allProduct;}
	public void setAllProduct(List<Product> allProduct) {this.allProduct = allProduct;}

	//查询所有图书
	public String findAllProduct() {
		try {
			ProductServiceImpl psi = new ProductServiceImpl();//创建实现类对象
			allProduct = psi.queryAllProduct();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("查询所有图书失败");
		}
		return "page";
	}
	
	//product成员变量替换request作用域
	private Product product;
	public Product getProduct() {return product;}
	public void setProduct(Product product) {this.product = product;}

	//id 成员变量收参
	private Integer id ;
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	//6查询单本图书
	public String findOneProductById() {
		System.out.println(id);
		try {
			ProductServiceImpl psi = new ProductServiceImpl();//创建实现类对象
			product = psi.queryOneProducrtById(id);  //实现根据单本书查询功能
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("单本书查询失败");
		}
		return "product";//跳转到product.jsp
	}
	//级联查询成员变量收参
	private Integer firstId;
	private Integer secondId;
	private Integer curpage;//分页的当前页
	public Integer getFirstId() {return firstId;}
	public void setFirstId(Integer firstId) {this.firstId = firstId;}
	public Integer getSecondId() {return secondId;}
	public void setSecondId(Integer secondId) {this.secondId = secondId;}
	public Integer getCurpage() {return curpage;}
	public void setCurpage(Integer curpage) {this.curpage = curpage;}
	
	//成员变量替换request作用域
	private List<Category> SomeCategoryList;  //小说下所有
	private List<Product> allProductCategory;//当代小说下所有
	public List<Product> getAllProductCategory() {return allProductCategory;}
	public void setAllProductCategory(List<Product> allProductCategory) {this.allProductCategory = allProductCategory;}
	public List<Category> getSomeCategoryList() {return SomeCategoryList;}
	public void setSomeCategoryList(List<Category> someCategoryList) {SomeCategoryList = someCategoryList;}
	
	//级联查询,分页查询
	public String findAllProductCategory() {
		ProductServiceImpl psi = new ProductServiceImpl();  //创建实现类对象
		CategoryServiceImpl csi = new CategoryServiceImpl();//创建类别的实现类对象
		//String like =(String) ServletActionContext.getRequest().getParameter("like");
		//System.out.println("like"+like);
		System.out.println("secondId="+secondId+"firstId:"+firstId);
			if(curpage == null) {
				curpage = 1;//让当前默认从一开始
			}
			//获取总行数
			List<Product> list = psi.queryAllProductCategory(firstId, secondId,null, null);
			System.out.println("我是总行数"+list.size());
			Integer start = (curpage-1) * 3 +1;    //开始下标
			Integer end = curpage * 3      ;      //结束下标
			if(end >= list.size()) {
				end = list.size();
			}
			//级联查询1
			 SomeCategoryList= csi.querySomeCategory(secondId);
			 //级联查询2，分页
			 allProductCategory = psi.queryAllProductCategory(firstId, secondId,start,end);
			 //创建PageBean对象
			 PageBean pb = new PageBean(curpage,//当前页，超链接拼接过来的参数
						list.size(),  //查询的总行数
								3    // 每页展示3行
								);
			 vs.setValue("#session.pb", pb);//将PageBean对象存在session中，做下一页的判断
			 	return "book_list";//跳转到book_list.jsp
	}
}
