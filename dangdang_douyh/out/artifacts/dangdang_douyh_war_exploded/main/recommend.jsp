<%@page contentType="text/html;charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<h2>
	<span class="more"><a href="#" target="_blank">更多&gt;&gt;</a> </span>编辑推荐图书
</h2>

<div id=__bianjituijian/danpin>
	<div class=second_c_02>
	<s:iterator value="recommendProList" begin ="0" end="1">
	
		<div class=second_c_02_b1>
			<div class=second_c_02_b1_1>
				<a href='${pagecontext.request.contextPath}/' target='_blank'><img src="${pageContext.request.contextPath}/<s:property value="photoSrc"/>" width=70 border=0 /></a>
			</div>
			<div class=second_c_02_b1_2>
				<h3>
					<a href="${pageContext.request.contextPath}/product/findOneProductById?id=<s:property value="id"/>" target='_blank' title='输赢'><s:property value="bookName"/></a>
				</h3>
				<h4>
					作者：<s:property value="authorName"/> 著
					<br />
					出版社：<s:property  value="publishHouse"/>&nbsp;&nbsp;&nbsp;&nbsp;出版时间：<s:property value="publishTime"/>
				</h4>
				<h5>
					简介:<s:property  value="contentIntroduce"/>
				</h5>
				<h6>
					定价：￥<s:property  value="usedPrice"/>&nbsp;&nbsp;当当价：￥<s:property  value="ddPrice"/>
				</h6>
				<div class=line_xx></div>
			</div>
		</div>
		</s:iterator>
		
			</div>
		</div>
		