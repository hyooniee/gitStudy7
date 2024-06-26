<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
memberUpdateForm.jsp<br>
<%@ include file="../common/common.jsp" %>
<%
	String [] gender = {"남자","여자"};
	String [] hobby = {"마라톤", "영화감상", "게임", "공부"};
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
	
	주소1 <input type="text" name="address1" value="${member.address1}">
	<form:errors path="address1" cssClass="err" />
	<br><br>
	
	
	주소2 <input type="text" name="address2" value="${member.address2}">
	<form:errors path="address2" cssClass="err" />
	<br><br>
	
	적립포인트 <input type="text" name="mpoint" value="${member.mpoint}">
	<form:errors path="mpoint" cssClass="err" />
	<br><br>
	
	<input type="submit" value="정보 수정 하기">
</form:form>
	