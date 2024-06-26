<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/common.jsp"%>


<script>
	function insert(){
		location.href="boardInsert.bd";
	}
</script>
<a href="logout.jsp">로그아웃</a>
<center>
	<h2>게시판 목록보기</h2>
	<form action="boardList.bd" method="get">

		<select name="whatColumn">
			<option value="all">전체검색
			<option value="subject">제목
			<option value="writer">작성자
		</select><input type="text" name="keyword"> <input type="submit"
			value="검색">


	</form>
</center>


<c:if test="${articleCount == 0}">
	<table border="1" align="center">
		<tr>
			<td colspan="6"><input type="button" value="추가하기" onClick="insert()"></td>
		</tr>
		<tr>
			<td align="center">게시판에 저장된 글이 없습니다.</td>
		</tr>
	</table>
</c:if>
<c:if test="${articleCount != 0}">

	<table border="1" align="center">
		<tr>
			<td colspan="6"><input type="button" value="추가하기" onClick="insert()"></td>
		</tr>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			<th>IP</th>

		</tr>

		<c:set var="number" value="${pageInfo.articleCount-(pageInfo.pageNumber-1)*pageInfo.pageSize }"/>
		<c:forEach var="board" items="${boardLists }">
			<tr align="center">
				<td>${number }</td>
				<td align="left">
					<c:if test="${board.re_level > 0}">
						<c:set var="wid" value="${board.re_level * 20}" />
						<img src="resources/images/level.gif" width="${wid}" height="15">
						<img src="resources/images/re.gif">
					</c:if> 
					<a href="detail.bd?num=${board.num }&pageNumber=${pageInfo.pageNumber}&whatColumn=${pageInfo.whatColumn}&keyword=${pageInfo.keyword}">${board.subject}</a>
					<c:if test="${board.readcount >=10 }">
						<img src="resources/images/hot.gif" height="15">
					</c:if>
				</td>
				<td>${board.writer }</td>
				<td>
					<fmt:parseDate value="${board.reg_date}" var="date" pattern="yyyy-MM-dd" /> 
					<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm" />
				</td>
				<td>${board.readcount }</td>
				<td>${board.ip }</td>
			</tr>
			<c:set var="number" value="${number -1}" />
		</c:forEach>
	</table>
</c:if>
<p align="center">${pageInfo.pagingHtml }</p>
