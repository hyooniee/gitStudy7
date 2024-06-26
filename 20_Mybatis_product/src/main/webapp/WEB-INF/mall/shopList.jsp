<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp" %>    
mall\shopList.jsp<br>

<center>
    
    <h1>주문 내역</h1>
    
    <table border="1">
    	
    	<tr>
    		<td colspan="3">주문자 정보 : ${sessionScope.loginInfo.name}(${loginInfo.id})</td>
    	</tr>
    	
    	<tr>
    		<th>주문 번호</th>
    		<th>주문 일자</th>
    		<th>상세 보기</th>
    	</tr>
    	
    	<c:forEach var="ob" items="${orderLists}">
    		
    		<tr>
    			<td>${ob.oid}</td>
    			<td>${ob.orderdate}</td>
    			<td><a href="detailView.mall?oid=${ob.oid}">상세 보기</a></td>
    		</tr>
    		
    	</c:forEach>
    	
    </table>
    
    </center>