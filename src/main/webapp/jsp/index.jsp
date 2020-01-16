<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>TASK 1</title>
    <link href="css/tablestyle.css" rel="stylesheet">
</head>
<body>
<table class="redTable">
    <caption style=" border: 2px solid #A40808; background: aqua ">USERS</caption>
    <tr>
        <th>ID</th>
        <th>First name</th>
        <th>Last name</th>
        <th>Birthday</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${usersList}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.birthday}</td>
            <td>
                <form action="/delete" method="post">
                    <input type="text" value="${user.id}" name="id" hidden="hidden">
                    <input type="submit" value="delete">
                </form>
                <form action="/edit" method="get">
                    <input type="text" value="${user.id}" name="id" hidden="hidden">
                    <input type="submit" value="  edit  ">
                </form>
            </td>
        </tr>
    </c:forEach>
    <caption align="bottom"><a href="/add">add new user</a></caption>
</table>
</body>
</html>
