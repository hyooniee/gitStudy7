<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file = "../common/common.jsp" %>
<style type="text/css">
	.err{
		font-size : 9pt;
		color : red;
		font-weight: bold;
	}
	
	table {
		border : 1px solid;
		border-collapse: collapse;
		margin : auto;
		width : 80%;
		height : 60%;
	}
	
	th{
		background-color: pink;
	}
	
	th, td, tr{
		border : 1px solid;
	}
	
	h2{
		text-align: center;
	}
</style>

<form:form commandName = "board" action = "boardUpdate.bd" method = "post" >

<script>
        function validatePassword(originalPassword) {
            var password = document.getElementsByName("passwd")[0].value;
            if (password !== originalPassword) {
                alert("비밀번호가 일치하지 않습니다.");
                return false;
            }
            return true;
        }
    </script>

<h2>글 쓰기</h2>
pageNumber : ${param.pageNumber } <br>
whatColumn : ${param.whatColumn} <br>
keyword : ${param.keyword} <br>



	<input type="hidden" name = "num" value = "${board.num }">
	<input type="hidden" name="pageNumber" value="${param.pageNumber}">
   	<input type="hidden" name="whatColumn" value="${param.whatColumn}">
   	<input type="hidden" name="keyword" value="${param.keyword}">
		<table>
		<tr>
			<td colspan="2" align="right">
				<a href="boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }">글목록</a>
			</td>		
		</tr>
		<tr>
			<th>이름</th> 
		 	<td>
				 <input type = "text" name = "writer" value = "${board.writer }">
				<form:errors path="writer" cssClass="err"/>
			</td>
		</tr>
	
		<tr>
			<th>제목 </th>
			<td>
			<input type = "text" name = "subject" value = "${board.subject }">
			<form:errors path="subject" cssClass="err"/>
			</td>
		</tr>
	
	<tr>
		<th>Email </th>
		<td>
			 <input type = "text" name = "email" value = "${board.email }">
			<form:errors path="email" cssClass="err"/>
		</td>
	</tr>
	
	<tr>
		<th>내용</th> 
		<td>
    		<textarea name="content" rows="10" cols="50">${board.content}</textarea>
    		<form:errors path="content" cssClass="err"/>
		</td>
	</tr>
<tr>
		<th>비밀번호</th>
		<td>
			<input type="text" name="passwd"  value="${board.passwd }"  >
			<form:errors path="passwd" cssClass="err"/>
		</td>
	</tr>
	
	
	
	<tr style = "text-align : center">
		<td colspan="2">
			<input type = "submit" value = "글쓰기" onclick="return validatePassword('${board.passwd}')">
			<input type = "button" value = "다시작성">
			<input type = "button" value = "목록보기" onClick = "location.href='boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }'">
		</td>
	</tr>
	</table>
</form:form>
