
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script>
	function memberList() {
		location.href="memberList.mb"; 
	}
	
	function register(){
		location.href="memberInsert.mb";
	}
</script>
<form method="post" action="loginForm.mb">

	
	<input type="hidden" name="pageNumber" value="${param.pageNumber}">
	<input type="hidden" name="keyword" value="${param.keyword}">
	<input type="hidden" name="whatColumn" value="${param.whatColumn}">
	<input type="hidden" name="ref" value="${param.ref}">
	<input type="hidden" name="re_step" value="${param.re_step}">
	<input type="hidden" name="re_level" value="${param.re_level}">
	
	
	<table border="1" width="40%" height="120px">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="id" value="kim"></td>
		</tr>
		
		<tr>
			<td>비번</td>
			<td><input type="password" name="password" value="1234"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
				<input type="reset" value="취소">
				<input type="button" value="회원가입" onClick="register()">
				<input type="button" value="회원 목록보기" onClick="memberList()">
			</td>
		</tr>
	</table>

</form>   