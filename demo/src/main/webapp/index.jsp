<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
    <form action="login" method="post">
        账号：<input type="text" name="username"><br>

        <%
            Object info = request.getAttribute("errorInfo");
            if(info != null){
                out.println(info);
            }
        %>
        <input type="submit" value="login">
    </form>
</body>
</html>