<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<s:debug/>
	<head>
		<title>当当图书 – 全球最大的中文网上书店</title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js">
		</script>
		<script type="text/javascript">
			//购买单击事件
				function fn(obj,id){
					 $(obj).children().attr('src',"${pageContext.request.contextPath}/car/window_loading.gif");
					console.log(id);
					//ajax异步请求
					$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/car/addOrderItem",
					data:"id="+id,
					dataType:"text",
					success:function(data){
					$(obj).children().attr('src',"${pageContext.request.contextPath}"+data);
					$(obj).next().text("购买成功");
		            window.setTimeout(function(){
		            $(obj).children().attr('src',"${pageContext.request.contextPath}/product_files/booksale.gif"); 
		             // 清空
		             $(obj).next().text("");
		             },2000);
					}	
					});
				}

		</script>
		<link href="${pageContext.request.contextPath}/css/book.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/second.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/secBook_Show.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath}/css/list.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		&nbsp;
		<!-- 头部开始 -->
		<%@include file="../common/head.jsp"%>
		<!-- 头部结束 -->
		
		<div style="width: 962px; margin: auto;">
			<a href="${pageContext.request.contextPath}/#"><img src="${pageContext.request.contextPath}/images/default/book_banner_081203.jpg" border="0" /> </a>
		</div>
		
		<div class='your_position'>
			您现在的位置:&nbsp;
			<a href='${pageContext.request.contextPath}/main/main.jsp'>当当图书</a> &gt;&gt;
			<!--  -->
			<s:iterator value="SomeCategoryList">
			 <s:if test="firstId == null"><strong><font  style='color: #cc3300' >
				<s:property value="categoryName"/></font></strong>
			</s:if>
			<!--  -->
			<s:else>
				<s:property value="categoryName"/>
			</s:else>
			
			<s:iterator value="category">
				<s:if test="id ==firstId">
				 &gt;&gt;
					<font  style='color: #cc3300' >
						<strong><s:property value="categoryName"/></strong>
					</font>
				</s:if>
			<!--  -->
			</s:iterator>
			</s:iterator>
		</div>

		<div class="book">
			<!--左栏开始-->	
			<div id="left" class="book_left">
				<div id="__fenleiliulan">
					<div class="second_l_border2">
						<h2>分类浏览</h2>	 
						<s:iterator value="SomeCategoryList">
						<ul>
							<li>
								<div>
									<div class="second_fenlei">
									<!--  -->
									<s:if test="firstId == null">
										<a href ="${pageContext.request.contextPath}/product/findAllProductCategory?secondId=<s:property value="id"/>"><strong><font  style='color: #cc3300' > &middot;全部&nbsp;(<s:property value="bookCount"/>)</font></strong></a>
										
									</s:if>
									<s:else>
									<a href ="${pageContext.request.contextPath}/product/findAllProductCategory?secondId=<s:property value="id"/>">
									&middot;全部&nbsp;(<s:property value="bookCount"/>) 
									</a>
									</s:else>
									</div>
								</div>
							</li>
							<div class="clear"></div>
							<!--2级分类开始-->
							<s:iterator value="category">
							<li>
								<div>
									<div class="second_fenlei">&middot;</div>
									<div class="second_fenlei">
										<a href="${pageContext.request.contextPath}/product/findAllProductCategory?firstId=<s:property value="id"/>&secondId=<s:property value="parentId"/>">
										<!--  -->
										<s:if test="id ==firstId">
										<font  style='color: #cc3300' >
										<strong><s:property value="categoryName"/>(<s:property value="bookCount"/>)</strong>
					                    </font>
					                    </s:if>
					                    <!--  -->
					                    <s:else><s:property value="categoryName"/>(<s:property value="bookCount"/>)</s:else>
										</a>
									</div>
								</div>
							</li>
							<div class="clear"></div>
						   </s:iterator>
							</s:iterator>
							<!--2级分类结束-->
						</ul>
					</div>
				</div>
			</div>

			<!--左栏结束-->

			<!--中栏开始-->
			<div class="book_center">
				<!--图书列表开始-->
				<div id="divRight" class="list_right">
					<div id="book_list" class="list_r_title">
						<div class="list_r_title_text">
							排序方式
						</div>
						<select onchange='changeBy(this,<s:property value="category.id"/>,<s:property value="category.parentId"/>);' name='selectOrder' size='1' id="select" 
							class='list_r_title_ml'>
							<option value="putTime">按上架时间 降序</option>
							<option value="hitNum">按点击次数</option>
							<option value="publishTime">按出版时间</option>
							<option value="printTime">按印刷时间</option>
						</select>
						<div id="divTopPageNavi" class="list_r_title_text3">

							<!--分页导航开始-->
							<div class='list_r_title_text3a'>
							<s:if test="#session.pb.curpage != 1">
								<a name="link_page_next"
									href='${pageContext.request.contextPath}/product/findAllProductCategory?curpage=<s:property value="#session.pb.curpage-1"/>&firstId=<s:property value="firstId"/>&secondId=<s:property value="secondId"/>' >
								<img src='${pageContext.request.contextPath}/images/page_up.gif'/> </a>
								</s:if>
							</div>
	            
							
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath}/images/page_up_gray.gif' />
							</div>
				
							<div class='list_r_title_text3b'>
								第<s:property value="#session.pb.curpage"/>页/共<s:property value="#session.pb.pagenum"/>页
							</div>
							
							<div class='list_r_title_text3a'>
							<s:if test="#session.pb.curpage < #session.pb.pagenum">
								<a name="link_page_next"
									href='${pageContext.request.contextPath}/product/findAllProductCategory?curpage=<s:property value="#session.pb.curpage+1"/>&firstId=<s:property value="firstId"/>&secondId=<s:property value="secondId"/>'> 
									<img src='${pageContext.request.contextPath}/images/page_down.gif' /> </a>
							</s:if>
							</div>
			
							<div class='list_r_title_text3a'>
								<img src='${pageContext.request.contextPath}/images/page_down_gray.gif' />
							</div>
							

							<!--分页导航结束-->
						</div>
					</div>
					
					<!--商品条目开始-->
						<s:iterator  value="allProductCategory">
						<div class="list_r_line"></div>
						<div class="clear"></div>
						<div class="list_r_list">
							<span class="list_r_list_book"><a name="link_prd_img" href='#'>
								<img src="${pageContext.request.contextPath}/<s:property value="photoSrc"/>" /> </a> </span>
							<h2>
								<a name="link_prd_name" href='${pageContext.request.contextPath}/product/findOneProductById?id=<s:property value="id"/>'><s:property value="bookName"/></a>
							</h2>
							<h3>
								顾客评分：100
							</h3>
							<h4 class="list_r_list_h4">
								作 者:
								<a href='#' name='作者'><s:property value="authorName"/></a>
							</h4>
							<h4>
								出版社：
								<a href='#' name='出版社'><s:property value="publishHouse"/></a>
							</h4>
							<h4>
								出版时间：<s:property value="publishTime"/>
							</h4>
							<h5>
								媒体评论：<s:property value="mediaComment"/>
							</h5>
							<div class="clear"></div>
							<h6>
								<span class="del">￥ <s:property value="usedPrice"/></span>
								<span class="red">￥<s:property value="ddPrice"/></span>
								节省：￥<s:property value="usedPrice-ddPrice"/>
							</h6>
							<span class="list_r_list_button"></span> 
							<a  onclick="fn(this,<s:property value="id"/>);" > 
							<img src='${pageContext.request.contextPath}/images/buttom_goumai.gif' /> 
							</a>
							<span id="cartinfo"></span>
						</div>
						<div class="clear"></div>
						</s:iterator>
					
						<!--商品条目结束-->

					<div class="clear"></div>
					<div id="divBottomPageNavi" class="fanye_bottom">
					</div>

				</div>
				<!--图书列表结束-->

			</div>
			<!--中栏结束-->
			<div class="clear"></div>
		</div>

		<!--页尾开始 -->
		<%@include file="../common/foot.jsp"%>
		<!--页尾结束 -->
		
	</body>
&lt;</html>
<<s:debug></s:debug>
