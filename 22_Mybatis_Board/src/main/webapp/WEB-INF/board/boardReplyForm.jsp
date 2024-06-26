<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@include file="../common/common.jsp" %>   
    
    
    
    
 
<style>

	.err{
		font-size : 9pt;
		color : red;
		font-weight: bold;
	}


	body{
		text-align: center;
	}
	table{
		margin: 5px auto;
	}
</style>  



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


	<h3>답글쓰기${param.re_level }</h3>
	<form:form commandName="board" action="boardReply.bd" method="post">
		<input type="hidden" name="pageNumber" value="${pageNumber }">
		<input type="hidden" name="ref" value="${param.ref }">
		<input type="hidden" name="re_level" value="${param.re_level }">
		<input type="hidden" name="re_step" value="${param.re_step }">
		<table border="1" width="500">
			<tr>
				<td align="right" colspan="2">
					<a href="boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }">글목록</a>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="writer" value="${board.writer }">
				<form:errors path="writer" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject" value="${board.subject }">
				<form:errors path="subject" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<th>email</th>
				<td><input type="text" name="email" value="${board.email }">
				<form:errors path="email" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" rows="5" cols="50" value="${board.content }"></textarea>
				<form:errors path="content" cssClass="err"/>
				 </td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="passwd" value="${board.passwd }">
				<form:errors path="passwd" cssClass="err"/>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="글쓰기" onclick="return validatePassword('${board.passwd}')">
					<input type="button" value="다시작성">
					<input type="button" value="목록보기" onClick = "location.href='boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }'">
				</td>
			</tr>
		</table>
	</form:form>
</body>