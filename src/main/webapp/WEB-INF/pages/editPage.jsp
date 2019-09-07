<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <c:if test="${empty img.title}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty img.title}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty img.title}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty img.title}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty img.title}">
        <input type="hidden" name="id" value="${img.id}">
    </c:if>
    <label for="title">Title</label>
    <input type="text" name="title" id="title">
    <label for="tags">tag</label>
    <input type="text" name="tags" id="tags">
    <label for="pathorurl">pathorurl</label>
    <input type="text" name="pathorurl" id="pathorurl">
    <c:if test="${empty img.title}">
        <input type="submit" value="Add new img">
    </c:if>
    <c:if test="${!empty img.title}">
        <input type="submit" value="Edit img">
    </c:if>
</form>
</body>
</html>