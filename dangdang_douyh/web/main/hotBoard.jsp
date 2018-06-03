<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
		<h2 class="t_xsrm">
			<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>新书热卖
		</h2>
<s:iterator value="newHotProList" begin="0" end="7">
<div id="NewProduct_1_o_t" onmouseover="">
<ul>
	<li><a  target='_blank' href="${pageContext.request.contextPath}/product/findOneProductById?id=<s:property value="id"/>"><s:property value="bookName"/></a></li>
</ul>

</div>
</s:iterator>