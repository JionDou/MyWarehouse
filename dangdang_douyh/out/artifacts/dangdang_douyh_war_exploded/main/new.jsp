<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>最新上架图书
</h2>
<div class="book_c_04">

	<!--新书推荐A开始-->
	<s:iterator value="newProList" begin="0" end="7">
	<div class="second_d_wai">
		<div class="img">
			<a href="${pageContext.request.contextPath}/#" target='_blank'><img
					src="${pageContext.request.contextPath}/<s:property value="photoSrc"/>" border=0 /> </a>
		</div>
		<div class="shuming">
			<a href="${pageContext.request.contextPath}/product/findOneProductById?id=<s:property value="id"/>" target="_blank"><s:property value="bookName"/></a><a href="#" target="_blank"></a>
		</div>
		<div class="price">
			定价：￥<s:property value="usedPrice"/>
		</div>
		<div class="price">
			当当价：￥<s:property value="ddPrice"/>
		</div>
	</div>
	<div class="book_c_xy_long"></div>
	</s:iterator>
	<!--新书推荐A结束-->

</div>
<div class="clear"></div>