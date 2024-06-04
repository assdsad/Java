<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<br/>
<%
    String name = "";
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
        for(Cookie cookie : cookies) {
            if (cookie.getName().equals("un")) {
                name = cookie.getValue();
            }
        }
    }
%>


    <form action="login" method="post">
        账号：<input type="text" name="username" value="<%=name%>"><br>
        密码：<input type="password" name="password" ><br>
        <input type="submit" value="提交">

    </form>

</body>
</html>