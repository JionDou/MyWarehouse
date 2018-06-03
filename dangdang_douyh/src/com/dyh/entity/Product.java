package com.dyh.entity;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable{
	
	private Integer id;                                    //商品id
	private Category category;                            //种类
	private String bookName;                             //书名
	private String authorName;                          //作者名
	private String publishHouse;                       //出版社
	private Date publishTime;               		  //出版时间
	private Integer publishCount;                    //出版数量
	private Date 	printTime;                      //印刷时间
	private Integer printCount;                    //印刷数量
	private String ISBN;                          //国际标准图书编号
	private String 	wordCount;                   //字数
	private String 	pageCount;                  //页数
	private String 	bookSize;                  //开本
	private String 	paperMater;               //纸质
	private String packageWay;               //包装
	private String editRecommend;           //编辑推荐
	private String	contentIntroduce;      //内容简介
	private String authorIntroduce;       //作者简介
	private String mediaComment;         //媒体评论
	private String excerpt;             //摘要
	private Double usedPrice;          //原价
	private Double ddPrice;           //当当价格
	private Integer purchaseCount;   //购买数量
	private Date putTime; 			//上架时间
	private String  photoSrc;      //照片链接
	private Integer hitNum;       //点击次数

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getPublishHouse() {
		return publishHouse;
	}
	public void setPublishHouse(String publishHouse) {
		this.publishHouse = publishHouse;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	public Integer getPublishCount() {
		return publishCount;
	}
	public void setPublishCount(Integer publishCount) {
		this.publishCount = publishCount;
	}
	public Date getPrintTime() {
		return printTime;
	}
	public void setPrintTime(Date printTime) {
		this.printTime = printTime;
	}
	public Integer getPrintCount() {
		return printCount;
	}
	public void setPrintCount(Integer printCount) {
		this.printCount = printCount;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getWordCount() {
		return wordCount;
	}
	public void setWordCount(String wordCount) {
		this.wordCount = wordCount;
	}
	public String getPageCount() {
		return pageCount;
	}
	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}
	public String getBookSize() {
		return bookSize;
	}
	public void setBookSize(String bookSize) {
		this.bookSize = bookSize;
	}
	public String getPaperMater() {
		return paperMater;
	}
	public void setPaperMater(String paperMater) {
		this.paperMater = paperMater;
	}
	public String getPackageWay() {
		return packageWay;
	}
	public void setPackageWay(String packageWay) {
		this.packageWay = packageWay;
	}
	public String getEditRecommend() {
		return editRecommend;
	}
	public void setEditRecommend(String editRecommend) {
		this.editRecommend = editRecommend;
	}
	public String getContentIntroduce() {
		return contentIntroduce;
	}
	public void setContentIntroduce(String contentIntroduce) {
		this.contentIntroduce = contentIntroduce;
	}
	public String getAuthorIntroduce() {
		return authorIntroduce;
	}
	public void setAuthorIntroduce(String authorIntroduce) {
		this.authorIntroduce = authorIntroduce;
	}
	public String getMediaComment() {
		return mediaComment;
	}
	public void setMediaComment(String mediaComment) {
		this.mediaComment = mediaComment;
	}
	public String getExcerpt() {
		return excerpt;
	}
	public void setExcerpt(String excerpt) {
		this.excerpt = excerpt;
	}
	public Double getUsedPrice() {
		return usedPrice;
	}
	public void setUsedPrice(Double usedPrice) {
		this.usedPrice = usedPrice;
	}
	public Double getDdPrice() {
		return ddPrice;
	}
	public void setDdPrice(Double ddPrice) {
		this.ddPrice = ddPrice;
	}
	public Integer getPurchaseCount() {
		return purchaseCount;
	}
	public void setPurchaseCount(Integer purchaseCount) {
		this.purchaseCount = purchaseCount;
	}
	public Date getPutTime() {
		return putTime;
	}
	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}
	public String getPhotoSrc() {
		return photoSrc;
	}
	public void setPhotoSrc(String photoSrc) {
		this.photoSrc = photoSrc;
	}
	public Integer getHitNum() {
		return hitNum;
	}
	public void setHitNum(Integer hitNum) {
		this.hitNum = hitNum;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", bookName=" + bookName + ", authorName=" + authorName
				+ ", publishHouse=" + publishHouse + ", publishTime=" + publishTime + ", publishCount=" + publishCount
				+ ", printTime=" + printTime + ", printCount=" + printCount + ", ISBN=" + ISBN + ", wordCount="
				+ wordCount + ", pageCount=" + pageCount + ", bookSize=" + bookSize + ", paperMater=" + paperMater
				+ ", packageWay=" + packageWay + ", editRecommend=" + editRecommend + ", contentIntroduce="
				+ contentIntroduce + ", authorIntroduce=" + authorIntroduce + ", mediaComment=" + mediaComment
				+ ", excerpt=" + excerpt + ", usedPrice=" + usedPrice + ", ddPrice=" + ddPrice + ", purchaseCount="
				+ purchaseCount + ", putTime=" + putTime + ", photoSrc=" + photoSrc + ", hitNum=" + hitNum + "]";
	}
	public Product(Integer id, Category category, String bookName, String authorName, String publishHouse,
			Date publishTime, Integer publishCount, Date printTime, Integer printCount, String iSBN, String wordCount,
			String pageCount, String bookSize, String paperMater, String packageWay, String editRecommend,
			String contentIntroduce, String authorIntroduce, String mediaComment, String excerpt, Double usedPrice,
			Double ddPrice, Integer purchaseCount, Date putTime, String photoSrc, Integer hitNum) {
		super();
		this.id = id;
		this.category = category;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publishHouse = publishHouse;
		this.publishTime = publishTime;
		this.publishCount = publishCount;
		this.printTime = printTime;
		this.printCount = printCount;
		ISBN = iSBN;
		this.wordCount = wordCount;
		this.pageCount = pageCount;
		this.bookSize = bookSize;
		this.paperMater = paperMater;
		this.packageWay = packageWay;
		this.editRecommend = editRecommend;
		this.contentIntroduce = contentIntroduce;
		this.authorIntroduce = authorIntroduce;
		this.mediaComment = mediaComment;
		this.excerpt = excerpt;
		this.usedPrice = usedPrice;
		this.ddPrice = ddPrice;
		this.purchaseCount = purchaseCount;
		this.putTime = putTime;
		this.photoSrc = photoSrc;
		this.hitNum = hitNum;
	}
	public Product() {
		super();
		
	}
	
	
}
