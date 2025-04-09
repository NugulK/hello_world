
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<link rel="stylesheet" href="https://cdn.datatables.net/2.2.2/css/dataTables.dataTables.css">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script src="https://cdn.datatables.net/2.2.2/js/dataTables.js"></script>

<!-- null 값 방지 -->
<c:set var="searchCondition" value="${empty searchCondition ? '' : searchCondition}" />
<c:set var="keyword" value="${empty keyword ? '' : keyword}" />

<h3>게시글 목록(BoardList.jsp)</h3>
<!-- 검색조건 유지 -->
<form action="boardList.do" method="get">
    <div class="row">
        <div class="col-sm-4">
            <select name="searchCondition" class="form-control">
                <option value="">선택하세요</option>
                <option value="T" ${searchCondition == 'T' ? 'selected' : ''}>제목</option>
                <option value="W" ${searchCondition == 'W' ? 'selected' : ''}>작성자</option>
                <option value="TW" ${searchCondition == 'TW' ? 'selected' : ''}>제목&작성자</option>
            </select>
        </div>
        <div class="col-sm-6">
            <input type="text" name="keyword" class="form-control" value="${keyword}">
        </div>
        <div class="col-sm-2">
            <button type="submit" class="btn btn-info">검색</button>
        </div>
    </div>
</form>

<table class="display" style="width:100%" id="example">
    <thead>
        <tr>
        	<th>글번호</th>
        	<th>제목</th>
        	<th>작성자</th>
        	<th>작성일시</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="board" items="${blist}">
        <tr>
            <td><c:out value="${board.boardNo}" /></td>
            <td><a href='board.do?page=${paging.currentPage}&bno=${board.boardNo}'>${board.title}</a></td>
            <td><c:out value="${board.writer}" /></td>
            <td><fmt:formatDate value="${board.writeDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<!-- paging 처리 -->
<script>
new DataTable('#example', {
    order: [[0, 'desc']]
});
</script>

