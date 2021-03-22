<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://www.codecoord.com" %>
<h2>imya</h2>

<c:forEach items="${users}" var="user">
    <c:out value="${user.username}"></c:out><br/>
    <c:out value="${user.age}"></c:out><br/>
</c:forEach>
