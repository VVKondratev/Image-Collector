<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>imgs</title>
    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>
</head>
<h2>Imgs</h2>
<table>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>tags</th>
        <th>path</th>
    </tr>
    <c:forEach var="img" items="${imgsList}">
        <tr>
            <td>${img.id}</td>
            <td>${img.title}</td>
            <td>${img.tags}</td>
            <td>${img.pathorurl}</td>
            <td>
                <a href="/edit/${img.id}">edit</a>
                <a href="/delete/${img.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new img</a>
</body>
</html>