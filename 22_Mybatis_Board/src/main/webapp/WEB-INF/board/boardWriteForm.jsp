<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@include file="../common/common.jsp" %>   
    
 
<style>
	.err {
		color: red;
		font-size: 11px;
		font-family: sans-serif;
	}
</style> 
 
 
<style>
	body{
		text-align: center;
	}
	table{
		margin: 5px auto;
	}
</style>  
<script>
	function list(){
		location.href="boardList.bd";
	}

</script>
	<h3>글쓰기</h3>
	<form:form commandName="board" action="boardInsert.bd" method="post">
		<input type="hidden" name="pageNumber" value="${pageNumber }">
		<table border="1" width="500">
			<tr>
				<td align="right" colspan="2">
					<a href="boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }">글목록</a>
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${loginInfo.name }">
				<form:errors path="writer" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${board.subject }">
				<form:errors path="subject" cssClass="err"/></td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="text" name="email" value="${board.email }">
				<form:errors path="email" cssClass="err"/></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><input type="text" name="content" value="${board.content }">
				<form:errors path="content" cssClass="err"/></td>
			</tr>
				<tr>
				<th>비밀번호</th>
				<td><input type="text" name="passwd" value="${board.passwd }">
				<form:errors path="passwd" cssClass="err"/></td>
			</tr>
			
		
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기">
					<input type="button" value="다시작성">
					<input type="button" value="목록보기" onClick = "location.href='boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }'">
				</td>
			</tr>
		</table>
	</form:form>