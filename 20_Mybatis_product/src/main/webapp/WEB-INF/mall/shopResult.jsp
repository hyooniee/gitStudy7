<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    
shopResult.jsp<br>

<h2>주문 상세 내역</h2>
<table border="1" width="50%">
	<tr>
		<td colspan="2">고객명 : ${loginInfo.name }</td>
		<td colspan="3">송장 번호(주문번호) : ${param.oid }</td>
	</tr>
	<tr>
		<td colspan="5">배송지 : ${sessionScope.loginInfo.address1 }&nbsp;${loginInfo.address2}</td>
	</tr>
	<tr>
		<th>순번</th>
		<th>상품명(상품번호)</th>
		<th>수량</th>
		<th>단가</th>
		<th>금액</th>
	</tr>
	<c:forEach var="i" begin="0" end="${fn:length(detailLists)-1 }">
		<tr>
			<td>${i+1 }</td>
			<td>${detailLists[i].pname }(${detailLists[i].pnum })</td>
			<td>${detailLists[i].qty }</td>
			<td><fmt:formatNumber pattern="###,###">${detailLists[i].price }</fmt:formatNumber>원</td>
			<td><fmt:formatNumber pattern="###,###">${detailLists[i].price * detailLists[i].qty }</fmt:formatNumber>원</td>
		</tr>
	</c:forEach>
</table>