<%--
  Created by IntelliJ IDEA.
  User: ЗТЛ
  Date: 14.11.2019
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User page</title>
</head>
<body>
User is confirmed: ${user.firstName} ${user.lastName}
<br/>
Country: ${user.country}
<br><br/>
<a href="/user/showForm">to User form</a>
</body>
</html>
