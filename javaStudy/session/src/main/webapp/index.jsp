<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
    <form action="login" method="post" >
        <input type="text" name="username" /><br>
        <input type="password" name="password" /><br>
        <input type="submit" name="login" /><br>

    </form>
</body>
</html>