<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/tablestyle.css" rel="stylesheet">
    <link href="/css/buttons.css" rel="stylesheet">
</head>
<body>
<form action="/admin/edit" method="post">
    <table class="table_users" align="center">
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
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Edite" class="button24">
                <input type="button" value="Cancel" onclick="history.back()" class="button24">
            </td>
        </tr>
        <caption align="bottom">EDIT USER</caption>
    </table>
</form>
</body>
</html>