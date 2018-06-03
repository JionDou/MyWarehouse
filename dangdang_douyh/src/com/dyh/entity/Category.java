package com.dyh.entity;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable{
	/*Name	Code	Data Type	Length	Precision	Primary	Foreign Key	Mandatory
	编号	id	integer			TRUE	FALSE	TRUE
	类别名	category_name	varchar2(100)	100		FALSE	FALSE	FALSE
	类别的等级	category_level	INTEGER			FALSE	FALSE	FALSE
	本类书籍数量	book_count	integer			FALSE	FALSE	FALSE
	父类id	parent_id	integer			FALSE	TRUE	FALSE*/
	
	private Integer id;                  //分类id
	private String categoryName;        //种类名称
	private String categoryLevel;      //种类等级
	private Integer bookCount;        //本类书籍数量
	private Integer parentId;        //二级分类id
	private List<Category> category;//1：n
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryLevel() {
		return categoryLevel;
	}
	public void setCategoryLevel(String categoryLevel) {
		this.categoryLevel = categoryLevel;
	}
	public Integer getBookCount() {
		return bookCount;
	}
	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + ", categoryLevel=" + categoryLevel
				+ ", bookCount=" + bookCount + ", parentId=" + parentId + ", category=" + category + "]";
	}
	public Category(Integer id, String categoryName, String categoryLevel, Integer bookCount, Integer parentId,
			List<Category> category) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.categoryLevel = categoryLevel;
		this.bookCount = bookCount;
		this.parentId = parentId;
		this.category = category;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
