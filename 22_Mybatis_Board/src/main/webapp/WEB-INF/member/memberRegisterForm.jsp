<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>    

<style>
   table {
        width: 80%;
        border-collapse: collapse;
    }
    td, th {
        border: 1px solid gray;
        padding: 10;
        
    }
    th {
        background: #2f4f4f;
        color: white;
    }
    a {
        text-decoration: none;
        color: blue;
    }
    a:hover {
        font-weight: bold;
        color: #87cefa;
        text-decoration: underline;
    }
 input[type="submit"], input[type="button"] {
            background-color: #696969; 
            border: none;
            color: white;
            padding: 4px 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 13px;
            margin: 4px 2px;
            cursor: pointer;
            transition-duration: 0.4s;
            border-radius: 8px;
        }
        input[type="submit"]:hover, input[type="button"]:hover {
            background-color: white;
            color: #87cefa;
        }
        .err{
        color : red;
        font-size:9pt;
        }
       
</style>
<h2 align="center">회원 가입 화면</h2>
<form:form commandName="member" action="memberInsert.mb" method="post">
<table>
	<tr>
		<th>아이디</th>
		<td>
			<input type="text" name="id" value="${member.id }">
			<form:errors path="id" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>이름</th>
		<td>
			<input type="text" name="name" value="${member.name }">
			<form:errors path="name" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>비번</th>
		<td>
			<input type="text" name="password" value="${member.password }">
			<form:errors path="password" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>성별</th>
		<td>
			<% String[] gender = {"여자","남자"}; %>
				<c:forEach var="gender" items="<%=gender%>">
					<input type="radio" name="gender" value="${gender}" <c:if test="${member.gender eq gender}">checked</c:if>>${gender}
				</c:forEach>
			<form:errors path="gender" cssClass="err"/>
		</td>
	</tr>
	<tr>
		<th>취미</th>
		<td>
			<%String [] hobby = {"마라톤","영화감상","게임","공부"}; %>
			<c:forEach var="hobby" items="<%=hobby %>">
			<input type="checkbox" name="hobby" value="${hobby }" <c:if test="${fn:contains(member.hobby , hobby)}">checked</c:if>>${hobby }
			</c:forEach>
			<form:errors path="hobby" cssClass="err"/>
		</td>
	</tr>
	
		<tr>
			<th>직업</th>
			<td>
				<select name="job">
				<%String[] job={"학생","회사원","무직","공무원"}; %>
				<c:forEach var="job" items="<%=job %>">
					<option value="${job }" <c:if test="${member.job eq job }">selected</c:if> > ${job }</option>
				</c:forEach>
				</select>
	<form:errors path = "job" cssClass = "err"></form:errors>
			</td>
		</tr>
 		
	<tr>
		<th colspan="2"><input type="submit" value="추가하기"></th>
	</tr>
	</table>
</form:form>
