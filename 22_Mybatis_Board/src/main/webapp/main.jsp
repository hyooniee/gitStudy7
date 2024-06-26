<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="WEB-INF/common/common.jsp" %>
    
main.jsp <br><br>

<%
	String viewBoard = request.getContextPath() +"/boardList.bd";
	
	String viewMember = request.getContextPath() +"/memberList.mb";
%>

<a href="<%=viewBoard%>">게시판 목록 보기</a> <br><br>

<a href="<%=viewMember%>">회원 목록 보기</a> <br><br>

<!-- <a href="logout.jsp">로그아웃</a> -->
