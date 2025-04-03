<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<h3>삭제화면(deleteBoard.jsp)</h3>
<form action="deleteBoard.do" method="POST">
	<input type="hidden" name="bno" value="<%=board.getBoardNo()%>">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=board.getBoardNo()%></td>
			<th>작성자</th><td><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td class="form-control"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3" class="form-control"><%=board.getContent()%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3"><%=board.getWriteDate()%></td>
		</tr>
		<tr>
			<td colspan="3" align="center">
				<button type="submit" class="btn btn-danger">삭제</button>
			</td>
		</tr>
	</table>
</form>