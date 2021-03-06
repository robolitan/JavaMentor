<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>TASK 1</title>
    <link href="/css/tablestyle.css" rel="stylesheet">
    <link href="/css/buttons.css" rel="stylesheet">
</head>
<body>
<table class="table_users" style="margin: auto; align-self: center">
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Birthday</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${requestScope.usersList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthday}</td>
            <td>
                <form action="/admin/delete" method="post">
                    <input type="text" value="${user.id}" name="id" hidden="hidden">
                    <input type="submit" value="Delete" class="button24">
                </form>
                <form action="/admin/edit" method="get">
                    <input type="text" value="${user.id}" name="id" hidden="hidden">
                    <input type="submit" value="  Edit  " class="button24">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <form action="/admin/add" method="get">
                <input type="submit" value="Add" class="button24">
            </form>
        </td>
    </tr>
    <caption align="bottom">USERS</caption>
</table>
</body>
</html>