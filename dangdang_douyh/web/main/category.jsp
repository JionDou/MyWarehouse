<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="book_l_border1" id="__FenLeiLiuLan">
	<div class="book_sort_tushu">
		<h2>
			分类浏览
		</h2>
		<!--1级分类开始-->
			<s:iterator value="allCategory">
			<div class="bg_old" onmouseover="this.className = 'bg_white';"
				onmouseout="this.className = 'bg_old';">
				<h3>
					[<a href='${pageContext.request.contextPath}/product/findAllProductCategory?secondId=<s:property value="id"/>'><s:property value="categoryName"/></a>]
				</h3>
				<ul class="ul_left_list">
					<s:iterator value="category" var="c1">
						<!--2级分类开始-->
						<li>
							<a href='${pageContext.request.contextPath}/product/findAllProductCategory?firstId=<s:property value="id"/>&secondId=<s:property value="parentId"/>'><s:property value="categoryName"/></a>
						</li>
						<!--2级分类结束-->
					</s:iterator>
				</ul>
				<div class="empty_left">
				</div>
			</div>
			</s:iterator>
		<div class="bg_old">
			<h3>
				&nbsp;
			</h3>
		</div>
		
	</div>
</div>
