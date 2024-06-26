<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <%@include file="../common/common.jsp" %>  
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
    
   
    
    <form:form commandName="board" action="boardDelete.bd" method="post">
    <input type="hidden" name="num" value="${board.num }">
   
   
   
    <table border="1">
    	<tr>
    		<td>비밀번호를 입력해 주세요.</td>
    	</tr>
    	<tr>
    		<td>비밀번호: <input type="text" name = "passwd" value="${board.passwd }" ></td>
    	</tr>
    	<tr>
    		<td><input type="submit" value="글삭제" onclick="return validatePassword('${board.passwd}')">
    		<input type="button" value="글목록" onClick = "location.href='boardList.bd?pageNumber=${param.pageNumber}&whatColumn=${param.whatColumn }&keyword=${keyword }'"">
    		</td>
    	</tr>
    
    </table>
    </form:form>>