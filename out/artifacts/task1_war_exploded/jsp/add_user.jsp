<html>
<head>
    <title>Title</title>
    <link href="css/teststyle.css" rel="stylesheet">
    <link href="css/buttons.css" rel="stylesheet">
</head>
<body>
    <table class="table_pricele" align="center">
        <tr><th colspan="2">CREATE USER</tr>
        <form action="/add" method="post">
        <tr>
            <td>F.Name:</td>
            <td>
                <input type="text" name="firstName" placeholder="Name" required="required"/>
            </td>
        </tr>
        <tr>
            <td>S.Name:</td>
            <td>
                <input type="text" name="lastName" placeholder="Last name" required="required"/>
            </td>
        </tr>
        <tr>
            <td>Password:</td>
            <td>
                <input type="password" name="password" placeholder="Password" required="required"/>
            </td>
        </tr>
        <tr>
        </tr>
        <tr>
            <td>Birthday:</td>
            <td>
                <input type="text" name="birthday" placeholder="0000-00-00"
                       pattern="[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])" required="required">
            </td>
        </tr>
        <tr>
            <td>
            </td>
            <td>
                <input type="submit" value="Sing up" class="button24"/>
            </td>
        </tr>
        </form>
    </table>
</body>
</html>
