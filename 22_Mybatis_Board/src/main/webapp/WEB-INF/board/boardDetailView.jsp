<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
 <%@include file="../common/common.jsp" %>   
    
    


<style>
   table {
      font-family: sans-serif;
      border-collapse: collapse;
      border-width: 2px;
   }
   th {
      background-color: #ffe4e1;
   }
   td {
      padding-left: 4px;
      
   }
   a {
      color: #00ADB5;
   }
   a:hover{
      color: #393E46;
   }
</style>

<center>

<h2>글내용 보기</h2> 
<table border=1 width="600" height="300">
   <tr>
      <th>
      글번호
      </th>
      <td>${board.num }</td>
      <th>조회수</th>
      <td>${board.readcount}</td>
   </tr>
   <tr>
      <th>작성자</th>
      <td>${board.writer}</td>
   
   
      <th>작성일</th>
      <td>${board.reg_date}</td>
   </tr>
   <tr>
      <th>글제목</th>
      <td colspan="3">${board.content}</td>
   </tr>
   <tr>
      <th>글내용</th>
       <td colspan="3">${board.content}</td>
    </tr>
     
   <tr align="center">
      <td colspan="4">
      <a href="boardUpdate.bd?num=${board.num }&whatColumn=${param.whatColumn}&keyword=${param.keyword}&pageNumber=${param.pageNumber}">글수정</a>
      <a href="boardDelete.bd?num=${board.num }&whatColumn=${param.whatColumn}&keyword=${param.keyword}&pageNumber=${param.pageNumber}">글삭제</a>
     <a href="boardReply.bd?num=${board.num}&whatColumn=${param.whatColumn}&keyword=${param.keyword}&pageNumber=${param.pageNumber}&ref=${board.ref}&re_step=${board.re_step}&re_level=${board.re_level}">답글쓰기</a>
      <a href="boardList.bd?whatColumn=${param.whatColumn}&keyword=${param.keyword}&pageNumber=${param.pageNumber}">글목록</a>
      
      </td>
   </tr>
</table>

</center>    