<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
memberUpdateForm.jsp<br>
<%@ include file="../common/common.jsp" %>
<%
	String [] gender = {"남자","여자"};
	String [] hobby = {"마라톤", "영화감상", "게임", "공부"};
	String[] job={"학생","회사원","무직","공무원"};
%>
<style>
	.err {
		color: red;
		font-size: 11px;
		font-family: sans-serif;
	}
</style>
<h2>회원 정보 수정 화면</h2>
<form:form commandName="member" method="post" action="memberUpdate.mb?pageNumber=${param.pageNumber }&whatColumn=${param.whatColumn }&keyword=${param.keyword }">

	아이디 <input type="text" name="id" value="${member.id}" disabled>
	<input type="hidden" name="id" value="${member.id}">
	<br><br>
	
	이름 <input type="text" name="name" value="${member.name}">
	<form:errors path="name" cssClass="err" />
	<br><br>
	
	비번 <input type="text" name="password" value="${member.password}">
	<form:errors path="password" cssClass="err" />
	<br><br>
	
	성별 
	<c:set var="gender" value="<%=gender %>"/>
	<c:forEach var="i" begin="0" end="${fn:length(gender)-1 }">
		<input type="radio" name="gender" value="${gender[i] }"
			<c:if test ="${member.gender eq gender[i] }">checked</c:if>>
			${gender[i]}
	</c:forEach>
	<form:errors path="gender" cssClass="err" />
	<br><br>
	
	취미
	<c:set var="hobby" value="<%=hobby %>"/>
	<c:forEach var="i" begin="0" end="${fn:length(hobby)-1 }">
		<input type="checkbox" name="hobby" value="${hobby[i]}"
			<c:if test = "${fn:contains(member.hobby, hobby[i]) }">checked</c:if>>
			${hobby[i]}
	</c:forEach>
	<form:errors path="hobby" cssClass="err" />
	<br><br>
	
	직업
	<select name="job">
				
				<c:forEach var="job" items="<%=job %>">
					<option value="${job }" <c:if test="${member.job eq job }">selected</c:if> > ${job }</option>
				</c:forEach>
				</select>
	
	<input type="submit" value="정보 수정 하기">
</form:form>
	