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
        for(Cookie cookie : cookies){
            System.out.println(cookie.getName() + ":" + cookie.getValue());
            if(cookie.getName().equals("un")){
                name = cookie.getValue();//拿到cookie中的值
            }
        }
    }else {

    }
%>

    <form action="login" method="post">
        <input type="text" name="username" value="<%=name%>"><br>
        <input type="password" name="password"><br>
        <input type="submit" value="提交">

    </form>

</body>
</html>