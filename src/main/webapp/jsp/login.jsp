<html>
<head>
    <title>Registration page</title>
    <link href="/css/loginstyle.css" rel="stylesheet">
</head>
<body>
<form action="/user" method="post" class="form">
    <h1>Log in</h1>
    <div class="form_group">
        <input class="form_input" placeholder = " " type="text" name="name" required/>
        <label class = "form_label">Login</label>
    </div>
    <div class="form_group">
        <input class ="form_input" placeholder = " " type="password" name="password" required>
        <label class = "form_label">Password</label>
    </div>
    <p></p>
    <input type="submit" value="Log in" class="button_01">
</form>
</div>
</body>
</html>