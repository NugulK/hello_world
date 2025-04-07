<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<div class="container mt-5">
    <div class="card p-4 shadow-lg text-center">
        <h2 class="mb-3">
            안녕하세요 <strong>${empty logId ? 'Guest' : userName}</strong>님!
        </h2>
        <p class="lead">
            현재 권한: 
            <span class="badge ${responsibility == 'User' ? 'bg-primary' : 'bg-danger'}">
                ${responsibility == 'User' ? '일반사용자' : '관리자'}
            </span>
        </p>
    </div>
</div>