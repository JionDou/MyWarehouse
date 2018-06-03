<%@ page import="java.util.*" pageEncoding="Utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<HTML>
<HEAD>
<TITLE>发现孩子(蒙台梭利儿童教育经典原著) - 图书 - 当当网</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="${pageContext.request.contextPath}/product_files/dangdang.css" type=text/css rel=Stylesheet>
<LINK href="${pageContext.request.contextPath}/product_files/book.css" type=text/css rel=stylesheet>
<script type="text/javascript"  src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript">
					//单击事件
				function fn(obj){
					 $('#buy').attr('src',"${pageContext.request.contextPath}/car/window_loading.gif");
					var id =$(obj).attr('value');
					console.log(id);
					//ajax异步请求
					$.ajax({
					type:"POST",
					url:"${pageContext.request.contextPath}/car/addOrderItem",
					data:"id="+id,
					dataType:"text",
					success:function(data){
				    $('#buy').attr('src',"${pageContext.request.contextPath}"+data);
					$('#msgBuy').text("购买成功");
		             window.setTimeout(function(){
		             $('#buy').attr('src',"${pageContext.request.contextPath}/product_files/booksale.gif"); 
		             // 清空
		             $('#msgBuy').text("");
		             },2000);
					}	
					});
				}
						
		</script>
</HEAD>
<BODY>
<s:iterator value="product">
<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 10; POSITION: absolute"></DIV>
<DIV id=div_shield></DIV>
<DIV id="main">
<DIV class="mainsearch"></DIV>
<DIV class="wrap"><!--left start-->
	<!--left end-->
<DIV class="right">
<DIV class="right_wai">
<DIV class=shuming>
<DIV class=shuming_left><SPAN class=black000><A 
name=top_bk></A><s:property value="bookName"/></SPAN> </DIV>
<DIV class=book_case><SPAN class=seriesname> 
丛书名：	<s:property value="bookName"/></SPAN> </DIV>
<DIV class=empty_box></DIV></DIV>
<DIV class=book_left>
<DIV class=book_pic><A 
href="javascript:ImgBtnChgPrd_Click(this,'http://img39.ddimg.cn/93/5/20867709-1_o.jpg')" 
name=bigpicture_bk><IMG id=img_show_prd 
src="${pageContext.request.contextPath}/<s:property value="photoSrc"/>"></A> </DIV><INPUT id=hid_largepictureurl 
type=hidden> </DIV>
<DIV class=book_right>
<DIV id=author_>作　　者：<s:property value="authorName"/></DIV>
<DIV id=publisher_>出 版 社： <s:property value="publishHouse"/></DIV>
<UL>
  <LI>出版时间：<s:property value="publishTime"/></LI>
  <LI>字　　数： <s:property value="wordCount"/> </LI>
  <LI>版　　次：<s:property value="publishCount"/> </LI>
  <LI>页　　数：<s:property value="pageCount"/> </LI>
  <LI>印刷时间：<s:property value="printTime"/> </LI>
  <LI>开　　本：<s:property value="bookSize"/></LI>
  <LI>印　　次： <s:property value="printCount"/></LI>
  <LI>纸　　张： <s:property value="paperMater"/> </LI>
  <LI>I S B N ： <s:property value="ISBN"/> </LI>
  <LI>包　　装：<s:property value="packageWay"/> </LI></UL>
<DIV id=__categroy_bk>所属分类： <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.00.00.00.00.00" 
target=_blank>图书<s:property value=""/></A> &gt;&gt; <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.30.00.00.00.00" 
target=_blank>社会科学<s:property value=""/></A> &gt;&gt; <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.30.07.00.00.00" 
target=_blank>教育<s:property value=""/></A> &gt;&gt; <A class=blue12a 
href="http://product.dangdang.com/category.ashx?code=01.30.07.04.00.00" 
target=_blank>各级教育<s:property value=""/></A></DIV>
<DIV class=jiage><SPAN class=gray87>定价：<SPAN class=del 
id=originalPriceTag>￥<s:property value="usedPrice"/></SPAN></SPAN> <SPAN 
class=redc30>当当价：￥<B><s:property value="ddPrice"/></B></SPAN> 节省：￥ <s:property value="usedPrice-ddPrice"/>
<DIV class=pd_buy_num> 
<DIV class=clear></DIV></DIV>
<DIV class=goumai>
<A  title=购买  onclick="fn(this);" value="<s:property value="id"/>" name=purchase_book>
<IMG  id="buy" src="${pageContext.request.contextPath}/product_files/booksale.gif"><span id="msgBuy" ></span></A>
<!--  <A id=favor title=收藏 href="#" name=wishlist_book>
<IMG id="imgfavor" src="${pageContext.request.contextPath}/product_files/bookz_save.gif"></A>
-->
</DIV>

</DIV></DIV>
<DIV id=dvTPUrls></DIV>
<DIV id=__zhinengbiaozhu_bk>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="${pageContext.request.contextPath}/product_files/bg_point1.gif" align=absMiddle> 
编辑推荐</H2>
<DIV 
class=zhengwen>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="editRecommend"/> 在这本书里，我力图说明儿童早期教育中的某些问题，尤其要让读者认识到一个事实：我们的工作成就不仅仅是创建了一种新的教育模式。我们得出的结论已经显现于这本书名之中――发现孩子！<BR>――玛丽娅&#8226;蒙台梭利（本书作者）<BR><BR>今天，人类社会迫切需要重建教育方法；为此而奋斗，也就是为人类复兴而奋斗！<BR>　――塞吉（玛丽娅&#8226;蒙台梭利博士的老师）<BR><BR>蒙台梭利理论体系的精华是她对下面这个真理的有力论断或再论断：除非在自由的气氛中，儿童即不可能发展自己，也不可能受到有益的研究。<BR>　　 
――E&#8226;G&#8226;霍尔姆斯（哈佛大学教育学院教授）</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="${pageContext.request.contextPath}/product_files/bg_point1.gif" align=absMiddle> 
内容简介</H2>
<DIV class=zhengwen><s:property value="contentIntroduce"/></DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="${pageContext.request.contextPath}/product_files/bg_point1.gif" align=absMiddle> 
作者简介</H2>
<DIV class=zhengwen><s:property value="authorIntroduce"/>
</DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="${pageContext.request.contextPath}/product_files/bg_point1.gif" align=absMiddle> 
目录</H2>
<DIV 
class=zhengwen><s:property value=""/></DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="${pageContext.request.contextPath}/product_files/bg_point1.gif" align=absMiddle> 
媒体评论</H2>
<DIV class=zhengwen><s:property value="mediaComment"/></DIV>
<DIV class=dashed></DIV>
<H2 class=black14><IMG src="${pageContext.request.contextPath}/product_files/bg_point1.gif" align=absMiddle> 
书摘插图</H2>
<DIV class=zhengwen>第2章 
对教育方法的历史回顾<BR><s:property value="excerpt"/><BR>
……
</s:iterator >
</DIV></DIV>
<A name=review_point></A>
	</DIV></DIV>
<DIV id=tag_box style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
<DIV id=tag_box_pay style="DISPLAY: none; Z-INDEX: 2; POSITION: absolute"></DIV>
<DIV id=div_shield></DIV><!--页尾 开始 -->
<DIV class=public_footer_add_s></DIV><!--09.3.10new-->
<!--页尾 end -->
<!--页尾开始 -->
<%@include file="../common/foot.jsp"%>
<!--页尾结束 -->
</BODY></HTML>
