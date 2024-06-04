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
      账号：<input type="text" name="username"/><br>
        <input type="submit" value="login"/>
        <%
            Object info = request.getAttribute("errorInfo");
            if(info != null){
                out.print(info);
            }
        %>
    </form>
</body>
</html>