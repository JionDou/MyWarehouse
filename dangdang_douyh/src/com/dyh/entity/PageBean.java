package com.dyh.entity;

public class PageBean{
	
	private Integer curpage ;  //当前页
	private Integer totalpage;//总页数
	private Integer pagerow; //每页几行
	public Integer getCurpage() {
		return curpage;
	}
	public void setCurpage(Integer curpage) {
		this.curpage = curpage;
	}
	public Integer getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(Integer totalpage) {
		this.totalpage = totalpage;
	}
	public Integer getPagerow() {
		return pagerow;
	}
	public void setPagerow(Integer pagerow) {
		this.pagerow = pagerow;
	}
	@Override
	public String toString() {
		return "PageBean [curpage=" + curpage + ", totalpage=" + totalpage + ", pagerow=" + pagerow + "]";
	}
	public PageBean(Integer curpage, Integer totalpage, Integer pagerow) {
		super();
		this.curpage = curpage;
		this.totalpage = totalpage;
		this.pagerow = pagerow;
	}
	public PageBean() {
		super();
	}
	//获取总页数
	public Integer getPagenum() {
		Integer pagenum = null;
		if(totalpage%pagerow==0) {
			pagenum  = totalpage/pagerow ;
		}else {
			pagenum = totalpage/pagerow + 1;
		}
		return pagenum;//返回一个总页数
	}
	
}
