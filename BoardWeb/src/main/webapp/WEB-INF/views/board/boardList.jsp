<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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

<table class="table">
    <thead>
        <tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th></tr>
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
<nav aria-label="...">
    <ul class="pagination">
        <!-- 이전 10개 페이지 여부 -->
        <c:choose>
            <c:when test="${paging.prev}">
                <li class="page-item">
                    <a class="page-link" href="boardList.do?page=${paging.startPage - 1}&searchCondition=${searchCondition}&keyword=${keyword}">Previous</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item disabled">
                    <span class="page-link">Previous</span>
                </li>
            </c:otherwise>
        </c:choose>
        
        <c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
            <c:choose>
                <c:when test="${paging.currentPage == p}">
                    <li class="page-item active" aria-current="page">
                        <span class="page-link">${p}</span>
                    </li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link" href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}">${p}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        
        <!-- 이후 10개 페이지 여부 -->
        <c:choose>
            <c:when test="${paging.next}">
                <li class="page-item">
                    <a class="page-link" href="boardList.do?page=${paging.endPage + 1}&searchCondition=${searchCondition}&keyword=${keyword}">Next</a>
                </li>
            </c:when>
            <c:otherwise>
                <li class="page-item disabled">
                    <span class="page-link">Next</span>
                </li>
            </c:otherwise>
        </c:choose>
    </ul>
</nav>

