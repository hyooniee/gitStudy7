<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../common/common.jsp" %>    
mallList.jsp<br>

<h2 align="center">주문 내역</h2>
<table border="1" align="center">
	<tr>
		<th colspan="5">주문자 정보: ${sessionScope.loginInfo.getName()}(${loginInfo.id })</th>
	</tr>
	<tr>
		<th>상품 번호</th>
		<th>상품명</th>
		<th>주문 수량</th>
		<th>단가</th>
		<th>금액</th>
	</tr>
	<c:forEach var="shop" items="${shoplists }">
	<tr>
		<td>${shop.pnum }</td>
		<td>${shop.pname }</td>
		<td align="center">${shop.qty }</td>
		<td><fmt:formatNumber value="${shop.price }" type="number" pattern="#,###"/>원</td>
		<td><fmt:formatNumber value="${shop.amount }" type="number" pattern="#,###"/>원</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="3">
			<a href="calculate.mall">결제하기</a>&nbsp;&nbsp; <!-- calculate.mall => CartCalculateController -->
			<a href="list.prd">추가 주문</a>
		</td>
		<td colspan="2">
			총 금액:<fmt:formatNumber value="${totalAmount}" type="number" pattern="0,000"/>원
		</td>
	</tr>
</table>