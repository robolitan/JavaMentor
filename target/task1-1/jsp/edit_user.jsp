<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="css/tablestyle.css" rel="stylesheet">
</head>
<body>
<form action="/edit" method="post">
    <table class="redTable">
        <caption style=" border: 2px solid #A40808; background: aqua ">Edit this user</caption>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Birthday</th>
        </tr>
        <tr>
            <td>
                <input type="text" value="${requestScope.user.id}" name="id" hidden="hidden">
                <input type="text" value="${requestScope.user.firstName}" name="firstName" required="required">
            </td>
            <td>
                <input type="text" value="${requestScope.user.lastName}" name="lastName" required="required">
            </td>
            <td>
                <input type="text" value="${requestScope.user.birthday}" name="birthday"
                required="required" pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])">
                <input type="text" value="${requestScope.user.password}" name="password" hidden="hidden">
            </td>
        </tr>
        <tr><td></td>
            <td>
                <input type="submit" value="edite">
            </td>
            <td>
                <input type="button" value="cansel" onclick="history.back()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>