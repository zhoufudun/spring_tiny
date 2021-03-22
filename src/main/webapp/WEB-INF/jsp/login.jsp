<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://www.codecoord.com" %>
<h2>imya</h2>

<c:if test="${errors!=null}">
    <c:forEach items="${errors}" var="error">
        ${error.defaultMessage }<br />
    </c:forEach>
</c:if>