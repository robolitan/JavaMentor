<html>
<head>
    <title>Title</title>
    <link href="css/tablestyle.css" rel="stylesheet">
</head>
<body>
<form action="/add" method="post">
    <table class="redTable" style="text-align: right">
        <caption align="bottom">CREATE NEW USER</caption>
        <tr>
            <td>Name:</td>
            <td>
                <input type="text" name="name" placeholder="Full Name" required="required"/>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <input type="password" name="password" placeholder="Password" required="required"/>
            </td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <select size="1" name="gender" required="required">
                    <option value="male">MALE</option>
                    <option value="female">FEMALE</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td>
                <input type="text" name="birthday" placeholder="0000-00-00"
                       pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])"
                       required="required">
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="submit" value="Sing up"/>
            </td>
        </tr>
    </table>
    </div>
</form>
</body>
</html>
